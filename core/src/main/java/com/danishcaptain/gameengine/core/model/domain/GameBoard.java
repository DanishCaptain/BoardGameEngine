package com.danishcaptain.gameengine.core.model.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class GameBoard {
    private final HashMap<String, BoardCell> cellsM = new HashMap<>();
    private final ArrayList<BoardCell> cellsL = new ArrayList<>();
    private final RulesEngine rulesEngine = new RulesEngine(this);
    private int rows;
    private int columns;
    private PlayerModel playerModel = new PlayerModel();
    private boolean gameEnded;
    private Player winner;

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

    /*
    public void checkWins() {
        if (gameEnded) {
            Player winner = rulesEngine.getWinner();
            if (winner == null) {
                System.out.println("it is a draw");
            } else {
                System.out.println("winner: "+winner.getCellDisplayText());
            }
        }
    }
     */

    public boolean hasGameEnded() {
        return gameEnded;
    }

    public void endGame(Player player) {
        gameEnded = true;
        winner = player;
        player.markWin();
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
