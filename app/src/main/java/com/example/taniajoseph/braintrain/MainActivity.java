package com.example.taniajoseph.braintrain;

import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView timer;
    TextView ques;
    TextView score;
    Button button;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    TextView blah;
    int loc;
    Button playA;


    Random rand = new Random();


    int a = rand.nextInt(20);
    int b = rand.nextInt(20);

    int scores = 0;
    int num = 0;


    public void onGo(View view) {



        playAgain(findViewById(R.id.playA));

        timer.setVisibility(View.VISIBLE);
        ques.setVisibility(View.VISIBLE);

        score.setVisibility(View.VISIBLE);
        button.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);


    }


    ArrayList<Integer> ans = new ArrayList<Integer>();

    public void playAgain(View view){

        scores = 0;
        num = 0;

        timer.setText("30s");
        score.setText("0/0");
        blah.setVisibility(View.INVISIBLE);
        playA.setVisibility(View.INVISIBLE);

        genQues();

        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(millisUntilFinished/1000) + "s" );
            }

            @Override
            public void onFinish() {
                timer.setText("0s");
                playA.setVisibility(View.VISIBLE);
                blah.setVisibility(View.VISIBLE);
                blah.setText("Your Score : " + Integer.toString(scores) + "/" + Integer.toString(num));

            }
        }.start();
    }

    public void genQues(){
        Random rand = new Random();


        int a = rand.nextInt(20);
        int b = rand.nextInt(20);

        ques.setText(Integer.toString(a) + " + " + Integer.toString(b));


            loc = rand.nextInt(4);

            ans.clear();

            int incAns;

            for (int i = 0; i < 4; i++) {
                if (i == loc) {
                    ans.add(a + b);
                } else {
                    incAns = rand.nextInt(40);
                    while (incAns == a + b) {
                        incAns = rand.nextInt(40);
                    }
                    ans.add(incAns);
                }
            }


        button1.setText(Integer.toString(ans.get(0)));
        button2.setText(Integer.toString(ans.get(1)));
        button3.setText(Integer.toString(ans.get(2)));
        button4.setText(Integer.toString(ans.get(3)));


    }

    public void chooseAns(View view){

        num++;


        if(view.getTag().toString().equals(Integer.toString(loc))){
            scores++;
            blah.setText("Correct!");
            blah.setVisibility(View.VISIBLE);

            }

        else
        {
            blah.setText("Wrong!");
            blah.setVisibility(View.VISIBLE);
        }

        score.setText(Integer.toString(scores) + "/" + Integer.toString(num));
        genQues();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = (TextView) findViewById(R.id.timerText);
        timer.setVisibility(View.INVISIBLE);



        ques = (TextView) findViewById(R.id.ques);
        ques.setVisibility(View.INVISIBLE);


        score = (TextView) findViewById(R.id.scoreCard);
        score.setVisibility(View.INVISIBLE);

        button = (Button) findViewById(R.id.button8);
        button.setVisibility(View.VISIBLE);

        button1 = (Button) findViewById(R.id.button);
        button1.setVisibility(View.INVISIBLE);

        button2 = (Button) findViewById(R.id.button7);
        button2.setVisibility(View.INVISIBLE);

        button3 = (Button) findViewById(R.id.button6);
        button3.setVisibility(View.INVISIBLE);

        button4 = (Button) findViewById(R.id.button5);
        button4.setVisibility(View.INVISIBLE);

        blah = (TextView) findViewById(R.id.bleh);
        blah.setVisibility(View.INVISIBLE);

        playA = findViewById(R.id.playA);
        playA.setVisibility(View.INVISIBLE);

    }
}
