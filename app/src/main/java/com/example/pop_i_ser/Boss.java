package com.example.pop_i_ser;

public class Boss extends Enemy {
    public int health;
    public int gold;
    public int stage;
    int maxHealth;


    Boss(int stage) {
        super(stage);
        maxHealth=stage*30;
        health=maxHealth;
        gold=stage*50;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }
    @Override
    public int getImage() {
        return stage;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getGold() {
        return gold;
    }

    public void isAttacked(int attack) {
        this.health -= attack;
    }

}