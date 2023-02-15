package com.example.codebank.data;

import com.example.codebank.entity.Client;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class DB {

    public static Client client = new Client();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public DB() {
    }

    public static void setClient(Client client) {
        DB.client = client;
    }

    public void addClientInDataBase() {
        db.collection("Clients").document(client.getCPF()).set(client);
    }

    public void getClientData(String CPF) {

        DocumentReference clientDoc = db.collection("Clients").document(CPF);
        clientDoc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Client client = documentSnapshot.toObject(Client.class);
                setClient(client);
            }

        });
        System.out.print(client);
    }
}



