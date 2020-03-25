package com.danishcaptain.gameengine.android.tictactoe.activity;

public interface WinCountListener {
    void setNewWinCount(int winCount);
    void markActive();
    void markInactive();
}
