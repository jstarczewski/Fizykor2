package com.clakestudio.pc.fizykor;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by pc on 2016-10-16.
 */

public class FiszkiElektrostatykaFragment extends Fragment {



    Random jan = new Random();


    Context context;
    int liczba;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fiszki, container, false);




        context = container.getContext();

        return view;
    }
    public void widzialnosc() {
        final WebView webViewFiszki = (WebView) getView().findViewById(R.id.webView563);
        if (webViewFiszki.getVisibility() == View.INVISIBLE) {
            webViewFiszki.setVisibility(View.VISIBLE);
        }
    }

    public void onStart () {
        super.onStart();

        SharedPreferences sharedPreferences = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        if (sharedPreferences.getBoolean("back", false)) {
            liczba = sharedPreferences.getInt("liczba", 0);
            sharedPreferences.edit().putBoolean("current", true).apply();
        }
        else {
            if (sharedPreferences.getBoolean("current", false)) {
                liczba = sharedPreferences.getInt("currentLiczba", 0);
                sharedPreferences.edit().putBoolean("current", false).apply();
            }
            else {
                sharedPreferences.edit().putInt("liczba", liczba).apply();
                liczba = jan.nextInt(19);
                sharedPreferences.edit().putInt("currentLiczba", liczba).apply();
            }

        }




        String Fiszka = "";
        TextView textViewDwa = (TextView)getView().findViewById(R.id.textView7);

        if (liczba == 0) {textViewDwa.setText(R.string.si_a_elektrostatyczna);
            String Fiszka0 = "'$F↖{→}_{qQ}=k{{qQ}/r^2$'";
            Fiszka = Fiszka0;}
        else if (liczba == 1) {textViewDwa.setText("Ładunek");
            String Fiszka1 = "'$q=ne$ $[C]$'";
            Fiszka = Fiszka1;}
        else if (liczba == 2) {textViewDwa.setText(R.string.energia_potencjalna_pola_elektrostatycznego);
            String Fiszka2 = "' $E_p=k{Qq}/r$'";
            Fiszka = Fiszka2;}
        else if (liczba == 3) {textViewDwa.setText(R.string.potencja_pola_elektrostatycznego);
            String Fiszka3 = "'$V=E_p/q_0=kQ/r$'";
            Fiszka = Fiszka3;}
        else if (liczba == 4) {textViewDwa.setText(R.string.nat_enie_pola_elektrostatycznego);
            String Fiszka4 = "'$E↖{→}=F↖{→}/q_0=kQ/r^2$'";
            Fiszka = Fiszka4;}
        else if (liczba == 5) {textViewDwa.setText("Praca w polu elektrostatycznym z wykorzystaniem zmiany potencjału");
            String Fiszka5 = "'$W=qΔV=qU$'";
            Fiszka = Fiszka5;}
        else if (liczba == 6) {textViewDwa.setText(R.string.praca_w_polu_elekstrostatycznym);
            String Fiszka6 = "'$W=kQq(1/r_2-1/r_1)$'";
            Fiszka = Fiszka6;}
        else if (liczba == 7) {textViewDwa.setText(R.string.pojemno_kondensatora);
            String Fiszka7 = "'$C=Q/{ΔV},C=Q/U$'";
            Fiszka = Fiszka7;}
        else if (liczba == 8) {textViewDwa.setText("Pojemność dla kondensatora płaskiego z wykorzystaniem odległości między jego okładkami");
            String Fiszka8 = "'$C=ε_0*ε_rs/d$'";
            Fiszka = Fiszka8;}
        else if (liczba == 9) {textViewDwa.setText("Natężenie jednorodnego pola elektrostat.");
            String Fiszka9 = "'$E↖{→}=U/d$'";
            Fiszka = Fiszka9;}
        else if (liczba == 10) {textViewDwa.setText("Natęzenie centralnego pola elektrostat.");
            String Fiszka10 = "'$E↖{→}=V/r$'";
            Fiszka = Fiszka10;}
        else if (liczba == 11) {textViewDwa.setText("Ładunek całkowity w równoległym połaczeniu kondensatorów");
            String Fiszka11 = "'$Q_c=Q_1+{Q_2}...+Q_n$'";
            Fiszka = Fiszka11;}
        else if (liczba == 12) {textViewDwa.setText("Ładunek całkowity w szeregowym połaczeniu kondensatorów");
            String Fiszka12 = "'$Q={const}$'";
            Fiszka = Fiszka12;}
        else if (liczba == 13) {textViewDwa.setText("Napięcie całkowite w równoległym połaczeniu kondensatorów");
            String Fiszka13 = "'$U={const}$'";
            Fiszka = Fiszka13;}
        else if (liczba == 14) {textViewDwa.setText("Napięcie całkowite w szeregowym połaczeniu kondensatorów");
            String Fiszka14 = "'$U_c=U_1+U_2....+U_n$'";
            Fiszka = Fiszka14;}
        else if (liczba == 15) {textViewDwa.setText("Całkowita pojemność układu kondensatorów połączonych szeregowo");
            String Fiszka15 = "'$1/C_c=1/C_1+1/{C_2}....+1/C_n$'";
            Fiszka = Fiszka15;}
        else if (liczba == 16) {textViewDwa.setText(R.string.praca_w_kondensatorach);
            String Fiszka16 = "'$W={QU}/2=Q^2/{2C}={CU^2}/2$'";
            Fiszka = Fiszka16;}
        else if (liczba == 17) {textViewDwa.setText("Natężenie pola elektrostatycznego kuli dla R(kuli)>r");
            String Fiszka17 = "'$E↖{→}={kQ}/R^3*r$'";
            Fiszka = Fiszka17;}
        else if (liczba == 18) {textViewDwa.setText("Natężenie pola elektrostatycznego kuli dla r >> R(kuli)");
            String Fiszka18 = "'$E↖{→}={kQ}/r^2$'";
            Fiszka = Fiszka18;}
        else if (liczba == 19) {textViewDwa.setText("Natężenie w polu jednorodnym");
            String Fiszka19 = "'$E↖{→}=U/d$'";
            Fiszka = Fiszka19;}




        WebView webViewFiszki = (WebView) getView().findViewById(R.id.webView563);
        WebSettings webSettings2 = webViewFiszki.getSettings();



        int dpi = getResources().getDisplayMetrics().densityDpi;
        if (liczba == 200) {
            if (dpi > 500) {webViewFiszki.setInitialScale(500);}
            else if (dpi > 400) { webViewFiszki.setInitialScale(400);}
            else if (dpi > 300) { webViewFiszki.setInitialScale(300);}
            else if (dpi > 200) { webViewFiszki.setInitialScale(200);}
        }
        else {
            if (dpi > 500) {webViewFiszki.setInitialScale(600);}
            else if (dpi > 400) { webViewFiszki.setInitialScale(500);}
            else if (dpi > 300) { webViewFiszki.setInitialScale(400);}
            else if (dpi > 200) { webViewFiszki.setInitialScale(300);}
        }
        webSettings2.setBuiltInZoomControls(true);
        webSettings2.setDisplayZoomControls(false);
        webSettings2.setJavaScriptEnabled(true);

        if (Build.VERSION.SDK_INT >= 11) {
            webViewFiszki.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        String path = "file:///android_asset/";
        String fiszka = "<html><head>"
                + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                + "</head><body>"
                + "<script>var s = " + Fiszka + ";M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


        webViewFiszki.loadDataWithBaseURL("file:///android_asset/", fiszka, "text/html", "UTF-8", null);


    }

}

