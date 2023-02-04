package com.example.codebank.data;

import static android.content.ContentValues.TAG;

import android.util.Log;

import com.example.codebank.entity.Client;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;

public class DB {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public DB() {
    }

    public void addClientInDataBase(Client client) {


        Map<String, String> clientData = new HashMap();
        clientData.put("name", client.name);
        clientData.put("CPF", client.CPF);
        clientData.put("password", client.password);
        clientData.put("email", client.email);

        db.collection("Clients").add(clientData).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });;
    }

    public void getClientData(String CPF) {

        DocumentReference clientDoc = db.collection("Clients").document(CPF);
        clientDoc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Client client = documentSnapshot.toObject(Client.class);
                System.out.printf(client.getName());
            }
        });




    }
}



