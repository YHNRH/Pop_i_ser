package com.example.pop_i_ser;

public class Hero {
    static int damage = 1;
    static int critDamage = 20;
    static int critChance = 0;
    static public int gold = 10000;

    static public int getAttack() {
        if ((int)(Math.random()*100)<=critChance){
            return (int) (damage*critDamage);
        }
        else { return damage;}
    }

    static public void addDamage(int addDamage) {
        damage += addDamage;
    }

    static public void addCritChance(int addChance) {
        critChance += addChance;
    }

    static public void addCritDamage(int addDamage) {
        if(critDamage!=100) {critDamage += addDamage;}
    }

    static public void addGold(int g) {
        gold += g;
    }

    public static void setGold(int gold) {
        Hero.gold = gold;
    }

    public static void setDamage(int damage) {
        Hero.damage = damage;
    }

    public static void setCritChance(int critChance) {
        Hero.critChance = critChance;
    }

    public static void setCritDamage(int critDamage) {
        Hero.critDamage = critDamage;
    }

    static public int getDamage() {
        return damage;
    }

    static public int getGold() {
        return gold;
    }

    static public int getCritChance() {
        return critChance;
    }

    static public int getCritDamage() {
        return critDamage;
    }
}