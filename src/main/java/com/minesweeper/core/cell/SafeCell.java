package com.minesweeper.core.cell;

import com.minesweeper.core.Game;
import com.minesweeper.core.GameOverException;
import com.minesweeper.core.value.Position;

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

    @Override
    public void select() throws GameOverException {
        final Collection<Cell> neighbours = game.getNeighbours(getPosition());
        final boolean allSafe = neighbours.stream().allMatch(cell -> "0".equals(cell.getValue()));
        super.select();
        if (allSafe) {
            for (Cell neighbour : neighbours) {
                neighbour.select();
            }
        }
    }
}
