package com.danishcaptain.gameengine.core.model.domain;

import com.danishcaptain.gameengine.core.model.CellAssignmentModel;
import com.danishcaptain.gameengine.core.model.IgnoreAssignmentModel;

import java.util.ArrayList;

public class BoardCell {
    private final String id;
    private ViewUpdateListener viewUpdateListener;
    private BoardPiece piece;
    private CellAssignmentModel assignmentModel = new IgnoreAssignmentModel();
    private ArrayList<PieceUpdateListener> pieceUpdateListenerL = new ArrayList<>();

    public BoardCell(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setViewUpdateListener(ViewUpdateListener lis) {
        viewUpdateListener = lis;
        if (piece != null) {
            viewUpdateListener.setDisplayText(piece.getDisplayId());
        }
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public void set(BoardPiece piece) {
        this.piece = piece;
        if (viewUpdateListener != null) {
            viewUpdateListener.setDisplayText(piece.getDisplayId());
        }
        for (PieceUpdateListener lis : pieceUpdateListenerL) {
            lis.pieceUpdated(this, piece);
        }
    }

    public void addPieceUpdateListener(PieceUpdateListener lis) {
        pieceUpdateListenerL.add(lis);
    }

    public void setSelectionModel(CellAssignmentModel assignmentModel) {
        this.assignmentModel = assignmentModel;
    }

    public void selectCell() {
        assignmentModel.select(this);
    }

}
