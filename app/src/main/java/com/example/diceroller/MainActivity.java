package com.example.diceroller;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    Dice dice;

    ImageView DiceOne;

    CountDownTimer m_timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dice = new Dice();
        DiceOne = findViewById(R.id.dice_one);
    }

    public void rollDice(View view) {

        if(m_timer != null)
            m_timer.cancel();

        m_timer = new CountDownTimer(2000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                dice.RollDice();
                ShowDice();
            }

            @Override
            public void onFinish() {
            }
        }.start();


    }

    public void ShowDice(){
        DiceOne.setImageDrawable(getDrawable(dice.drawable_id));
    }
}
