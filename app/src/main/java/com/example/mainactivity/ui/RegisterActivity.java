package com.example.mainactivity.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mainactivity.R;
import com.example.mainactivity.business.ClientBusiness;
import com.example.mainactivity.data.DB;
import com.example.mainactivity.entity.Client;

import java.util.Objects;


public class RegisterActivity extends AppCompatActivity {


    Client client = new Client();
    DB db;
    ClientBusiness clientBusiness;

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
        clientBusiness = new ClientBusiness();

        //id declaration
        registerButton = findViewById(R.id.button_register);
        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editCpf = findViewById(R.id.edit_cpf);
        editPassword = findViewById(R.id.edit_password);
        textErrorMessage = findViewById(R.id.text_error_message);


        registerButton.setOnClickListener(this::RegisterClient);
    }

    public void RegisterClient(View view) {

        if (clientBusiness.VerifyClient(editName, editCpf, editEmail, editPassword)) {

            client.name = editName.getText().toString();
            client.CPF = editCpf.getText().toString();
            client.email = editEmail.getText().toString();
            client.password = editPassword.getText().toString();

            db.AddClientInDataBase(client);
            JoinActivityMain();
        }
    }

    public void JoinActivityMain() {
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
    }

}