package com.example.codebank.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.codebank.R;

public class TransfersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfers);

        getSupportActionBar().hide();
    }
}