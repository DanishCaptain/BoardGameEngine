package com.danishcaptain.gameengine.android.tictactoe.rules;

import com.danishcaptain.gameengine.android.tictactoe.model.TicTacToePiece;
import com.danishcaptain.gameengine.core.model.domain.BoardCell;
import com.danishcaptain.gameengine.core.model.domain.BoardPiece;
import com.danishcaptain.gameengine.core.model.domain.GameBoard;
import com.danishcaptain.gameengine.core.model.domain.PieceUpdateListener;
import com.danishcaptain.gameengine.core.model.domain.Player;
import com.danishcaptain.gameengine.core.model.domain.rules.EndOfGameRule;

import java.util.List;

public class TicTacTocGameRules extends EndOfGameRule implements PieceUpdateListener {
    private final GameBoard board;
    private TicTacToePiece[][] map = new TicTacToePiece[3][3];

    public TicTacTocGameRules(GameBoard board, List<BoardCell> cells) {
        this.board = board;
        for (BoardCell cell : cells) {
            cell.addPieceUpdateListener(this);
        }
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
                endGame(map[0][0].getPlayer());
            }
        } catch(Exception ex) {
        }
        try {
            if (map[1][0] != null && map[1][0].equals(map[1][1]) && map[1][0].equals(map[1][2])) {
                endGame(map[1][0].getPlayer());
            }
        } catch(Exception ex) {
        }
        try {
            if (map[2][0] != null && map[2][0].equals(map[2][1]) && map[2][0].equals(map[2][2])) {
                endGame(map[2][0].getPlayer());
            }
        } catch(Exception ex) {
        }

        try {
            if (map[0][0] != null && map[0][0].equals(map[1][0]) && map[0][0].equals(map[2][0])) {
                endGame(map[0][0].getPlayer());
            }
        } catch(Exception ex) {
        }
        try {
            if (map[0][1] != null && map[0][1].equals(map[1][1]) && map[0][1].equals(map[2][1])) {
                endGame(map[0][1].getPlayer());
            }
        } catch(Exception ex) {
        }
        try {
            if (map[0][2] != null && map[0][2].equals(map[1][2]) && map[0][2].equals(map[2][2])) {
                endGame(map[0][2].getPlayer());
            }
        } catch(Exception ex) {
        }

        try {
            if (map[0][0] != null && map[0][0].equals(map[1][1]) && map[0][0].equals(map[2][2])) {
                endGame(map[0][0].getPlayer());
            }
        } catch(Exception ex) {
        }
        try {
            if (map[0][2] != null && map[0][2].equals(map[1][1]) && map[0][2].equals(map[2][0])) {
                endGame(map[0][2].getPlayer());
            }
        } catch(Exception ex) {
        }

    }

    private void endGame(Player player) {
        board.endGame(player);
    }

}
