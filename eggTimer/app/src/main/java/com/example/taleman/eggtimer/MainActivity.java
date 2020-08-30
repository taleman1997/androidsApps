package com.example.taleman.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView eggTimerTextView;
    SeekBar eggTimerSeekBar;
    boolean counterActivity = false;
    Button eggTimerbutton1;
    CountDownTimer eggCountDownTimer;


    public void  ResetTimer() {
        counterActivity = false;
        eggTimerbutton1.setText("START");
        eggCountDownTimer.cancel();
        eggTimerTextView.setText("00:10");
        eggTimerSeekBar.setEnabled(true);
        eggTimerSeekBar.setProgress(10);
    }
    public void Starting(View view){
        if(counterActivity){
            ResetTimer();
        }

        else{
            eggTimerSeekBar.setEnabled(false);
            eggTimerbutton1.setText("STOP");
            counterActivity = true;
            eggCountDownTimer = new CountDownTimer(eggTimerSeekBar.getProgress() * 1000, 1000) {
                @Override
                public void onTick(long l) {
                    UpdateTimer((int) l / 1000);
                }

                @Override
                public void onFinish() {

                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.nana);
                    mediaPlayer.start();
                    ResetTimer();

                }
            }.start();
        }

    }

    public void UpdateTimer(int secondLeft){
        int minNumber = secondLeft / 60;
        int secNumber = secondLeft - (minNumber * 60);
        String min;
        String sec;

        if(minNumber < 10){
            min = "0" + Integer.toString(minNumber);
        }else {
            min = Integer.toString(minNumber);
        }

        if(secNumber < 10){
            sec = "0" + Integer.toString(secNumber);
        }else {
            sec = Integer.toString(secNumber);
        }
        eggTimerTextView.setText(min + ":" + sec);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        eggTimerSeekBar = findViewById(R.id.eggTimerSeekBar);
        eggTimerTextView = findViewById(R.id.eggTextView2);
        eggTimerbutton1 = findViewById(R.id.eggTimerbutton1);

        eggTimerSeekBar.setMax(600);
        eggTimerSeekBar.setProgress(10);

        eggTimerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                UpdateTimer(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
