package com.example.pop_i_ser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Shop extends AppCompatActivity {

    int goldForCC = 100;
    int goldForCD = 100;
    int goldForDA = 100;
    TextView shopCC;
    TextView shopCD;
    TextView shopDA;
    Button damage;
    Button chance;
    Button crit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        shopDA = findViewById(R.id.shopDA);
        shopCD = findViewById(R.id.shopCD);
        shopCC = findViewById(R.id.shopCC);
        damage = findViewById(R.id.damage);
        chance = findViewById(R.id.chance);
        crit = findViewById(R.id.crit);
        shopDA.setText(String.valueOf(Hero.getDamage()));
        shopCC.setText(String.valueOf(Hero.getCritChance()));
        shopCD.setText(String.valueOf(Hero.getCritDamage()));
        damage.setText(String.valueOf(goldForDA));
        chance.setText(String.valueOf(goldForCC));
        crit.setText(String.valueOf(goldForCD));


    }

    public void dAmountClick(View view) {
        if (Hero.getGold()>goldForDA){
            Hero.addGold(-goldForDA);
            Hero.addDamage(1);
            Button b = (Button) view;
            this.goldForDA = (int) (goldForDA*2.2);
            b.setText(String.valueOf(goldForDA));
            shopDA.setText(String.valueOf(Hero.getDamage()));
        }
        else{
            /*тост короче шо денег нема*/
        }
    }

    public void toGame(View v)
    {
        Intent intent = new Intent(Shop.this, MainActivity.class);
        startActivity(intent);
    }

    public void cDamageClick(View view) {
        if (Hero.getGold()>goldForCD){
            Hero.addGold(-goldForCD);
            this.goldForCD =(int) (goldForCD*5);
            Button b = (Button) view;
            b.setText(String.valueOf(goldForCD));
            shopCD.setText(String.valueOf(Hero.getCritDamage()));
            Hero.addCritDamage(0.1);
        }
        else{
            /*тост короче шо денег нема*/
        }
    }
    public void cChanceClick(View view) {
        if (Hero.getGold()>goldForCC){
            Hero.addGold(-goldForCC);
            Button b = (Button) view;
            this.goldForCC = (int) (goldForCC * 12);
            b.setText(String.valueOf(goldForCC));
            shopCC.setText(String.valueOf(Hero.getCritChance()));
            Hero.addCritChance(1);
        }
        else{
            /*тост короче шо денег нема*/
        }
    }

}