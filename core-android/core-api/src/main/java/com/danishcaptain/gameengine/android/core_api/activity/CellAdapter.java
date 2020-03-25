package com.danishcaptain.gameengine.android.core_api.activity;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.danishcaptain.gameengine.core.model.domain.BoardCell;
import com.danishcaptain.gameengine.core.model.domain.GameBoard;
import com.danishcaptain.gameengine.core.model.domain.ViewUpdateListener;

public class CellAdapter implements View.OnTouchListener, ViewUpdateListener {
    private final GameBoard board;
    private final BoardCell cell;
    private final Button button;

    public CellAdapter(GameBoard board, BoardCell cell, Button button) {
        this.board = board;
        this.cell = cell;
        this.button = button;
        cell.setViewUpdateListener(this);
        button.setText(cell.getDefaultDisplayValue());
        button.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (!board.hasGameEnded()) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                board.setSelected(cell);
            }
        }
        return true;
    }

    @Override
    public void setDisplayText(String cellDisplayText) {
        button.setText(cellDisplayText);
    }
}
