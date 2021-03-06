package com.clakestudio.pc.fizykor;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by pc on 2016-11-11.
 */

public class FiszkiFragmentOptyka extends Fragment {



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
                liczba = jan.nextInt(10);
                sharedPreferences.edit().putInt("currentLiczba", liczba).apply();
            }

        }



        String Fiszka = "";
        TextView textViewDwa = (TextView)getView().findViewById(R.id.textView7);

        if (liczba == 0) {textViewDwa.setText("Równanie zwierciadła/soczewki");
            String Fiszka0 = "'$1/x+1/y=1/f$'";
            Fiszka = Fiszka0;}
        else if (liczba == 1) {textViewDwa.setText("Powiększenie");
            String Fiszka1 = "'$p=∣{y/x}∣=∣{h_y/h_x}∣$'";
            Fiszka = Fiszka1;}
        else if (liczba == 2) {textViewDwa.setText("Zdolność skupiająca");
            String Fiszka2 = "'$Z=1/f$'";
            Fiszka = Fiszka2;}
        else if (liczba == 3) {textViewDwa.setText("Rówanie soczewki z wykorzystaniem przenikalności ośrodków");
            String Fiszka3 = "'$1/f=(n_{sc}/n_{os}-1)(1/r_1+1/r_2)$'";
            Fiszka = Fiszka3;}
        else if (liczba == 4) {textViewDwa.setText("Współczynnik załamania światła ośrodka drugiego względem pierwszego");
            String Fiszka4 = "'$n_{1,2}={sinα}/{sinβ}=v_1/v_2=λ_1/λ_2$'";
            Fiszka = Fiszka4;}
        else if (liczba == 5) {textViewDwa.setText("Kąt graniczny");
            String Fiszka5 = "'${sinα}=n_2/n_1$'";
            Fiszka = Fiszka5;}
        else if (liczba == 6) {textViewDwa.setText("Tangens kąta padania w polaryzacji przez odbicie");
            String Fiszka6 = "'${tgα}=n_2/n_1$'";
            Fiszka = Fiszka6;}
        else if (liczba == 7) {textViewDwa.setText("Natężenie światla niespolaryzowanego padającego na płytkę");
            String Fiszka7 = "'$I=I_0/2$'";
            Fiszka = Fiszka7;}
        else if (liczba == 8) {textViewDwa.setText("Natężenie światła spolaryzowanego padającego na kolejną płytkę");
            String Fiszka8 = "'$I=I_0{cos^2θ}$'";
            Fiszka = Fiszka8;}
        else if (liczba == 9) {textViewDwa.setText("Zależność siatki dyfrakcyjnej");
            String Fiszka9 = "'$nλ=d{sin}α$'";
            Fiszka = Fiszka9;}




        WebView webViewFiszki = (WebView)getView().findViewById(R.id.webView563);
        WebSettings webSettings2 = webViewFiszki.getSettings();
        int dpi = getResources().getDisplayMetrics().densityDpi;
        if (liczba == 3) {
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
                + "<script>var s = "+Fiszka+";M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


        webViewFiszki.loadDataWithBaseURL("file:///android_asset/", fiszka, "text/html", "UTF-8", null);

    }

}