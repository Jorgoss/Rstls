package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Luokka väsymystason kirjaamiselle.
 * sisältää vielä tallennusmetodit, jotka lisätään omaksi luokaksi.
 *
 * @author Jouni Reinikainen
 */
public class VasymysKirjaus extends AppCompatActivity {
    private TextView vasymysTeksti;
    private SeekBar vasymysasteBar;
    private String vasymysaste;
    public static final String TALLENNETUT_TIEDOT = "käyttäjän tallentamat tiedot";
    public static final String VASYMYSASTE = "päivän väsymysaste";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vasymys_kirjaus);

        vasymysTeksti = findViewById(R.id.vasymysasteTeksti);
        vasymysasteBar = findViewById(R.id.vasymysasteSeekBar);
        vasymysasteBar.setMin(0); // Valinnan minimiarvo
        vasymysasteBar.setMax(5); // valinnan maksimiarvo
        loadData();
        updateViews();

        vasymysasteBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            /**
             * Metodi reagoi siihen kun käyttäjä vetää väsymystason säätöpalkkia ja tallentaa tiedot shared prefrenceen.
             */
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vasymysTeksti.setText("" + progress);
                saveData();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    /**
     * Metodi tallentaa annetut tiedot shared preferenceen ja kertoo käyttäjälle tallennuksen onnistumisesta.
     */
    public void saveData() {
        TextView vasymysteksti = findViewById(R.id.vasymysasteTeksti);
        SharedPreferences sharedPreferences = getSharedPreferences(TALLENNETUT_TIEDOT, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(VASYMYSASTE, vasymysteksti.getText().toString());
        editor.commit();

        Toast.makeText(this, "Tiedot tallennettu", Toast.LENGTH_SHORT).show();
    }

    /**
     * Metodi lataa tiedot shared prefrencestä luokan käyttöön.
     */
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(TALLENNETUT_TIEDOT, MODE_PRIVATE);
        vasymysaste = sharedPreferences.getString(VASYMYSASTE, "0");
    }

    /**
     * Metodi päivittää näkymän kentille aiemman tideot, jotka saadaan loadData metodilta.
     */
    public void updateViews() {
        vasymysasteBar = findViewById(R.id.vasymysasteSeekBar);
        vasymysTeksti = findViewById(R.id.vasymysasteTeksti);
        vasymysTeksti.setText(vasymysaste);
        vasymysasteBar.setProgress(Integer.parseInt(vasymysaste));
    }

}