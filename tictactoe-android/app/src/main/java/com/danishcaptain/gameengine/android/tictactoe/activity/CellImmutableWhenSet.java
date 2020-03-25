package com.danishcaptain.gameengine.android.tictactoe.activity;

import com.danishcaptain.gameengine.android.tictactoe.BoardCell;

public class CellImmutableWhenSet extends CellRule {
    @Override
    public boolean isValid(BoardCell cell) {
        return cell.isEmpty();
    }
}
