package com.danishcaptain.gameengine.android.tictactoe.activity;

import com.danishcaptain.gameengine.android.tictactoe.BoardCell;

public abstract class CellRule extends Rule {
    public abstract boolean isValid(BoardCell cell);
}
