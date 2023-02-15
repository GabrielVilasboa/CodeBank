package com.example.codebank.ui;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.codebank.R;

public class MainActivity extends AppCompatActivity {

    ImageView icPix;
    ImageView icTransfers;
    ImageView icPhone;
    ImageView icDeposit;
    ImageView icSaving;
    ImageView icBill;
    ImageView icLoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        icPix = findViewById(R.id.ic_pix);
        icTransfers = findViewById(R.id.ic_transfers);
        icPhone = findViewById(R.id.ic_phone);
        icDeposit = findViewById(R.id.ic_saving);
        icBill = findViewById(R.id.ic_bill);
        icLoan = findViewById(R.id.ic_loan);

        icPix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PixActivity.class);
                startActivity(intent);
            }
        });
        icTransfers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TransfersActivity.class);
                startActivity(intent);
            }
        });
    }
}