package com.danishcaptain.gameengine.core.model.domain;

public interface PieceUpdateListener {
    void pieceUpdated(BoardCell boardCell, BoardPiece piece);
}
