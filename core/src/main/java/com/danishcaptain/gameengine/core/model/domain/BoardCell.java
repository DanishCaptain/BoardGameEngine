package com.danishcaptain.gameengine.core.model.domain;

import com.danishcaptain.gameengine.core.model.CellAssignmentModel;
import com.danishcaptain.gameengine.core.model.IgnoreAssignmentModel;

import java.util.ArrayList;

public class BoardCell {
    private final String id;
    private String defaultDisplayValue="";
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

    public String getDefaultDisplayValue() {
        return defaultDisplayValue;
    }

    public void setDefaultDisplayValue(String defaultDisplayValue) {
        this.defaultDisplayValue = defaultDisplayValue;
        if (viewUpdateListener != null) {
            if (piece != null) {
                viewUpdateListener.setDisplayText(piece.getDisplayId());
            } else {
                viewUpdateListener.setDisplayText(getDefaultDisplayValue());
            }
        }
    }

    public void setViewUpdateListener(ViewUpdateListener lis) {
        viewUpdateListener = lis;
        if (piece != null) {
            viewUpdateListener.setDisplayText(piece.getDisplayId());
        } else {
            viewUpdateListener.setDisplayText(getDefaultDisplayValue());
        }
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public void set(BoardPiece piece) {
        this.piece = piece;
        if (viewUpdateListener != null) {
            if (piece != null) {
                viewUpdateListener.setDisplayText(piece.getDisplayId());
            } else {
                viewUpdateListener.setDisplayText(getDefaultDisplayValue());
            }
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
