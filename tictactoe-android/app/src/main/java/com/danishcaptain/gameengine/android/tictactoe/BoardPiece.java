package com.danishcaptain.gameengine.android.tictactoe;

public abstract class BoardPiece {
    private final String displayId;

    public BoardPiece(String displayId) {
        this.displayId = displayId;
    }

    public String getDisplayId() {
        return displayId;
    }
}
