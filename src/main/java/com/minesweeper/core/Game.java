package com.minesweeper.core;

import lombok.Getter;

public class Game {

    @Getter
    private final Board board;

    public Game(Integer rows, Integer columns) {
        board = new Board(rows, columns);
    }

    public void addMine(final int row, final int column) {
        board.addMine(new Position(column, row));
    }

    public void select(final int row, final int column) {
        board.select(new Position(column, row));
    }
}
