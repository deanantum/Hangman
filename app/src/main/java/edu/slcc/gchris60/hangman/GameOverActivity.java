package edu.slcc.gchris60.hangman;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameOverActivity extends ActionBarActivity {

    private int points;
    private String word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        points = getIntent().getIntExtra("pointsID",0); //defaults at 0 if no data retrieved
        word = getIntent().getStringExtra("wordID");

        TextView textView = (TextView) findViewById(R.id.pointsBox);
        textView.setText(String.valueOf(points) +" Points");

        TextView textView2 = (TextView) findViewById(R.id.finalAnswerBox);
        textView2.setText(word);
    }
}
