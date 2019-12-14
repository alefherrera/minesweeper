package com.minesweeper.core;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Board {

    @Getter
    private List<List<Cell>> cells;

    public Board(final Cell[][] cells, final Integer rows, final Integer columns) {
        this.cells = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            List<Cell> cellList = new ArrayList<>();
            for (int column = 0; column < columns; column++) {
                cellList.add(cells[row][column]);
            }
            this.cells.add(cellList);
        }
    }
}
