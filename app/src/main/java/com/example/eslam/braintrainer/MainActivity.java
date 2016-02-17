package com.example.eslam.braintrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView counter;
    TextView ques ;
    TextView state;
    TextView scoreTxt;
    int locationOfCorrectAnswer;
    ArrayList<Integer>answers = new ArrayList<Integer>();
    int inCorrectAnswer;
    Button playAgian;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    int score =0 ;
    int noOfQuest = 0;

  //call every time you need to generate questition!
    public void generateQues() {
        //declare random variabel to SUM
             Random rand = new Random();
            int a = rand.nextInt(21);
            int b = rand.nextInt(21);
            ques.setText(a + " + " + b);

            //create randm Answere
            locationOfCorrectAnswer = rand.nextInt(4);
            answers.clear();

            for (int i =0 ; i<4 ; i++) {
                if (i == locationOfCorrectAnswer) {
                    answers.add(a + b);
                } else {
                    inCorrectAnswer = rand.nextInt(41);
                    while (inCorrectAnswer == a + b) {
                        inCorrectAnswer = rand.nextInt(41);
                    }
                    answers.add(inCorrectAnswer);
                }
            }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    //called when button clicked
    public void chooseAnswer (View view ){
        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer)))
        {
            score++;
           state.setText("Correct ");

        }
        else {
            state.setText("Wrong!");
        }
        noOfQuest++;
        scoreTxt.setText(Integer.toString(score) + " / " + Integer.toString(noOfQuest));
        generateQues();
    }

     //play Again button ---------------------------------------
    public void playAgain(final View view){
        score = 0;
        noOfQuest=0;
        counter.setText(30+"s");
        state.setText("");
        playAgian.setVisibility(view.INVISIBLE);
        generateQues();

        CountDownTimer timer = new CountDownTimer(30100,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                counter.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                counter.setText("0s");
                state.setText("Your Score is "+Integer.toString(score) + " / " + Integer.toString(noOfQuest));
                playAgian.setVisibility(View.VISIBLE);

            }
        }.start();

    }


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Layout Views----------------
         ques =(TextView)findViewById(R.id.ques);
        button0=(Button)findViewById(R.id.button0);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        state =(TextView)findViewById(R.id.state);
        counter=(TextView)findViewById(R.id.counter);
        scoreTxt=(TextView)findViewById(R.id.scoreTxt);
        playAgian=(Button)findViewById(R.id.playAgain);
        generateQues();
        playAgain(playAgian);


    }



}
