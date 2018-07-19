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
 * Created by johny_000 on 2016-10-24.
 */

public class FiszkiMatMechaniczneFragment  extends Fragment {



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
                liczba = jan.nextInt(11);
                sharedPreferences.edit().putInt("currentLiczba", liczba).apply();
            }

        }


        String Fiszka = "";
        TextView textViewDwa = (TextView)getView().findViewById(R.id.textView7);

        if (liczba == 0) {textViewDwa.setText("Prędkość fali");
            String Fiszka0 = "'$v↖{→}=λ/T=λf$'";
            Fiszka = Fiszka0;}
        else if (liczba == 1) {textViewDwa.setText("Rówanie fali y(x,t) z wykorzystaniem prędkości kątowej");
            String Fiszka1 = "'$y(x,t)=Asin[ω(t-x/v)+ϕ_o]$'";
            Fiszka = Fiszka1;}
        else if (liczba == 2) {textViewDwa.setText("Rówanie fali y(x,t) z wykorzystaniem długości fali");
            String Fiszka2 = "'$y(x,t)=Asin(x/λ-t/T)$'";
            Fiszka = Fiszka2;}
        else if (liczba == 3) {textViewDwa.setText("Interferencja fali zapisana przez iloczyn");
            String Fiszka3 = "' $y(x,t)=y_1+y_2=2Acos[π({x_2-x_1}/λ)]sin[2π(t/T-{x_1+x_2}/{2λ})]$'";
            Fiszka = Fiszka3;}
        else if (liczba == 4) {textViewDwa.setText("Wypadkowa amplituda dwóch fal");
            String Fiszka4 = "'$A_w=2Acos[π({x_2-x_1}/λ)]$'";
            Fiszka = Fiszka4;}
        else if (liczba == 5) {textViewDwa.setText(R.string.maksymalne_wzmocnienie_fali);
            String Fiszka5 = "'$Δx=nλ$'";
            Fiszka = Fiszka5;}
        else if (liczba == 6) {textViewDwa.setText(R.string.maksymalne_wygaszenie_fali);
            String Fiszka6 = "'$Δx=(2n+1)λ/2$'";
            Fiszka = Fiszka6;}
        else if (liczba == 7) {textViewDwa.setText(R.string.nat_enie_fal_i);
            String Fiszka7 = "'$I=E/{st}$'";
            Fiszka = Fiszka7;}
        else if (liczba == 8) {textViewDwa.setText("Natężenie fali dźwiękowej [db]");
            String Fiszka8 = "'$Λ=10logJ/J_0$'";
            Fiszka = Fiszka8;}
        else if (liczba == 9) {textViewDwa.setText(R.string.piszcza_ka_otwarta);
            String Fiszka10 = "'$f={nv↖{→}}/{2L}$'";
            Fiszka = Fiszka10;}
        else if (liczba == 10) {textViewDwa.setText(R.string.piszcza_ka_zamkni_ta);
            String Fiszka11 = "'$f=(2n-1)v/{4L}$'";
            Fiszka = Fiszka11;}




        WebView webViewFiszki = (WebView) getView().findViewById(R.id.webView563);
        WebSettings webSettings2 = webViewFiszki.getSettings();
        int dpi = getResources().getDisplayMetrics().densityDpi;
        if (liczba == 3 || liczba == 4 || liczba == 1 ) {
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

