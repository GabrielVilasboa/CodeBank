package com.example.codebank.business;

import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class ClientBusiness {

    public boolean verifyClient(EditText name, EditText cpf, EditText email, EditText password, TextView errorMessage) {

        return clientValidName(name, errorMessage) && clientValidCpf(cpf) && clientValidEmail(email, errorMessage) && clientValidPassword(password, errorMessage);
    }

    private boolean clientValidCpf(EditText cpfObj) {

        if (cpfObj == null) return false;

        String cpf = cpfObj.getText().toString().trim();
        String cpfHelper = "";
        int i;
        if (cpf.length() == 9) {
            for (i = 0; i < 9; i++) {
                cpfHelper = (cpfHelper + cpf.charAt(i));
                if (i == 3 || i == 6) {
                    cpfHelper = (cpfHelper + ".");
                }
                if (i == 7) {
                    cpfHelper = (cpfHelper + "-");
                }
            }
            cpfObj.setText(cpfHelper);
            return true;
        }
        cpfObj.setText(cpf);
        return cpf.length() == 11;
    }


    private boolean clientValidName(EditText nameObj, TextView errorText) {
        if (nameObj != null && !(nameObj.getText().toString().length() < 7)) {
            nameObj.getText().toString().toUpperCase(Locale.ROOT);
            return true;
        } else {
            errorText.setText("Nome Invalido!");
            return false;
        }
    } //Check

    private boolean clientValidEmail(EditText emailObj, TextView errorText) {

        int i;

        if (emailObj != null && !emailObj.getText().toString().isEmpty()) {
            String email = emailObj.getText().toString();
            for (i = 0; i != email.length(); i++) {
                if (email.charAt(i) == '@') {
                    return true;
                }
            }
            i++;
            if (i == (email.length() + 1)) {
                errorText.setText("Por Gentileza, insira um email válido");
                return false;
            }
        } else {
            errorText.setText("Por Gentileza digite seu Email!");
            return false;
        }
        return false;
    } //Check

    private boolean clientValidPassword(EditText passwordObj, TextView errorText) {
        if (passwordObj != null && !(passwordObj.getText().length() < 8)) {
            return true;
        } else {
            errorText.setText("A senha deve ter no minimo 8 digitos");
            return false;
        }

    } //Check
}
