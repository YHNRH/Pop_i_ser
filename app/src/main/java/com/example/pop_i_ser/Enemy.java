package com.example.pop_i_ser;

public class Enemy {
    public int health;
    int max_health;
    public int gold;
    public int stage;
    public Enemy(int stage)
    {
        this.stage = stage;
        max_health = stage*10 ;
        health=max_health;
        gold   = stage*5  ;
    }

    public void isAttacked(int attack) {
        this.health -= attack;
    }

    public int getHealth()
    {
        return health;
    }

    public int getMaxHealth()
    {
        return max_health;
    }


    public int getImage() {
        return (int) ((Math.random()*3)+(stage*3));
    }
}

