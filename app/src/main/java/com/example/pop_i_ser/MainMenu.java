package com.example.pop_i_ser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
    public void toGame(View v)
    {
        Intent intent = new Intent(MainMenu.this, MainActivity.class);
        startActivity(intent);
    }

    public void toSet_About(View v)
    {
        Intent intent = new Intent(MainMenu.this, Settings_About.class);
        startActivity(intent);
    }

    public void exit(View v)
    {
        this.finishAffinity();
    }


}