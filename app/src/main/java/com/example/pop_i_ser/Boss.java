package com.example.pop_i_ser;

public class Boss extends Enemy {
    public int amountOfHealth;
    public int amountOfGold;
    public int image;
    public int stage;
    public Boss(int stage) {
        super(stage);
    }


    @Override
    public int getImage() {
        return 1;
    }
}