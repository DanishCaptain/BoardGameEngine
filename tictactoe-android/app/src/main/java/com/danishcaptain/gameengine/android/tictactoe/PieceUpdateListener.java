package com.danishcaptain.gameengine.android.tictactoe;

public interface PieceUpdateListener {
    void pieceUpdated(BoardCell boardCell, BoardPiece piece);
}
