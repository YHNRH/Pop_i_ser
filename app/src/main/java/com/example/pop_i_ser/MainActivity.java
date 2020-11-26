package com.example.pop_i_ser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView enemy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enemy = findViewById(R.id.enemy);
        enemy.setImageResource(R.drawable.enm1);
    }

    public void toMainMenu(View v)
    {
        Intent intent = new Intent(MainActivity.this, MainMenu.class);
        startActivity(intent);
    }
}