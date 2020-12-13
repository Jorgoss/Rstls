package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Luokka nukutun ajan kirjaamiselle.
 * sisältää vielä tallennusmetodit, jotka lisätään omaksi luokaksi.
 *
 * @author Jouni Reinikainen
 */
public class UnenKirjaus extends AppCompatActivity {
    private SeekBar tunnitBar;
    private SeekBar minuutitBar;
    private TextView nukuttuaikaText;
    private int nukututTunnit;
    private int nukututMinuutit;
    Toast toast;
    public static final String TALLENNETUT_TIEDOT = "käyttäjän tallentamat tiedot";
    public static final String TUNNIT = "nukutut tunnit";
    public static final String MINUUTIT = "nukutut minuutit";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unen_kirjaus);

        toast = Toast.makeText(this, "Tiedot tallennettu", Toast.LENGTH_SHORT); //Käyttäjälle näkyvä tieto, joka näytetään kun tiedot on tallennettu

        tunnitBar = findViewById(R.id.tunnitSeekbar);
        minuutitBar = findViewById(R.id.minuutitSeekBar);
        nukuttuaikaText = findViewById(R.id.nukuttuAikaText);
        loadData();
        updateViews();

        tunnitBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            /**
             * Metodi reagoi siihen kun käyttäjä vetää tunnit säätöpalkkia ja tallentaa tiedot shared prefrenceen.
             */
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                nukututTunnit = progress;
                nukuttuaikaText.setText(+nukututTunnit + " tuntia : " + minuutitBar.getProgress() + " minuuttia");
                saveData();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        minuutitBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            /**
             * Metodi reagoi siihen kun käyttäjä vetää minuutit palkkia ja tallentaa tiedot shared prefrenceen.
             */
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                nukututMinuutit = progress;
                nukuttuaikaText.setText(+tunnitBar.getProgress() + " tuntia : " + nukututMinuutit + " minuuttia");
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
        SharedPreferences sharedPreferences = getSharedPreferences(TALLENNETUT_TIEDOT, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(TUNNIT, nukututTunnit);
        editor.putInt(MINUUTIT, nukututMinuutit);
        editor.commit();

        toast.show();

    }

    /**
     * Metodi lataa tiedot shared prefrencestä luokan käyttöön.
     */
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(TALLENNETUT_TIEDOT, MODE_PRIVATE);
        nukututTunnit = sharedPreferences.getInt(TUNNIT, 0);
        nukututMinuutit = sharedPreferences.getInt(MINUUTIT, 0);
    }

    /**
     * Metodi päivittää näkymän kentille aiemman tideot, jotka saadaan loadData metodilta.
     */
    public void updateViews() {
        nukuttuaikaText.setText(nukututTunnit + " tuntia : " + nukututMinuutit + " minuuttia");
        tunnitBar.setProgress(nukututTunnit);
        minuutitBar.setProgress(nukututMinuutit);
    }
}