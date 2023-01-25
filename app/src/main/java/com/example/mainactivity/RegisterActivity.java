package com.example.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    Button registerButton;
    EditText editName;
    EditText editEmail;
    EditText editCpf;
    EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        Client client = new Client();

        //id declaration
        registerButton = findViewById(R.id.button_register);
        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editCpf = findViewById(R.id.edit_cpf);
        editPassword = findViewById(R.id.edit_password);

        registerButton.setOnClickListener(this::JoinActivityMain);
    }
    public void JoinActivityMain(View view){
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

}