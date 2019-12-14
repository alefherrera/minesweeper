package com.minesweeper.core;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class Board {

    private final Integer rows;
    private final Integer columns;
    private final Cell[][] cells;

    public Board(final Integer rows, final Integer columns) {
        this.rows = rows;
        this.columns = columns;
        cells = init(rows, columns);
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
        getCell(position).select();
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
