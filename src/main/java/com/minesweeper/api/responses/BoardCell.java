package com.minesweeper.api.responses;

import com.minesweeper.core.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class BoardCell {
    @NonNull
    private Position position;
    private String value;
    @NonNull
    private boolean revealed;
}
