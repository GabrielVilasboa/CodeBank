package com.example.codebank.business;

import android.widget.EditText;
import android.widget.TextView;

import com.example.codebank.data.DB;

public class LoginBusiness extends RegisterBusiness{


    DB db = new DB();

    public boolean findClient(EditText password, EditText CPF, TextView errorText){

        if (clientValidCpf(CPF, errorText)){
            if (db.getClientData(CPF.getText().toString())){
                if (DB.client.password == password.getText().toString()){
                    return true;
                }else{
                    errorText.setText("Senha Incorreta");
                    return false;
                }
            }else {
                errorText.setText("Cliente não registrado");
                return false;
            }
        }
        return false;

    }
}
