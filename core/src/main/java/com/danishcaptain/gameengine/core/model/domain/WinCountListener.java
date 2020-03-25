package com.danishcaptain.gameengine.core.model.domain;

public interface WinCountListener {
    void setNewWinCount(int winCount);
    void markActive();
    void markInactive();
}
