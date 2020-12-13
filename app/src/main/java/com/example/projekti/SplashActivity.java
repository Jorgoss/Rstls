package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

/**
 * Slash activity, logon näytämistä varten oleva hetkellinen aktiviteetti
 *
 * @author Jonathan Soinio
 */

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000; //Aika jonka latausnäyttö on näkysvissä


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        LoginTracker loginTracker = new LoginTracker();
        new Handler().postDelayed(new Runnable() {
            @Override
            /**
             * Metodi jossa if lause sisällä, siirtää main aktiviteettiin
             */
            public void run() { // tarkistaa onko käyttäjä kirjautunut sisään ja siirtää Main sivulle, jos tieto kirjautumisesta löytyy
                SharedPreferences sharedpreferences = getSharedPreferences(SetupScreen.PREFS_NAME, MODE_PRIVATE);
                boolean hasLoggedIn = sharedpreferences.getBoolean("hasLoggedIn", false);
                loginTracker.Check(getApplicationContext());
                if (hasLoggedIn) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Intent toSetup = new Intent(SplashActivity.this, SetupScreen.class);
                    startActivity(toSetup);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }

}