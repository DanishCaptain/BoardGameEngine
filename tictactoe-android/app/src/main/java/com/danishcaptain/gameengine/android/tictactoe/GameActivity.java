package com.danishcaptain.gameengine.android.tictactoe;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
//import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public abstract class GameActivity extends AppCompatActivity {

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameEngine engine = GameEngine.getInstance();
        engine.init(new GameBoard.Builder().initSize(getRowCount(), getColumnCount()).build());
        initView(engine.getGameBoard());
        initBoard(engine.getGameBoard());
        initRules(engine.getGameBoard());

    }

    protected abstract void initBoard(GameBoard gameBoard);

    protected abstract void initRules(GameBoard gameBoard);

    protected abstract int getRowCount();
    protected abstract int getColumnCount();

    private void initView(GameBoard board) {
        TableLayout boardTL = new TableLayout(this);
        //ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
       // boardTL.setLayoutParams(layoutParams);
//        boardGlyph.setBackgroundColor(Color.parseColor("#ffffff"));
        boardTL.setBackgroundColor(Color.parseColor("#000000"));
        for (int cols=0; cols<board.getCols(); cols++) {
            TableRow.LayoutParams rowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
            TableRow rowTR = new TableRow(this);
            boardTL.addView(rowTR);
            rowTR.setBackgroundColor(Color.parseColor("#224488"));
//            rowGlyph.setPadding(0, 0, 0, 0);
            rowTR.setLayoutParams(rowParams);
            for (int rows=0; rows<board.getRows(); rows++) {
                BoardCell cell = board.lookupCell(rows, cols);
                Button btnC = new Button(this);
                rowTR.addView(btnC);
                CellAdapter mgr = new CellAdapter(board, cell, btnC);
                btnC.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1));
                btnC.setClickable(true);
//                btn.setPadding(0, 0, 0, 0);
            }
        }

        ScrollView scrollView = new ScrollView(this);
        scrollView.setBackgroundColor(Color.parseColor("#ff4488"));
        scrollView.addView(boardTL);
        setContentView(scrollView);
//        setContentView(R.layout.activity_game);
    }
}
