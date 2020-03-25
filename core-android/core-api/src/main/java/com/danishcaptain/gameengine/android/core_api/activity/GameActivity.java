package com.danishcaptain.gameengine.android.core_api.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.danishcaptain.gameengine.core.model.GameEngine;
import com.danishcaptain.gameengine.core.model.domain.BoardCell;
import com.danishcaptain.gameengine.core.model.domain.GameBoard;

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
        LinearLayout appLL = new LinearLayout(this);
        ViewGroup.LayoutParams appParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        appLL.setLayoutParams(appParams);
        appLL.setOrientation(LinearLayout.VERTICAL);

        LinearLayout playersLL = new LinearLayout(this);
        ViewGroup.LayoutParams playersParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        playersLL.setLayoutParams(playersParams);
        appLL.addView(playersLL);
        TextView p1View = new TextView(this);
        p1View.setText("Player 1: ");
        playersLL.addView(p1View);
        TextView p1Count = new TextView(this);
        new WinCountAdapter(board.getPlayerModel(), 1, p1View, p1Count);
        playersLL.addView(p1Count);
        TextView p2View = new TextView(this);
        p2View.setText("      "+"Player 2: ");
        playersLL.addView(p2View);
        TextView p2Count = new TextView(this);
        new WinCountAdapter(board.getPlayerModel(), 2, p2View, p2Count);
        playersLL.addView(p2Count);

        LinearLayout winLL = new LinearLayout(this);
        ViewGroup.LayoutParams winParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        winLL.setLayoutParams(winParams);
        appLL.addView(winLL);

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
        appLL.addView(scrollView);

        setContentView(appLL);
//        setContentView(R.layout.activity_game);
    }
}
