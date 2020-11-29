package com.example.pop_i_ser;

public class Enemy {
    public int health;
    int max_health;
    public int gold;
    public int stage;
    int image;
    public Enemy(int stage)
    {
        this.stage = stage;
        max_health = stage*10 ;
        health=max_health;
        gold   = stage*5  ;
        image = (int) ((Math.random()*2)+(stage*2));}

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

    public int getGold()
    {
        return gold;
    }

    public int getImage() {
        return image;
    }
}

