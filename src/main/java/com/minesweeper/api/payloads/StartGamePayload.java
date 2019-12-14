package com.minesweeper.api.payloads;

import com.minesweeper.core.value.Position;
import lombok.Getter;

import java.util.Collection;

@Getter
public class StartGamePayload {
    private Integer rows;
    private Integer columns;
    private Collection<Position> mines;
}
