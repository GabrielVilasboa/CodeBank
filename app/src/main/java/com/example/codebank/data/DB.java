package com.example.codebank.data;

import static android.content.ContentValues.TAG;

import android.util.Log;

import com.example.codebank.entity.Client;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;

public class DB {

    public static Client client = new Client();
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

    public DB() {
    }

    public void addClientInDataBase(Client client) {


        Map<String, String> clientData = new HashMap();
        clientData.put("name", client.name);
        clientData.put("CPF", client.CPF);
        clientData.put("password", client.password);
        clientData.put("email", client.email);

        db.collection("Clients").document(client.CPF).set(clientData);

    }

    public void getClientData(String CPF) {
        DocumentReference clientDoc = db.collection("Clients").document(CPF);
        clientDoc.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        clientDoc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                               Client client = documentSnapshot.toObject(Client.class);
                               DB.client = client;
                            }
                        });
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }
}



