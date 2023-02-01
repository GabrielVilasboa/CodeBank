package com.example.mainactivity.business;

import android.widget.EditText;

public class ClientBusiness {

    public boolean VerifyClient(EditText name, EditText cpf, EditText email, EditText password) {

        return ClientValidName(name) && ClientValidCpf(cpf) && ClientValidEmail(email) && ClientValidPassword(password);
    }
    private boolean ClientValidCpf(EditText cpfObj) {
        return cpfObj != null && !cpfObj.getText().toString().isEmpty();
    }

    private boolean ClientValidName(EditText nameObj) {
        return nameObj != null && !nameObj.getText().toString().isEmpty();
    }
    private boolean ClientValidEmail(EditText emailObj) {
        return emailObj != null && !emailObj.getText().toString().isEmpty();
    }
    private boolean ClientValidPassword(EditText passwordObj) {
        return passwordObj != null && !passwordObj.getText().toString().isEmpty();
    }
}
