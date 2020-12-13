package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Luokka juodun veden määrän kirjaamiselle.
 * sisältää vielä tallennusmetodit, jotka lisätään omaksi luokaksi.
 *
 * @author Jouni Reinikainen
 */
public class VedenKirjaus extends AppCompatActivity {
    private int paivittainenJuontiTavoite;
    private String juotujenLasienMaara;
    public static final String TALLENNETUT_TIEDOT = "käyttäjän tallentamat tiedot";
    public static final String VESI = "juodun veden määrä";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veden_kirjaus);
        loadData();
        updateViews();
        TextView paivittainenTavoite = findViewById(R.id.paivittainenTavoiteLuku);
        paivittainenJuontiTavoite = 4; //päivittäinen tavoite
        paivittainenTavoite.setText(Integer.toString(paivittainenJuontiTavoite));
    }

    Counter laskuri = new Counter(0); //Laskuriluokan olio.

    public void plus(View view) {
        TextView juotujaLaseja = findViewById(R.id.juotujaLasejaVetta);
        laskuri.plus();
        juotujaLaseja.setText(Integer.toString(laskuri.getLaskuri()));
        saveData();
        if (laskuri.getLaskuri() == paivittainenJuontiTavoite) { //jos laskuri pääsee päivttäiseen tavoitteeseen näytetään viesti onnistumisesta
            Context context = getApplicationContext();
            CharSequence text = "Päivittäinen tavoite saavutettu";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void minus(View view) {
        TextView juotujaLaseja = findViewById(R.id.juotujaLasejaVetta);
        laskuri.minus();
        juotujaLaseja.setText(Integer.toString(laskuri.getLaskuri()));
        saveData();
    }

    /**
     * Metodi tallentaa annetut tiedot shared preferenceen ja kertoo käyttäjälle tallennuksen onnistumisesta.
     */
    public void saveData() {
        TextView juotujaLaseja = findViewById(R.id.juotujaLasejaVetta);
        SharedPreferences sharedPreferences = getSharedPreferences(TALLENNETUT_TIEDOT, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(VESI, juotujaLaseja.getText().toString());
        editor.commit();

        Toast.makeText(this, "Tiedot tallennettu", Toast.LENGTH_SHORT).show();
    }

    /**
     * Metodi lataa tiedot shared prefrencestä luokan käyttöön.
     */
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(TALLENNETUT_TIEDOT, MODE_PRIVATE);
        juotujenLasienMaara = sharedPreferences.getString(VESI, "0");
    }

    /**
     * Metodi päivittää näkymän kentille aiemman tideot, jotka saadaan loadData metodilta.
     */
    public void updateViews() {
        TextView juotujaLaseja = findViewById(R.id.juotujaLasejaVetta);
        juotujaLaseja.setText(juotujenLasienMaara);
        laskuri.setLaskuri(Integer.parseInt(juotujenLasienMaara));
    }
}