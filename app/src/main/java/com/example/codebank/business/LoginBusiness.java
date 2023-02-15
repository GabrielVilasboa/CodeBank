package com.example.codebank.business;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import com.example.codebank.data.DB;

public class LoginBusiness extends RegisterBusiness {


    DB db = new DB();

    public boolean findClient(EditText password, EditText CPF, TextView errorText, Context context) {

        String cpf = CPF.getText().toString();
        String passwordText = password.getText().toString();

        if (clientValidCpf(CPF, errorText, context)) {

            db.getClientData(cpf);

            System.out.print(DB.client);
            System.out.print(passwordText);

            if (DB.client.getPassword() == passwordText) {
                System.out.print(DB.client);
                return true;
            } else {
                errorText.setText("Senha Incorreta");
                return false;
            }

        } else {
            errorText.setText("Cliente não registrado");
            return false;
        }
    }


}

