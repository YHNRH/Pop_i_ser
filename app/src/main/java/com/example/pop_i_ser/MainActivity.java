package com.example.pop_i_ser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    ImageView enemy;
    TextView hp;
    Enemy enemy_o;
    Hero hero = new Hero();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enemy = findViewById(R.id.enemy);
        hp = findViewById(R.id.hp);
        enemy_o = Location.getEnemy();
        hp.setText(String.valueOf(enemy_o.getHealth()));
        int img = getResources().getIdentifier("drawable/e"+enemy_o.getImage(), null, getPackageName());
        enemy.setImageResource(img);
        enemy.setOnTouchListener(this);
    }

    public boolean onTouch(View v, MotionEvent event) {


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                enemy.setLayoutParams(new LinearLayout.LayoutParams(300,300));
                enemy.setColorFilter(ContextCompat.getColor(this,R.color.no_red));
                break;
            case MotionEvent.ACTION_MOVE: // движение
                break;
            case MotionEvent.ACTION_UP: // отпускание
                if (enemy_o.getHealth()-hero.getAttack()<=0) {
                    enemy_o = Location.getEnemy();
                    int img = getResources().getIdentifier("drawable/e"+enemy_o.getImage(), null, getPackageName());
                    enemy.setImageResource(img);
                    hp.setText(String.valueOf(enemy_o.getHealth()));
                    enemy.setLayoutParams(new LinearLayout.LayoutParams(350,350));
                    enemy.setColorFilter(ContextCompat.getColor(this,R.color.no_color));
                }
                else {
                    enemy_o.isAttacked(hero.getAttack());
                    hp.setText(String.valueOf(enemy_o.getHealth()));
                    enemy.setColorFilter(ContextCompat.getColor(this, R.color.no_color));
                    enemy.setLayoutParams(new LinearLayout.LayoutParams(350, 350));
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
}