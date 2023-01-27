package com.example.mainactivity.data;

import com.example.mainactivity.entity.Client;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class DB {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public DB() {
    }

    public boolean AddClientInDataBase(Client client) {

        Map<String, Object> clientData = new HashMap<>();
        clientData.put("name", client.name);
        clientData.put("CPF", client.CPF);
        clientData.put("password", client.password);
        clientData.put("email", client.email);

        return db.collection("Clients").document().set(client.CPF).isComplete();
    }
}

