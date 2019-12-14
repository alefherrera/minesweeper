package com.minesweeper.core;

public class Board {

    private final Integer rows;
    private final Integer columns;
    private final Cell[][] cells;

    public Board(final Integer rows, final Integer columns) {
        this.rows = rows;
        this.columns = columns;
        cells = new Cell[rows][columns];
    }

    public Cell getCell(Position position) {
        return cells[position.getX()][position.getY()];
    }

    public Board addMine(Position position) {
        cells[position.getX()][position.getY()] = new MineCell(position);
        return this;
    }

}
