package com.example.pop_i_ser;

public class Location {
    static int enemyCounter=0;
    static int stage=1;
    static Enemy getEnemy()
    {
        if(enemyCounter==10)
        {
            enemyCounter=0;
            stage++;
        }
        enemyCounter++;
        return new Enemy(stage);
    }
}
