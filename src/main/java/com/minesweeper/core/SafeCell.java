package com.minesweeper.core;

import java.util.Collection;

import static com.minesweeper.core.Constants.MINE;

public class SafeCell extends Cell {

    private final Board board;

    public SafeCell(final Board board, final Position position) {
        super(position);
        this.board = board;
    }

    @Override
    protected boolean innerSelect() {
        final Collection<Cell> neighbours = board.getNeighbours(getPosition());
        final long mines = neighbours.stream().filter(cell -> MINE.equals(cell.getValue())).count();
        setValue(String.valueOf(mines));
        return true;
    }
}
