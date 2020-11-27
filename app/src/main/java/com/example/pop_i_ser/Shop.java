package com.example.pop_i_ser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Shop extends AppCompatActivity {

    int goldForCC = 100;
    int goldForCD = 100;
    int goldForDA = 100;
    TextView dAmount;
    TextView cChance;
    TextView cDamage;
    TextView shopCC;
    TextView shopCD;
    TextView shopDA;
    Hero hero = new Hero();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        dAmount = findViewById(R.id.dAmount);
        cChance = findViewById(R.id.cChance);
        cDamage = findViewById(R.id.cDamage);
        shopDA = findViewById(R.id.shopDA);
        shopCD = findViewById(R.id.shopCD);
        shopCC = findViewById(R.id.shopCC);

    }

    public void dAmountClick(View view) {
        if (hero.getGold()>goldForDA){
            hero.addGold(-goldForDA);
            hero.addDamage(1);

            this.goldForDA = (int) (goldForDA*2.2);
            dAmount.setText(String.valueOf(goldForDA));
            shopDA.setText(String.valueOf(hero.getDamage()));
        }
        else{
            /*тост короче шо денег нема*/
        }
    }


    public void cDamageClick(View view) {
        if (hero.getGold()>goldForCD){
            hero.addGold(-goldForCD);
            this.goldForCD =(int) (goldForCD*5);
            cDamage.setText(String.valueOf(goldForCD));
            shopCD.setText(String.valueOf(hero.getCritDamage()));
            hero.addCritDamage(0.1);
        }
        else{
            /*тост короче шо денег нема*/
        }
    }
    public void cChanceClick(View view) {
        if (hero.getGold()>goldForCC){
            hero.addGold(-goldForCC);
            this.goldForCC = (int) (goldForCC * 12);
            cChance.setText(String.valueOf(goldForCC));
            shopCC.setText(String.valueOf(hero.getCritChance()));
            hero.addCritChance(1);
        }
        else{
            /*тост короче шо денег нема*/
        }
    }

}