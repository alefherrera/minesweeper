package com.minesweeper.core;

public class FlagCellDecorator extends Cell {

    private final Cell cell;

    public FlagCellDecorator(Cell cell) {
        super(cell.getPosition(), cell.isRevealed(), cell.isHasMine());
        this.cell = cell;
    }

    @Override
    public void select() throws GameOverException {
        cell.select();
    }

    @Override
    public String getValue() {
        return cell.getValue();
    }

    @Override
    public String printValue() {
        return cell.isRevealed() ? cell.getValue() : "?";
    }

    @Override
    public Cell flag() {
        return cell;
    }
}
