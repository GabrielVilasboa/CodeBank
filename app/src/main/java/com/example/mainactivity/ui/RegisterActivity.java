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
import com.google.firebase.firestore.FirebaseFirestore;


public class RegisterActivity extends AppCompatActivity {


    FirebaseFirestore dbOne = FirebaseFirestore.getInstance();
    Client client = new Client();
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

        db = new DB();

        //id declaration
        registerButton = findViewById(R.id.button_register);
        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editCpf = findViewById(R.id.edit_cpf);
        editPassword = findViewById(R.id.edit_password);


        registerButton.setOnClickListener(this::RegisterClient);
    }

    public void RegisterClient(View view) {

        boolean result = checkClient();

        if(result){
            db.AddClientInDataBase(client);
            JoinActivityMain();
        } else {
            db.GetClientData(client.CPF);
        }
    }


    // logic error
    public boolean checkClient(){

        if (editName.getText() != null && editName.getText().toString() != "1") {
            client.name = editName.getText().toString();
            if (editCpf.getText() != null && editCpf.getText().toString() != "1") {
                client.CPF = editCpf.getText().toString();
                if (editEmail.getText() != null && editEmail.getText().toString() != "1") {
                    client.email = editEmail.getText().toString();
                    if (editPassword.getText() != null ) {
                        client.password = editPassword.getText().toString();
                        return true;
                    }else return false;
                }else return false;
            }else return false;
        }else return false;
    }

    //logic error


    public void JoinActivityMain() {
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);

    }

}