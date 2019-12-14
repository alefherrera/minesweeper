package com.minesweeper.core;

import lombok.NonNull;

import static com.minesweeper.core.Constants.MINE;

public class MineCell extends Cell {

    public MineCell(@NonNull final Position position) {
        super(position, MINE, false);
    }

    @Override
    protected boolean innerSelect() {
        return false;
    }
}
