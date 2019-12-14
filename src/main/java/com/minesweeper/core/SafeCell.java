package com.minesweeper.core;

import java.util.Collection;

import static com.minesweeper.core.Constants.MINE;

public class SafeCell extends Cell {

    private final Game game;

    public SafeCell(final Game game, final Position position) {
        super(position);
        this.game = game;
    }

    @Override
    protected boolean innerSelect() {
        final Collection<Cell> neighbours = game.getNeighbours(getPosition());
        final long mines = neighbours.stream().filter(cell -> MINE.equals(cell.getValue())).count();
        setValue(String.valueOf(mines));
        return true;
    }
}
