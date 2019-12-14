package com.minesweeper.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void test2x2() {
        final Game game = new Game(2, 2);
        final Board board = game.addMine(0, 0);
        final Cell cell = board.getCell(new Position(0, 0));
        assertEquals(cell.getClass(), MineCell.class);
    }

}