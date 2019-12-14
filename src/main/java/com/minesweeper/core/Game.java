package com.minesweeper.core;

public class Game {

    private final Board board;

    public Game(Integer rows, Integer columns) {
        board = new Board(rows, columns);
    }

    public Board addMine(final int row, final int column) {
        return board.addMine(new Position(column, row));
    }

}
