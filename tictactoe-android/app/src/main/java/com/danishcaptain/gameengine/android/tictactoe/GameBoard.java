package com.danishcaptain.gameengine.android.tictactoe;

public class GameBoard {
    private int rows;
    private int columns;

    private void initSize(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return columns;
    }

    public static class Builder {
        private GameBoard board = new GameBoard();

        public Builder initSize(int rows, int columns) {
            board.initSize(rows, columns);
            return this;
        }

        public GameBoard build() {
            return board;
        }
    }

}
