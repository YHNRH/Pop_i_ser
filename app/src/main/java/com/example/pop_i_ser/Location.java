package com.example.pop_i_ser;

public class Location {
    public static int enemyCounter=0;
    static int stage=1;
    static Enemy getEnemy()
    {
        if(enemyCounter==10){
            enemyCounter++;
            return new Boss(stage);
        }
        else if(enemyCounter==11)
        {
            enemyCounter=0;
            stage++;
            return new Enemy(stage);
        } else {
            enemyCounter++;
            return new Enemy(stage);
        }
    }

    static int getStage()
    {
        return stage;
    }

    public static void setStage(int stage) {
        Location.stage = stage;
    }

    public static int getEnemyCounter() {
        return enemyCounter;
    }
}
