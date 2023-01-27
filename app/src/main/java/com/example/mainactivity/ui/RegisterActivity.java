package com.example.mainactivity.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mainactivity.R;
import com.example.mainactivity.data.DB;
import com.example.mainactivity.entity.Client;

public class RegisterActivity extends AppCompatActivity {

    Client client;
    DB db;

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

        client = new Client();
        db = new DB();

        //id declaration
        registerButton = findViewById(R.id.button_register);
        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editCpf = findViewById(R.id.edit_cpf);
        editPassword = findViewById(R.id.edit_password);

        registerButton.setOnClickListener(this::RegisterClient);
    }

    public void RegisterClient(View view){

        if (editName.getText() != null){
            client.name = editName.getText().toString();
        }
        if (editCpf.getText() != null){
            client.CPF = editCpf.getText().toString();
        }
        if (editEmail.getText() != null){
            client.email = editEmail.getText().toString();
        }
        if (editPassword.getText() != null){
            client.password = editPassword.getText().toString();
        }


        JoinActivityMain(db.AddClientInDataBase(client));




    }

    public void JoinActivityMain(boolean result){
        if (result) {
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

}