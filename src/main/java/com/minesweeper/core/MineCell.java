package com.minesweeper.core;

import lombok.NonNull;

import static com.minesweeper.core.Constants.MINE;

public class MineCell extends Cell {

    public MineCell(@NonNull final Position position) {
        super(position, true);
    }

    @Override
    public void select() throws GameOverException {
        throw new GameOverException();
    }

    @Override
    public String getValue() {
        return MINE;
    }
}
