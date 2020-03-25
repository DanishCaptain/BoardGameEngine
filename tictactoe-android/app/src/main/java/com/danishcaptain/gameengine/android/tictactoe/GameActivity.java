package com.danishcaptain.gameengine.android.tictactoe;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
//import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public abstract class GameActivity extends AppCompatActivity {

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameEngine engine = GameEngine.getInstance();
        engine.init(new GameBoard.Builder().initSize(11, 11).build());
        initView(engine.getGameBoard());

    }

    private void initView(GameBoard board) {
        TableLayout boardGlyph = new TableLayout(this);
//        boardGlyph.setBackgroundColor(Color.parseColor("#ffffff"));
        boardGlyph.setBackgroundColor(Color.parseColor("#000000"));
        for (int cols=0; cols<board.getCols(); cols++) {
            ViewGroup.LayoutParams rowParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TableRow rowGlyph = new TableRow(this);
            rowGlyph.setPadding(0, 0, 0, 0);
            rowGlyph.setLayoutParams(rowParams);
            boardGlyph.addView(rowGlyph);
            for (int rows=0; rows<board.getRows(); rows++) {
                Button btn = new Button(this);
                ViewGroup.LayoutParams btnParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                btn.setBackgroundColor(Color.parseColor("#ffffff"));
                btn.setLayoutParams(btnParams);
                btn.setText("X");
                btn.setClickable(true);
                btn.setPadding(0, 0, 0, 0);
                rowGlyph.addView(btn);
            }
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setContentView(boardGlyph, layoutParams);
        setContentView(R.layout.activity_game);
    }
}
