package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

/**
 * Asetusten esiaste
 *
 * @author Jouni Reinikainen
 */
public class AddWidgets extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private Switch uni;
    private Switch vasymys;
    private Switch vesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_widgets);
        uni = findViewById(R.id.unenMaaraSwitch);
        vasymys = findViewById(R.id.vasymysateSwitch);
        vesi = findViewById(R.id.vedenJuontiSwitch);

        uni.setOnCheckedChangeListener(this);
        vasymys.setOnCheckedChangeListener(this);
        vesi.setOnCheckedChangeListener(this);

        //get shared prefrences from setup screen
    }

    @Override
    /**
     * Metodi vaikuttaa siihen näytettänkö aloitusnäytöllä mitä widgettejä.
     */
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.unenMaaraSwitch:
                if (isChecked) {
                    //change prefrences to show
                } else {
                    //change prefrences to not show
                }
            case R.id.vasymysateSwitch:
                if (isChecked) {
                    //change prefrences to show
                } else {
                    //change prefrences to not show
                }
            case R.id.vedenJuontiSwitch:
                if (isChecked) {
                    //change prefrences to show
                } else {
                    //change prefrences to not show
                }


        }
    }
}