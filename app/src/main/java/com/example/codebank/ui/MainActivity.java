package com.example.codebank.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.codebank.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
    }
}