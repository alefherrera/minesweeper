package com.minesweeper.api.responses;

import com.minesweeper.core.GameStatus;
import lombok.Value;

@Value
public class GameResponse {
    private String id;
    private GameStatus status;
    private Board board;
}
