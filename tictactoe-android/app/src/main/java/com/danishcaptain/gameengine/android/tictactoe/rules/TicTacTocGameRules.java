package com.danishcaptain.gameengine.android.tictactoe.rules;

import com.danishcaptain.gameengine.android.tictactoe.BoardCell;
import com.danishcaptain.gameengine.android.tictactoe.BoardPiece;
import com.danishcaptain.gameengine.android.tictactoe.EndOfGameRule;
import com.danishcaptain.gameengine.android.tictactoe.PieceUpdateListener;
import com.danishcaptain.gameengine.android.tictactoe.activity.Player;
import com.danishcaptain.gameengine.android.tictactoe.model.TicTacToePiece;

import java.util.List;

public class TicTacTocGameRules extends EndOfGameRule implements PieceUpdateListener {

    private TicTacToePiece[][] map = new TicTacToePiece[3][3];
    private boolean gameHasEnded;
    private Player winner;

    public TicTacTocGameRules(List<BoardCell> cells) {
        for (BoardCell cell : cells) {
            cell.addPieceUpdateListener(this);
        }
    }

    @Override
    public boolean hasGameEnded() {
        return gameHasEnded;
    }

    @Override
    public Player getWinner() {
        return winner;
    }

    @Override
    public void pieceUpdated(BoardCell cell, BoardPiece piece) {
        TicTacToePiece pieceT = (TicTacToePiece) piece;
        if ("1::1".equals(cell.getId())) {
            map[0][0] = pieceT;
        } else if ("1::2".equals(cell.getId())) {
            map[0][1] = pieceT;
        } else if ("1::3".equals(cell.getId())) {
            map[0][2] = pieceT;
        } else if ("2::1".equals(cell.getId())) {
            map[1][0] = pieceT;
        } else if ("2::2".equals(cell.getId())) {
            map[1][1] = pieceT;
        } else if ("2::3".equals(cell.getId())) {
            map[1][2] = pieceT;
        } else if ("3::1".equals(cell.getId())) {
            map[2][0] = pieceT;
        } else if ("3::2".equals(cell.getId())) {
            map[2][1] = pieceT;
        } else if ("3::3".equals(cell.getId())) {
            map[2][2] = pieceT;
        }
        checkWinner();
    }

    private void checkWinner() {
        try {
            if (map[0][0] != null && map[0][0].equals(map[0][1]) && map[0][0].equals(map[0][2])) {
                gameHasEnded = true;
                winner = map[0][0].getPlayer();
            }
        } catch(Exception ex) {
        }
        try {
            if (map[1][0] != null && map[1][0].equals(map[1][1]) && map[1][0].equals(map[1][2])) {
                gameHasEnded = true;
                winner = map[1][0].getPlayer();
            }
        } catch(Exception ex) {
        }
        try {
            if (map[2][0] != null && map[2][0].equals(map[2][1]) && map[2][0].equals(map[2][2])) {
                gameHasEnded = true;
                winner = map[2][0].getPlayer();
            }
        } catch(Exception ex) {
        }

        try {
            if (map[0][0] != null && map[0][0].equals(map[1][0]) && map[0][0].equals(map[2][0])) {
                gameHasEnded = true;
                winner = map[0][0].getPlayer();
            }
        } catch(Exception ex) {
        }
        try {
            if (map[0][1] != null && map[0][1].equals(map[1][1]) && map[0][1].equals(map[2][1])) {
                gameHasEnded = true;
                winner = map[0][1].getPlayer();
            }
        } catch(Exception ex) {
        }
        try {
            if (map[0][2] != null && map[0][2].equals(map[1][2]) && map[0][2].equals(map[2][2])) {
                gameHasEnded = true;
                winner = map[0][2].getPlayer();
            }
        } catch(Exception ex) {
        }

        try {
            if (map[0][0] != null && map[0][0].equals(map[1][1]) && map[0][0].equals(map[2][2])) {
                gameHasEnded = true;
                winner = map[0][0].getPlayer();
            }
        } catch(Exception ex) {
        }
        try {
            if (map[0][2] != null && map[0][2].equals(map[1][1]) && map[0][2].equals(map[2][0])) {
                gameHasEnded = true;
                winner = map[0][2].getPlayer();
            }
        } catch(Exception ex) {
        }

    }

}
