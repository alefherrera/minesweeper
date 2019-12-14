package com.minesweeper.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
public abstract class Cell {

    @Getter
    @NonNull
    private final Position position;

    @Getter
    @Setter
    private String value;

    @Getter
    private boolean revealed;

    public final void select() throws GameOverException {
        revealed = innerSelect();
    }

    protected abstract boolean innerSelect() throws GameOverException;
}
