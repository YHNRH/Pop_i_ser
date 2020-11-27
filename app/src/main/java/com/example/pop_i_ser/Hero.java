package com.example.pop_i_ser;

public class Hero {
    static int damage = 1;
    static double critDamage = 2.0;
    static int critChance = 0;
    static public int gold = 10000000;

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

    static public void addCritDamage(double addDamage) {
        if(critDamage!=100.0) {critDamage += addDamage;}
    }

    static public void addGold(int gold) {
        gold += gold;
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

    static public double getCritDamage() {
        return critDamage;
    }
}