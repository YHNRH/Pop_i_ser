package com.example.pop_i_ser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    ImageView enemy;
    TextView hp;
    TextView hb;
    TextView damage;
    TextView chance;
    TextView crit;
    TextView gold;
    Enemy enemy_o;
    ImageView background;
    SharedPreferences mSettings;
    private SoundPool mSoundPool;
    private AssetManager mAssetManager;
    int hit_counter=0;
    private int hs_m_0,hs_m_1,hs_m_2,hs_w_0,hs_w_1,hs_w_2,hs_mo_0,hs_mo_1,hs_mo_2;
    float pixels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSettings = getSharedPreferences("my_settings", Context.MODE_PRIVATE);
        mSoundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        mAssetManager = getAssets();
        hs_m_0 = loadSound("hs_m_0.mp3");
        hs_m_1 = loadSound("hs_m_1.mp3");
        hs_m_2 = loadSound("hs_m_2.mp3");
        hs_w_0 = loadSound("hs_w_0.m4a");
        hs_w_1 = loadSound("hs_w_1.m4a");
        hs_w_2 = loadSound("hs_w_2.m4a");
        hs_mo_0 = loadSound("hs_mo_0.mp3");
        hs_mo_1 = loadSound("hs_mo_1.mp3");
        hs_mo_2 = loadSound("hs_mo_2.mp3");
        Hero.setGold(mSettings.getInt("gold", 0));
        Shop.setGoldForCC(mSettings.getInt("goldCC", 100));
        Shop.setGoldForCD(mSettings.getInt("goldCD", 100));
        Shop.setGoldForDA(mSettings.getInt("goldDA", 100));
        Location.setStage(mSettings.getInt("stage", 1));
        Hero.setCritChance(mSettings.getInt("chance", 0));
        Hero.setCritDamage(mSettings.getInt("crit", 2));
        Hero.setDamage(mSettings.getInt("damage", 1));
        pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
        enemy = findViewById(R.id.enemy);
        hp = findViewById(R.id.hp);
        background = findViewById(R.id.background);
        hb = findViewById(R.id.hb);
        damage = findViewById(R.id.damage);
        chance = findViewById(R.id.chance);
        crit = findViewById(R.id.crit);
        gold = findViewById(R.id.gold);
        gold.setText("Золото " + Hero.getGold());
        damage.setText(String.valueOf("Урон " + Hero.getDamage()));
        chance.setText(String.valueOf("Шанс крита " + Hero.getCritChance()));
        crit.setText(String.valueOf("Критический урон " + Hero.getCritDamage()));
        enemy_o = Location.getEnemy();
        hp.setText(String.valueOf(enemy_o.getHealth()));
        int img = getResources().getIdentifier("drawable/e"+enemy_o.getImage(), null, getPackageName());
        enemy.setImageResource(img);
        int img_b = getResources().getIdentifier("drawable/l"+Location.getStage(), null, getPackageName());
        background.setImageResource(img_b);

        enemy.setOnTouchListener(this);
    }

    public boolean onTouch(View v, MotionEvent event) {


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие

                enemy.setLayoutParams(new LinearLayout.LayoutParams((int) (20*pixels),(int)(20*pixels)));
                enemy.setColorFilter(ContextCompat.getColor(this,R.color.no_red));
                if (hit_counter==0){
                switch(enemy_o.getImage())
            {
                case(2):// man
                    switch((int)(Math.random()*3)) {
                        case (0):
                            playSound(hs_m_0);
                            break;
                        case (1):
                            playSound(hs_m_1);
                            break;
                        case (2):
                            playSound(hs_m_2);
                            break;
                    }
                            break;
                case(3): //woman
                    switch((int)(Math.random()*3)) {
                        case (0):
                            playSound(hs_w_0);
                            break;
                        case (1):
                            playSound(hs_w_1);
                            break;
                        case (2):
                            playSound(hs_w_2);
                            break;
                    }
                    break;
                case(4):// man
                    switch((int)(Math.random()*3)) {
                        case (0):
                            playSound(hs_m_0);
                            break;
                        case (1):
                            playSound(hs_m_1);
                            break;
                        case (2):
                            playSound(hs_m_2);
                            break;
                    }
                    break;
                case(5):// man
                    switch((int)(Math.random()*3)) {
                        case (0):
                            playSound(hs_m_0);
                            break;
                        case (1):
                            playSound(hs_m_1);
                            break;
                        case (2):
                            playSound(hs_m_2);
                            break;
                    }
                    break;
                case(6): //woman
                    switch((int)(Math.random()*3)) {
                        case (0):
                            playSound(hs_w_0);
                            break;
                        case (1):
                            playSound(hs_w_1);
                            break;
                        case (2):
                            playSound(hs_w_2);
                            break;
                    }
                    break;
                case(7): //monstr
                    switch((int)(Math.random()*3)) {
                        case (0):
                            playSound(hs_mo_0);
                            break;
                        case (1):
                            playSound(hs_mo_1);
                            break;
                        case (2):
                            playSound(hs_mo_2);
                            break;
                    }
                    break;
                case(8): //woman
                    switch((int)(Math.random()*3)) {
                        case (0):
                            playSound(hs_w_0);
                            break;
                        case (1):
                            playSound(hs_w_1);
                            break;
                        case (2):
                            playSound(hs_w_2);
                            break;
                    }
                    break;
                case(9): //woman
                    switch((int)(Math.random()*3)) {
                        case (0):
                            playSound(hs_w_0);
                            break;
                        case (1):
                            playSound(hs_w_1);
                            break;
                        case (2):
                            playSound(hs_w_2);
                            break;
                    }
                    break;
                case(10): //woman
                    switch((int)(Math.random()*3)) {
                        case (0):
                            playSound(hs_w_0);
                            break;
                        case (1):
                            playSound(hs_w_1);
                            break;
                        case (2):
                            playSound(hs_w_2);
                            break;
                    }
                    break;
                case(11): //monstr
                    switch((int)(Math.random()*3)) {
                        case (0):
                            playSound(hs_mo_0);
                            break;
                        case (1):
                            playSound(hs_mo_1);
                            break;
                        case (2):
                            playSound(hs_mo_2);
                            break;
                    }
                    }
                hit_counter=3;}
                hit_counter--;
                break;
            case MotionEvent.ACTION_MOVE: // движение
                break;
            case MotionEvent.ACTION_UP: // отпускание
                if (enemy_o.getHealth()-Hero.getAttack()<=0) {
                    Hero.addGold(enemy_o.getGold());
                    gold.setText("Золото " + Hero.getGold());
                    enemy_o = Location.getEnemy();
                    int img_b = getResources().getIdentifier("drawable/l"+Location.getStage(), null, getPackageName());
                    background.setImageResource(img_b);
                    int img = getResources().getIdentifier("drawable/e"+enemy_o.getImage(), null, getPackageName());
                    enemy.setImageResource(img);
                    hp.setText(String.valueOf(enemy_o.getHealth()));
                    enemy.setLayoutParams(new LinearLayout.LayoutParams((int) (34*pixels),(int)(34*pixels)));
                    LinearLayout.LayoutParams param = new LinearLayout.LayoutParams((int) (enemy_o.getHealth()/enemy_o.getMaxHealth()*34*pixels),(int)(6*pixels));
                    param.gravity = Gravity.CENTER;
                    hb.setLayoutParams(param);
                    enemy.setColorFilter(ContextCompat.getColor(this,R.color.no_color));
                }
                else {
                    enemy_o.isAttacked(Hero.getAttack());
                    hp.setText(String.valueOf(enemy_o.getHealth()));
                    LinearLayout.LayoutParams param = new LinearLayout.LayoutParams((int) ((float)enemy_o.getHealth()/ (float)enemy_o.getMaxHealth()*34*pixels),(int)(6*pixels));
                    param.gravity = Gravity.CENTER;
                    enemy.setColorFilter(ContextCompat.getColor(this, R.color.no_color));
                    hb.setLayoutParams(param);
                    enemy.setLayoutParams(new LinearLayout.LayoutParams((int) (34*pixels),(int)(34*pixels)));
                }
                break;
                    case MotionEvent.ACTION_CANCEL:

        }
        return true;
    }

    public void toMainMenu(View v)
    {
        Intent intent = new Intent(MainActivity.this, MainMenu.class);
        startActivity(intent);
    }



    public void toShop(View v)
    {
        Intent intent = new Intent(MainActivity.this, Shop.class);
        startActivity(intent);
    }

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

    private int loadSound(String fileName) {
        AssetFileDescriptor afd = null;
        try {
            afd = mAssetManager.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Couldn't load file '" + fileName + "'", Toast.LENGTH_SHORT).show();
            return -1;
        }
        return mSoundPool.load(afd, 1);
    }
    protected void playSound(int sound) {
        if (sound > 0)
            mSoundPool.play(sound, 1, 1, 1, 0, 1);
    }
}