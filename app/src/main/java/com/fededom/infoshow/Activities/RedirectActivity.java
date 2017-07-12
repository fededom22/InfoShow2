package com.fededom.infoshow.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class RedirectActivity  extends AppCompatActivity {


    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            startActivity(new Intent(RedirectActivity.this, MainActivity.class));
            finish();
        } else {
            startActivity(new Intent(RedirectActivity.this, LoginActivity.class));
            finish();
        }

    }
}
