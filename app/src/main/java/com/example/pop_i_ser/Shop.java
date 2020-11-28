package com.example.pop_i_ser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends AppCompatActivity {

    static int goldForCC ;
    static int goldForDA ;
    static int goldForCD ;
    TextView shopCC;
    TextView shopCD;
    TextView shopDA;
    TextView gold;
    Button damage;
    SharedPreferences mSettings;
    Button chance;
    Button crit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSettings = getSharedPreferences("my_settings", Context.MODE_PRIVATE);
        setContentView(R.layout.activity_shop);
        goldForCC = mSettings.getInt("goldCC", 100);
        goldForCD = mSettings.getInt("goldCD", 100);
        goldForDA = mSettings.getInt("goldDA", 100);
        Hero.setGold(mSettings.getInt("gold", 0));
        Location.setStage(mSettings.getInt("stage", 1));
        Hero.setCritChance(mSettings.getInt("chance", 0));
        Hero.setCritDamage(mSettings.getInt("crit", 2));
        Hero.setDamage(mSettings.getInt("damage", 1));
        shopDA = findViewById(R.id.shopDA);
        shopCD = findViewById(R.id.shopCD);
        shopCC = findViewById(R.id.shopCC);
        damage = findViewById(R.id.damage);
        chance = findViewById(R.id.chance);
        crit = findViewById(R.id.crit);
        gold = findViewById(R.id.gold);
        shopDA.setText(String.valueOf(Hero.getDamage()));
        shopCC.setText(String.valueOf(Hero.getCritChance()));
        shopCD.setText(String.valueOf(Hero.getCritDamage()));
        damage.setText(String.valueOf(goldForDA));
        chance.setText(String.valueOf(goldForCC));
        crit.setText(String.valueOf(goldForCD));
        gold.setText(String.valueOf(Hero.getGold()));
    }

    public void dAmountClick(View view) {
        if (Hero.getGold()>=goldForDA){
            Hero.addGold(-goldForDA);
            Hero.addDamage(1);
            Button b = (Button) view;
            this.goldForDA = (int) (goldForDA*2.2);
            b.setText(String.valueOf(goldForDA));
            shopDA.setText(String.valueOf(Hero.getDamage()));
            gold.setText(String.valueOf(Hero.getGold()));

        }
        else{
            Toast.makeText(this, "Нужно больше золота", Toast.LENGTH_LONG).show();
        }
    }

    public void toGame(View v)
    {
        Intent intent = new Intent(Shop.this, MainActivity.class);
        startActivity(intent);
    }

    public void cDamageClick(View view) {
        if (Hero.getGold()>=goldForCD){
            Hero.addGold(-goldForCD);
            this.goldForCD =(int) (goldForCD*5);
            Button b = (Button) view;
            b.setText(String.valueOf(goldForCD));
            Hero.addCritDamage(1);
            shopCD.setText(String.valueOf(Hero.getCritDamage()));
            gold.setText(String.valueOf(Hero.getGold()));
        }
        else{
            Toast.makeText(this, "Нужно больше золота", Toast.LENGTH_LONG).show();
        }
    }
    public void cChanceClick(View view) {
        if (Hero.getGold()>=goldForCC){
            Hero.addGold(-goldForCC);
            Button b = (Button) view;
            this.goldForCC = (int) (goldForCC * 12);
            b.setText(String.valueOf(goldForCC));
            Hero.addCritChance(1);
            shopCC.setText(String.valueOf(Hero.getCritChance()));
            gold.setText(String.valueOf(Hero.getGold()));

        }
        else{
            Toast.makeText(this, "Нужно больше золота", Toast.LENGTH_LONG).show();
        }
    }

    public static int getGoldForCC() {
        return goldForCC;
    }

    public static int getGoldForCD() {
        return goldForCD;
    }

    public static int getGoldForDA() {
        return goldForDA;
    }

    public static void setGoldForCC(int goldForCC) {
        Shop.goldForCC = goldForCC;
    }

    public static void setGoldForCD(int goldForCD) {
        Shop.goldForCD = goldForCD;
    }

    public static void setGoldForDA(int goldForDA) {
        Shop.goldForDA = goldForDA;
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt("gold", Hero.getGold());
        editor.putInt("damage", Hero.getDamage());
        editor.putInt("chance", Hero.getCritChance());
        editor.putInt("crit", Hero.getCritDamage());
        editor.putInt("stage", Location.getStage());
        editor.putInt("goldDA", Shop.getGoldForDA());
        editor.putInt("goldCD", Shop.getGoldForCD());
        editor.putInt("goldCC", Shop.getGoldForCC());
        editor.apply();
    }

    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt("gold", Hero.getGold());
        editor.putInt("damage", Hero.getDamage());
        editor.putInt("chance", Hero.getCritChance());
        editor.putInt("crit", Hero.getCritDamage());
        editor.putInt("stage", Location.getStage());
        editor.putInt("goldDA", Shop.getGoldForDA());
        editor.putInt("goldCD", Shop.getGoldForCD());
        editor.putInt("goldCC", Shop.getGoldForCC());
        editor.apply();
    }
}