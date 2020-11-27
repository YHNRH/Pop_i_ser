package com.example.pop_i_ser;

public class Enemy {
    public int health;
    public int gold;
    public int stage;
    public Enemy(int stage)
    {
        this.stage = stage;
        health = stage*10 ;
        gold   = stage*5  ;
    }

    public void isAttacked(int attack) {
        this.health -= attack;
    }

    public int getHealth()
    {
        return health;
    }


    public int getImage() {
        return (int) ((Math.random()*3)+(stage*3));
    }
}

