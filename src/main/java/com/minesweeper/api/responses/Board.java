package com.minesweeper.api.responses;

import com.minesweeper.core.Cell;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Board {

    @Getter
    private List<List<BoardCell>> cells;

    public Board(final Cell[][] cells, final Integer rows, final Integer columns) {
        this.cells = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            List<BoardCell> cellList = new ArrayList<>();
            for (int column = 0; column < columns; column++) {
                final Cell cell = cells[row][column];
                cellList.add(mapToBoardCell(cell));
            }
            this.cells.add(cellList);
        }
    }

    private BoardCell mapToBoardCell(final Cell cell) {
        return new BoardCell(cell.getPosition(), cell.printValue(), cell.isRevealed());
    }
}
