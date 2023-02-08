package com.example.codebank.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.codebank.R;
import com.example.codebank.business.LoginBusiness;



public class LoginActivity extends AppCompatActivity {

    LoginBusiness loginBusiness = new LoginBusiness();
    EditText editCPF;
    EditText editPassword;
    Button button;
    TextView textRegister;
    TextView textForget;
    TextView textError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();


        editCPF = findViewById(R.id.edit_CPF);
        editPassword = findViewById(R.id.edit_password);
        button = findViewById(R.id.button_join);
        textRegister = findViewById(R.id.text_register);
        textForget = findViewById(R.id.text_forget);
        textError = findViewById(R.id.text_error_message);

        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loginBusiness.findClient(editPassword, editCPF, textError)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }


            }
        });

    }
}