package com.example.projekti;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;


/**
 * LoginTracker - Tarkistaa ja seuraa käyttäjän kirjautumiskäyttäytymistä; voi kannustaa kirjautumaan tai kysyä haluaako käyttäjä nollata tiedot
 * Voidaan myöhemmin laittaa esim. splashactivity tarkistamaan tästä logintila yms. dataa
 * @author Martti Ahern
 */
public class LoginTracker {

    private int LogInTimes;
    public static final String PREFS_NAME="MyPrefsFile";

    public LoginTracker(){

    }

    public void Check(Context context) {

        ArrayList<String> dates = new ArrayList<>();
        SharedPreferences sharedpreferences = context.getSharedPreferences(PREFS_NAME,MODE_PRIVATE);

        boolean hasLoggedIn = sharedpreferences.getBoolean(PREFS_NAME, false);

        // Hakee ajan ja laittaa stringiksi jota voi hyödyntää
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(date);


        if (hasLoggedIn) {
            LogInTimes = 1;
            dates.add(formattedDate);
        } else {
            LogInTimes = LogInTimes++;
            dates.add(formattedDate);

        }
    }
}

        