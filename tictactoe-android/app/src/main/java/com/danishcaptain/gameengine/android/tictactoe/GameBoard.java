package com.danishcaptain.gameengine.android.tictactoe;

import com.danishcaptain.gameengine.android.tictactoe.activity.Player;
import com.danishcaptain.gameengine.android.tictactoe.activity.PlayerModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameBoard {
    private final HashMap<String, BoardCell> cellsM = new HashMap<>();
    private final ArrayList<BoardCell> cellsL = new ArrayList<>();
    private final RulesEngine rulesEngine = new RulesEngine(this);
    private int rows;
    private int columns;
    private PlayerModel playerModel = new PlayerModel();

    private void initSize(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                String id = createIdFromIndex(i, j);
                BoardCell cell = new BoardCell(id);
                cellsM.put(id, cell);
                cellsL.add(cell);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return columns;
    }

    public BoardCell lookupCell(int row, int col) {
        String id = createIdFromIndex(row, col);
        return cellsM.get(id);
    }

    public List<BoardCell> getCells() {
        return cellsL;
    }

    private String createIdFromIndex(int row, int col) {
        return (row+1)+"::"+(col+1);
    }

    public void setSelected(BoardCell cell) {
        if (rulesEngine.isSelectedValid(cell)) {
            rulesEngine.select(cell);
        }
    }

    public RulesEngine getRules() {
        return rulesEngine;
    }

    public PlayerModel getPlayerModel() {
        return playerModel;
    }

    public void checkWins() {
        boolean isGameOver = rulesEngine.checkForEndOfGame();
        if (isGameOver) {
            Player winner = rulesEngine.getWinner();
            if (winner == null) {
                System.out.println("it is a draw");
            } else {
                System.out.println("winner: "+winner.getCellDisplayText());
            }
        }
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
