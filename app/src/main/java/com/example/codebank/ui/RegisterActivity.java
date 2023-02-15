package com.example.codebank.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.codebank.R;
import com.example.codebank.business.RegisterBusiness;
import com.example.codebank.data.DB;

import java.util.Objects;


public class RegisterActivity extends AppCompatActivity {


    DB db;
    RegisterBusiness registerBusiness;

    Button registerButton;
    EditText editName;
    EditText editEmail;
    EditText editCpf;
    EditText editPassword;
    TextView textErrorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Objects.requireNonNull(getSupportActionBar()).hide();

        db = new DB();
        registerBusiness = new RegisterBusiness();

        //id declaration
        registerButton = findViewById(R.id.button_register);
        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editCpf = findViewById(R.id.edit_cpf);
        editPassword = findViewById(R.id.edit_password);
        textErrorMessage = findViewById(R.id.text_error_message);


        registerButton.setOnClickListener(this::registerClient);
    }

    public void registerClient(View view) {

        if (registerBusiness.verifyClient(editName, editCpf, editEmail, editPassword, textErrorMessage , this)) {

            DB.client.setName(editName.getText().toString());
            DB.client.setCPF(editCpf.getText().toString());
            DB.client.setEmail(editEmail.getText().toString());
            DB.client.setPassword(editPassword.getText().toString());

            db.addClientInDataBase();
            joinActivityMain();
        }
    }

    public void joinActivityMain() {
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
    }

}