package com.minesweeper.core;

import lombok.Getter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class Game {

    @Getter
    private final Integer rows;
    @Getter
    private final Integer columns;
    @Getter
    private final Cell[][] cells;
    @Getter
    private GameStatus status;

    public Game(final Integer rows, final Integer columns) {
        this.rows = rows;
        this.columns = columns;
        cells = init(rows, columns);
        status = GameStatus.PLAYING;
    }

    private Cell[][] init(final Integer rows, final Integer columns) {
        final Cell[][] cells = new Cell[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                cells[row][column] = new SafeCell(this, new Position(column, row));
            }
        }
        return cells;
    }

    public Cell getCell(Position position) {
        return getCell(position.getX(), position.getY());
    }

    public void addMine(Position position) {
        cells[position.getX()][position.getY()] = new MineCell(position);
    }

    public void select(final Position position) {
        try {
            getCell(position).select();
        } catch (GameOverException e) {
            endGame();
        }
    }

    private void endGame() {
        status = GameStatus.GAME_OVER;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                getCell(column, row).setRevealed();
            }
        }
    }

    Collection<Cell> getNeighbours(final Position position) {
        final Integer x = position.getX();
        final Integer y = position.getX();
        Collection<Cell> result = new HashSet<>();
        for (int row = x - 1; row < x + 1; row++) {
            for (int column = y - 1; column < y + 1; column++) {
                final Cell cell = getCell(column, row);
                if (Objects.nonNull(cell) && !cell.getPosition().equals(position)) {
                    result.add(cell);
                }
            }
        }
        return result;
    }

    private Cell getCell(final int column, final int row) {
        if (row < 0 || row > rows) {
            return null;
        }
        if (column < 0 || column > columns) {
            return null;
        }
        return cells[column][row];
    }
}
