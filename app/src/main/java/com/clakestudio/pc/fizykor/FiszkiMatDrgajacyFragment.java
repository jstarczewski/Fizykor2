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
 * Created by johny_000 on 2016-10-20.
 */

public class FiszkiMatDrgajacyFragment extends Fragment {



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
                liczba = jan.nextInt(8);
                sharedPreferences.edit().putInt("currentLiczba", liczba).apply();
            }

        }




        String Fiszka = "";
        TextView textViewDwa = (TextView)getView().findViewById(R.id.textView7);

        if (liczba == 0) {textViewDwa.setText("Maksymalne położenie od czasu");
            String Fiszka1 = "'$x_{max}=A$'";
            Fiszka = Fiszka1;}
        else if (liczba == 1) {textViewDwa.setText("Maksymalne przyśpieszenie");
            String Fiszka4 = "'$a_{max}= -ω^2A$'";
            Fiszka = Fiszka4;}
        else if (liczba == 2) {textViewDwa.setText("Siła sprężystości");
            String Fiszka5 = "'$F_x↖{→}=-kx$ '";
            Fiszka = Fiszka5;}
        else if (liczba == 3) {textViewDwa.setText("Współczynnik sprężystośći");
            String Fiszka6 = "'$k=mω^2$'";
            Fiszka = Fiszka6;}
        else if (liczba == 4) {textViewDwa.setText("Energia potencjalna sprężystości");
            String Fiszka7 = "'$E_{ps}=1/2F↖{→}_x{kx^2}/2$'";
            Fiszka = Fiszka7;}
        else if (liczba == 5) {textViewDwa.setText("Energia całkowita");
            String Fiszka8 = "'$E_c={kA^2}/2$'";
            Fiszka = Fiszka8;}
        else if (liczba == 6) {textViewDwa.setText("Energia kinetyczna");
            String Fiszka9 = "'$E_k=E_c-E_{ps}=k/2(A^2-x^2)$'";
            Fiszka = Fiszka9;}
        else if (liczba == 7) {textViewDwa.setText("Okres drgań masy na sprężynie");
            String Fiszka9 = "'$T=2π√{m/k}$'";
            Fiszka = Fiszka9;}





        WebView webViewFiszki = (WebView) getView().findViewById(R.id.webView563);
        WebSettings webSettings2 = webViewFiszki.getSettings();
        int dpi = getResources().getDisplayMetrics().densityDpi;
        if (liczba == 2 || liczba == 3 || liczba == 0 || liczba == 9 || liczba == 7) {
            if (dpi > 500) {webViewFiszki.setInitialScale(500);}
            else if (dpi > 400) { webViewFiszki.setInitialScale(400);}
            else if (dpi > 300) { webViewFiszki.setInitialScale(300);}
            else if (dpi > 200) { webViewFiszki.setInitialScale(250);}
        }
        else {
            if (dpi > 500) {webViewFiszki.setInitialScale(600);}
            else if (dpi > 400) { webViewFiszki.setInitialScale(500);}
            else if (dpi > 300) { webViewFiszki.setInitialScale(400);}
            else if (dpi > 200) { webViewFiszki.setInitialScale(150);}
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

