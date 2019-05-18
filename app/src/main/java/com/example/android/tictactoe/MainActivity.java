package com.example.android.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Launch intent to first game
    public void button_regular(View view) {
        Intent intent = new Intent(this,button1.class);
        startActivity(intent);
    }

    public void button_ultimate(View view) {
        Intent intent = new Intent(this,button2.class);
        startActivity(intent);
    }

    public void button_quantum(View view) {
        Intent intent = new Intent(this,button3.class);
        startActivity(intent);
    }

    public void button_your_choice(View view) {
        Intent intent = new Intent(this,button4.class);
        startActivity(intent);
    }
}
