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

    protected void select() {

    }
}
