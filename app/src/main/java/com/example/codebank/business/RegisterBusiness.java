package com.example.codebank.business;

import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class RegisterBusiness {

    public boolean verifyClient(EditText name, EditText CPF, EditText email, EditText password, TextView errorMessage) {
<<<<<<< Updated upstream
=======


>>>>>>> Stashed changes

        return clientValidName(name, errorMessage) &&
                clientValidEmail(email, errorMessage) &&
                clientValidCpf(CPF, errorMessage) &&
                clientValidPassword(password, errorMessage);
    }

    protected boolean clientValidCpf(EditText cpfObj, TextView errorText) {

<<<<<<< Updated upstream
        if (cpfObj == null) return false;

=======
>>>>>>> Stashed changes
        String CPF = cpfObj.getText().toString().trim();
        String cpfHelper = "";
        int i;
        if (CPF.length() == 11) {
            for (i = 0; i < 11; i++) {
                cpfHelper = (cpfHelper + CPF.charAt(i));
                if (i == 2 || i == 5) {
                    cpfHelper = (cpfHelper + ".");
                }
                if (i == 8) {
                    cpfHelper = (cpfHelper + "-");
                }
            }
            cpfObj.setText(cpfHelper);
            return true;
        }
<<<<<<< Updated upstream
        if (CPF.length() == 14) {
            return true;
        } else {
            errorText.setText("CPF invalido!");
            return false;
        }
=======
        errorText.setText("cpf invalido");
        return false;
>>>>>>> Stashed changes
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
