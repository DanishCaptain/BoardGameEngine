package com.danishcaptain.gameengine.core.model;

public final class GameEngine {
    private static GameEngine singleton;
    private GameBoard board;

    public void init(GameBoard board) {
        this.board = board;
    }

    public GameBoard getGameBoard() {
        return board;
    }

    public synchronized static GameEngine getInstance() {
        if (singleton == null) {
            singleton = new GameEngine();
        }
        return singleton;
    }

}
