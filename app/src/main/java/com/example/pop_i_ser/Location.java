package com.example.pop_i_ser;

public class Location {
    public static int enemyCounter=0;
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

    static int getStage()
    {
        return stage;
    }

    public static void setStage(int stage) {
        Location.stage = stage;
    }
}
