package com.minesweeper.core;

import java.util.Collection;

public class SafeCell extends Cell {

    private final Game game;

    public SafeCell(final Game game, final Position position) {
        super(position, false);
        this.game = game;
    }

    @Override
    public String getValue() {
        final Collection<Cell> neighbours = game.getNeighbours(getPosition());
        final long mines = neighbours.stream().filter(Cell::isHasMine).count();
        return String.valueOf(mines);
    }

}
