package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Main activity
 * @author Jouni Reinikainen
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Metodi asetuksiin siirymiseen.
     * @param view
     */
    public void addNewWidget(View view){
        Intent addWidget = new Intent(this,AddWidgets.class);
        startActivity(addWidget);
    }

    /**
     * Metodi unen kirjaamisen aktiviteettiin siirtymiseen.
     * @param view
     */
    public void unenKirjaus(View view){
        Intent unenKirjaamiseen = new Intent(this,UnenKirjaus.class);
        startActivity(unenKirjaamiseen);
    }

    /**
     * Metodi väsymystason kirjaamisen aktiviteettiin siirtymiseen.
     * @param view
     */
    public void vasymyskirjaus(View view){
        Intent vasymyskirjaamiseen = new Intent(this,VasymysKirjaus.class);
        startActivity(vasymyskirjaamiseen);
    }

    /**
     * Metodi juodun veden määrän kirjaamisen aktiviteettiin siirtymiseen.
     * @param view
     */
    public void vedenkirjaus(View view){
        Intent vedenkirjaukseen = new Intent(this,VedenKirjaus.class);
        startActivity(vedenkirjaukseen);
    }

}
