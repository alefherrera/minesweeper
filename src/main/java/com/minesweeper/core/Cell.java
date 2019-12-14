package com.minesweeper.core;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Cell {

    @Getter
    @NonNull
    private final Position position;

}
