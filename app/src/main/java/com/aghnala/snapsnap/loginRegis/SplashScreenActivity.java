package com.aghnala.snapsnap.loginRegis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aghnala.snapsnap.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by simco on 1/2/2018.
 */

public class SplashScreenActivity extends AppCompatActivity {

    public static Boolean started = false;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null){
            Intent intent = new Intent(getApplication(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            return;
        }else{
            Intent intent = new Intent(getApplication(), ChooseLoginRegistrationActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            return;
        }
    }
}
