package com.minesweeper.api.response;

import com.minesweeper.core.Board;
import com.minesweeper.core.GameStatus;
import lombok.Value;

@Value
public class GameResponse {
    private GameStatus status;
    private Board board;
}
