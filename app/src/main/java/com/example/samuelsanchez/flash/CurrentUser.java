package com.example.samuelsanchez.flash;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Samuel Sanchez on 26/8/2017.
 */

public class CurrentUser {

    private FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    public FirebaseUser getCurrentUser(){
        return currentUser;
    }

}
