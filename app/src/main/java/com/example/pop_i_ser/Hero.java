package com.example.pop_i_ser;

public class Hero {
    int damage = 1;
    double critDamage = 2.0;
    int critChance = 0;
    public int gold = 10000000;

    public int getAttack() {
        if ((int)(Math.random()*100)<=critChance){
            return (int) (damage*critDamage);
        }
        else { return damage;}
    }

    public void addDamage(int addDamage) {
        this.damage += addDamage;
    }

    public void addCritChance(int addChance) {
        this.critChance += addChance;
    }

    public void addCritDamage(double addDamage) {
        if(critDamage!=100.0) {this.critDamage += addDamage;}
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public int getDamage() {
        return damage;
    }

    public int getGold() {
        return gold;
    }

    public int getCritChance() {
        return critChance;
    }

    public double getCritDamage() {
        return critDamage;
    }
}