package com.danishcaptain.gameengine.core.model.domain;

public abstract class BoardPiece {
    private final String displayId;

    public BoardPiece(String displayId) {
        this.displayId = displayId;
    }

    public String getDisplayId() {
        return displayId;
    }

}
