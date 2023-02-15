package com.example.codebank.entity;

public class Client {
    private String CPF;
    private String name;
    private String email;
    private String password;
   // private String adress;
   // private Float currentBalance;

    //Extract historic new Extract;
    //CodeCard cart new CodeCard;
    public Client() {
    }

     public String getName() {
        return name;
    }

    public String getCPF() {
        return CPF;
    }

    public String getEmail() {
       return email;
    }

    public String getPassword() {
        return password;
    }

    /*
    public Float getCurrentBalance() {
        return currentBalance;
    }

    public String getAdress() {
        return adress;
    }
     */

    public void setName(String name) {
        this.name = name;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void pix() {
    }

    private void ted() {
    }

    private void doc() {
    }

    private void invert() {
    }

    private void payTicket() {
    }
}
