package com.example.taleman.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button brainTrainerGoButton;

    ArrayList<Integer> answers = new ArrayList<Integer>();

    int rightPosition;

    public void Start (View view){
        brainTrainerGoButton.setVisibility(View.INVISIBLE);
    }

    public void ChooseAnswer (View view) {
        Toast.makeText(getApplicationContext(),view.getTag().toString(),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brainTrainerGoButton = findViewById(R.id.brainTrainerGoButton);

        Button brainTrainerAnswerButton0 = findViewById(R.id.brainTrainerAnswerButton0);
        Button brainTrainerAnswerButton1 = findViewById(R.id.brainTrainerAnswerButton1);
        Button brainTrainerAnswerButton2 = findViewById(R.id.brainTrainerAnswerButton2);
        Button brainTrainerAnswerButton3 = findViewById(R.id.brainTrainerAnswerButton3);

        TextView brainTrainerQuestionTextView = findViewById(R.id.brainTrainerQuestionTextView);

        Random randomNumber = new Random();
        int a = randomNumber.nextInt(50);
        int b = randomNumber.nextInt(50);
        rightPosition = randomNumber.nextInt(4);

        brainTrainerQuestionTextView.setText(Integer.toString(a) + "+" + Integer.toString(b) );

        for (int i = 0; i<=3; i++){
            if(i == rightPosition){
                answers.add(a+b);
            }else {
                int wrongAnswer = randomNumber.nextInt(101);
                while(wrongAnswer == a+b){
                    wrongAnswer = randomNumber.nextInt(101);
                }
                answers.add(wrongAnswer);
            }
        }

        brainTrainerAnswerButton0.setText(Integer.toString(answers.get(0)));
        brainTrainerAnswerButton1.setText(Integer.toString(answers.get(1)));
        brainTrainerAnswerButton2.setText(Integer.toString(answers.get(2)));
        brainTrainerAnswerButton3.setText(Integer.toString(answers.get(3)));

    }
}
