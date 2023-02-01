package com.example.mainactivity.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mainactivity.R;

public class LoginActivity extends AppCompatActivity {
    String cpf, password;
    EditText editCPF;
    EditText editPassword;
    Button button;
    TextView textRegister;
    TextView textForget;

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
                setData();
                verifyCpf();
            }
        });

    }

    private void setData(){
        this.cpf = editCPF.getText().toString();
        this.password = editPassword.getText().toString();
    }

    private void verifyCpf(){
        Intent intent2 = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent2);
    }

    private void verifyPassword(){
    }

}