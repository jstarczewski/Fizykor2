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
 * Created by pc on 2016-10-09.
 */

public class FiszkiFragmentDynamo extends Fragment {



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
                liczba = jan.nextInt(15);
                sharedPreferences.edit().putInt("currentLiczba", liczba).apply();
            }

        }



        String Fiszka = "";
        TextView textViewDwa = (TextView)getView().findViewById(R.id.textView7);

        if (liczba == 0) {textViewDwa.setText("Druga zasada dynamiki");
            String Fiszka0 = "'$a↖{→}=F↖{→}/m$'";
            Fiszka = Fiszka0;}
        else if (liczba == 1) {textViewDwa.setText("Pęd");
            String Fiszka1 = "'$p↖{→}=mv↖{→}$ $[kg*{m/s}]$'";
            Fiszka = Fiszka1;}
        else if (liczba == 2) {textViewDwa.setText("Zasada zachowania pędu");
            String Fiszka2 = "'$p↖{→}=p↖{→}_1+p↖{→}_2...p↖{→}_n={const}↖{→}$'";
            Fiszka = Fiszka2;}
        else if (liczba == 3) {textViewDwa.setText(R.string.trzecia_zasada_dynamiki);
            String Fiszka3 = "'$F↖{→}_{AB}=-F↖{→}_{BA}$'";
            Fiszka = Fiszka3;}
        else if (liczba == 4) {textViewDwa.setText(R.string.tarcie);
            String Fiszka4 = "'$T↖{→}=μF_n$'";
            Fiszka = Fiszka4;}
        else if (liczba == 5) {textViewDwa.setText("Tarcie statyczne");
            String Fiszka5 = "'$T↖{→}_s<<μ_sF_n$'";
            Fiszka = Fiszka5;}
        else if (liczba == 6) {textViewDwa.setText("Tarcie Kinetyczne");
            String Fiszka6 = "'$T↖{→}_k=μ_kF_n$'";
            Fiszka = Fiszka6;}
        else if (liczba == 7) {textViewDwa.setText("Siła zsuwania na równi pochyłej");
            String Fiszka7 = "'$F↖{→}_s=mgsinα$'";
            Fiszka = Fiszka7;}
        else if (liczba == 8) {textViewDwa.setText("Siła tarcia na równi");
            String Fiszka8 = "'$T↖{→}=μmgcosα$'";
            Fiszka = Fiszka8;}
        else if (liczba == 9) {textViewDwa.setText("Siła nacisku na równi");
            String Fiszka9 = "'$F↖{→}_n=mgcosα$'";
            Fiszka = Fiszka9;}
        else if (liczba == 10) {textViewDwa.setText("Siła nacisku dla windy jadącej w górę");
            String Fiszka10 = "'$F↖{→}_n=mg↖{→}+ma↖{→}$'";
            Fiszka = Fiszka10;}
        else if (liczba == 11) {textViewDwa.setText("Siła nacisku dla windy jadącej w dół");
            String Fiszka11 = "'$F↖{→}_n=mg↖{→}-ma↖{→}$'";
            Fiszka = Fiszka11;}
        else if (liczba == 12) {textViewDwa.setText("Stosunek siły nacisku do siły grawitacji na równi pochyłej");
            String Fiszka12 = "'$cosα=F_n/F_g$'";
            Fiszka = Fiszka12;}
        else if (liczba == 13) {textViewDwa.setText("Druga zasada dynamiki wyrażona pędem");
            String Fiszka13 = "'$F↖{→}={∆p↖{→}}/{t}$'";
            Fiszka = Fiszka13;}
        else if (liczba == 14) {textViewDwa.setText("Siła grawitacji");
            String Fiszka14 = "'$F↖{→}_g=m{g↖{→}}$'";
            Fiszka = Fiszka14;}



        WebView webViewFiszki = (WebView)getView().findViewById(R.id.webView563);
        WebSettings webSettings2 = webViewFiszki.getSettings();
        int dpi = getResources().getDisplayMetrics().densityDpi;
        if (liczba == 2) {
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