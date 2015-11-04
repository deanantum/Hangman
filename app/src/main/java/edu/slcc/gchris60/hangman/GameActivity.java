package edu.slcc.gchris60.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends ActionBarActivity {

    private EditText editText;
    private String input;
    private String letter;
    private String theWord = "WORD";
    private int badLetterCount;
    private int goodLetterCount;
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        badLetterCount = 0;
        goodLetterCount = 0;
        points = 0;
        //addKeyListener();
    }

    public void addKeyListener(){
        editText = (EditText) findViewById(R.id.guessLetter);
        Toast.makeText(this,"addKeyListener",Toast.LENGTH_SHORT).show();
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                //set input to String
                String input = editText.getText().toString();

                if (input.length() != 0) {
                    //verifyField(v);
                }
                return true;
            }
        });
    }

    public void newLetter(View view){
        //set input to String
        input = editText.getText().toString();

        letter = input.toUpperCase();
        editText.setText("");
        //editText.setText(letter);
        //Test if letter is getting through
        Log.d("MYLOG", "The letter is: " + letter);

        checkLetter();
    }

    public void checkLetter(){
        final Toast toast = Toast.makeText(this,"checkLetter: "+ letter, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        char aLetter = letter.charAt(0);

        boolean letterMatch = false;

        for(int i=0;i<theWord.length();i++){
            if( theWord.charAt(i) == aLetter ){
                letterMatch = true;
                Log.d("MYLOG", "Letter found: "+ aLetter);
                Toast.makeText(this,"Matched: ", Toast.LENGTH_SHORT).show();
                showLetters( i,aLetter );
            }
        }

        if(!letterMatch){
            Log.d("MYLOG","Letter NOT found "+ aLetter);
            badLetterCount++;
            wrongLetter(Character.toString(aLetter));
        }

        if( winningLength == theWord.length() ){
            Toast.makeText(this,"You Won!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,GameOverActivity.class);
            startActivity(intent);
        }

    }

    public void showLetters(int position, char c){
        //make connection to LinearLayout in activity_game
        LinearLayout layout = (LinearLayout) findViewById(R.id.layoutLetters);

        //Connect to the blank letter fields
        TextView textView = (TextView) layout.getChildAt(position);

        //replace the blank letter fields
        textView.setText(Character.toString( c ));
    }

    public void gameOver(){
        Intent intent = new Intent(this,GameOverActivity.class);
        startActivity(intent);
        clearScreen();
    }

    public void clearScreen(){
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText("");

        badLetterCount = 0;
        goodLetterCount = 0;

        LinearLayout layout = (LinearLayout) findViewById(R.id.layoutLetters);

        for(int i=0;i<layout.getChildCount();i++){
            TextView textview = (TextView) layout.getChildAt(i);
            childTextView.setText("_");
        }

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.hangdroid_0);
    }
}
