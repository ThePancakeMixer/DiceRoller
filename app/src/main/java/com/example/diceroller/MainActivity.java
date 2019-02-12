package com.example.diceroller;

import android.content.res.Resources;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<Dice> dices;

    HashMap<Dice,ImageView> DiceImageMap;

    LinearLayout dice_layout;

    CountDownTimer m_timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dices = new ArrayList<Dice>();
        dices.add(new Dice());
        DiceImageMap = new HashMap<Dice,ImageView>();
        DiceImageMap.put(dices.get(0),(ImageView)findViewById(R.id.dice_one));
        dice_layout = findViewById(R.id.dice);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_dice:
                if(dices.size()>2)
                    break;
                Dice new_dice = new Dice();
                ImageView new_dice_view = new ImageView(this);
                new_dice_view.setContentDescription("Dice");
                new_dice_view.setLayoutParams(new LinearLayout.LayoutParams((int)getPxFromDp(150),(int)getPxFromDp(150)));
                new_dice_view.setImageDrawable((getDrawable(new_dice.drawable_id)));
                DiceImageMap.put(new_dice,new_dice_view);
                dice_layout.addView(new_dice_view, dices.size());
                dices.add(new_dice);
                break;
            case R.id.removeDice:
                if(dices.size()<=1)
                    break;
                Dice _lastaddedDice = dices.remove(dices.size()-1);
                dice_layout.removeView(DiceImageMap.get(_lastaddedDice));
                DiceImageMap.remove(_lastaddedDice);
            default:
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void rollDice(View view) {

        if(m_timer != null)
            m_timer.cancel();

        m_timer = new CountDownTimer(2000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                for(Dice dice:dices)
                    dice.RollDice();
                ShowDice();
            }

            @Override
            public void onFinish() {
            }
        }.start();


    }

    public float getPxFromDp(float dp){
        Resources r = getResources();
        float px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                r.getDisplayMetrics()
        );
        return px;

    }

    public void ShowDice(){
        for(Dice dice:dices){
            ImageView imageView = DiceImageMap.get(dice);
            imageView.setImageDrawable(getDrawable(dice.drawable_id));
        }
    }
}
