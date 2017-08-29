package com.example.samuelsanchez.flash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ResultCodes;

import java.util.Arrays;


public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (new CurrentUser().getCurrentUser()!= null){
            logged();
        }else {
            singUp();
        }
    }

    private void singUp(){

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setProviders(Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                        new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                        new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build()/*,s
                                        new AuthUI.IdpConfig.Builder(AuthUI.TWITTER_PROVIDER).build()*/))
                        .build(),
                RC_SIGN_IN);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (RC_SIGN_IN == requestCode){

            if(ResultCodes.OK== resultCode){

                logged();
            }

        }
    }

    private void logged(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
