package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Setup Screen, "Asetus" aktiviteetti jonne kirjataan nimi ja siirrytään main aktiviteettiin, Asetus sivu ei tule enää uudelleen näkyviin kun sovelluksen käynnistäää uudelleen
 * @author Jonathan Soinio
 */

public class SetupScreen extends AppCompatActivity {
    public static String PREFS_NAME="MyPrefsFile";
    private Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_screen);
        signIn=findViewById(R.id.button);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override

            /**
             * Metodi tallentaa "sisäänkirjautumisen" ja siirtää main aktiviteettiin
             * @param view
             */
            public void onClick(View v) {
                SharedPreferences sharedpreferences= getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedpreferences.edit();

                editor.putBoolean("hasLoggedIn",true); // Tallentaa tiedon siitä onko käyttäjä kirjautunut sisään
                editor.commit();

                startActivity(new Intent(SetupScreen.this,MainActivity.class));
                finish();
            }
        });
    }
}