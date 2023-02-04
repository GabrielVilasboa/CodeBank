package com.example.codebank.business;

import android.widget.EditText;
import android.widget.TextView;
import java.util.Locale;

public class ClientBusiness {

    public boolean verifyClient(EditText name, EditText cpf, EditText email, EditText password, TextView errorMessage) {

        return clientValidName(name, errorMessage) && clientValidCpf(cpf) && clientValidEmail(email) && clientValidPassword(password, errorMessage);
    }
    private boolean clientValidCpf(EditText cpfObj) {
        return cpfObj != null && !cpfObj.getText().toString().isEmpty();
    }
    private boolean clientValidName(EditText nameObj, TextView errorText) {
        if(nameObj != null && !(nameObj.getText().toString().length() < 7)){
            nameObj.getText().toString().toUpperCase(Locale.ROOT);
            return true;
        }else{
            errorText.setText("Nome Invalido!");
            return false;
        }
    } //Check
    private boolean clientValidEmail(EditText emailObj) {
        return emailObj != null && !emailObj.getText().toString().isEmpty();
    }
    private boolean clientValidPassword(EditText passwordObj, TextView errorText) {
        if( passwordObj != null && !(passwordObj.getText().length() < 8)){
            return true;
        }else{
            errorText.setText("A senha deve ter no minimo 8 digitos");
            return false;
        }

    }
}
