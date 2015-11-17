package edu.slcc.gchris60.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MultiplayerActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);
    }

    public void playMultiplayer(View view){
        EditText editText = (EditText) findViewById(R.id.editTextWord);
        String wordToGuess = editText.getText().toString();

        Log.d("MYLOG", "Multiplayer Word: " + wordToGuess);
        Intent intent = new Intent(this,GameMultiActivity.class);

        intent.putExtra("GUESS_WORD", wordToGuess);
        startActivity(intent);
    }

}
