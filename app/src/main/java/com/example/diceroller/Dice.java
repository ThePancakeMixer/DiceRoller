package com.example.diceroller;

import java.util.Random;

public class Dice {

    public int drawable_id;

    private Random random;

    private int number;

    public Dice(int num){

        random = new Random();
        number = num;
        setDrawable_id();
    }

    public Dice(){
        random = new Random();
        number = random.nextInt()%6+1;
        setDrawable_id();
    }


    public void setDrawable_id(){

        switch (number){
            case 1:
                drawable_id = R.drawable.ic_one;
                break;
            case 2:
                drawable_id = R.drawable.ic_two;
                break;
            case 3:
                drawable_id = R.drawable.ic_three;
                break;
            case 4:
                drawable_id = R.drawable.ic_four;
                break;
            case 5:
                drawable_id = R.drawable.ic_five;
                break;
            case 6:
                drawable_id = R.drawable.ic_six;
                break;
            default:
                drawable_id = R.drawable.ic_one;
                break;
        }
    }

    public void RollDice(){
        number = random.nextInt()%6+1;
        setDrawable_id();
    }

}
