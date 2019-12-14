package com.minesweeper.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public abstract class Cell {

    @Getter
    @NonNull
    private final Position position;

    @Getter
    private boolean revealed;

    @Getter
    @NonNull
    private boolean hasMine;

    public void setRevealed() {
        revealed = true;
    }

    public void select() throws GameOverException {
        revealed = true;
    }

    public abstract String getValue();

}
