package com.minesweeper.api.responses;

import com.minesweeper.core.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BoardCell {
    private Position position;
    private String value;
    private boolean revealed;
}
