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

public class FiszkiStalyFragment  extends Fragment {



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
                liczba = jan.nextInt(18);
                sharedPreferences.edit().putInt("currentLiczba", liczba).apply();
            }

        }


        String Fiszka = "";
        TextView textViewDwa = (TextView)getView().findViewById(R.id.textView7);

        if (liczba == 0) {textViewDwa.setText(R.string.nat_enie_pr_du);
            String Fiszka0 = "'$I={Δq}/{Δt}$'";
            Fiszka = Fiszka0;}
        else if (liczba == 1) {textViewDwa.setText("Gęstośc prądu");
            String Fiszka1 = "'$j=l/s[A/m^2]$'";
            Fiszka = Fiszka1;}
        else if (liczba == 2) {textViewDwa.setText("Szybkość ładunku");
            String Fiszka2 = "' $v=j/{ne}$'";
            Fiszka = Fiszka2;}
        else if (liczba == 3) {textViewDwa.setText("Opór elektryczny");
            String Fiszka3 = "'$R=U/I=ρl/s$'";
            Fiszka = Fiszka3;}
        else if (liczba == 4) {textViewDwa.setText("Opór właściwy");
            String Fiszka4 = "'$ρ={Rs}/l$'";
            Fiszka = Fiszka4;}
        else if (liczba == 5) {textViewDwa.setText(R.string.prawo_ohma);
            String Fiszka5 = "'$I∼U$'";
            Fiszka = Fiszka5;}
        else if (liczba == 6) {textViewDwa.setText("Natężenie całkowite w równoległym połączeniu oporników");
            String Fiszka6 = "'$I_c=I_1+{I_2}....{I_n}$'";
            Fiszka = Fiszka6;}
        else if (liczba == 7) {textViewDwa.setText("Natężenie całkowite w szeregowym połączeniu oporników");
            String Fiszka7 = "'$I={const}$'";
            Fiszka = Fiszka7;}
        else if (liczba == 8) {textViewDwa.setText("Opór całkowity w połączeniu równoległym");
            String Fiszka8 = "'$1/R_c=1/R_1+{1/R_2}.....{1/R_n}$'";
            Fiszka = Fiszka8;}
        else if (liczba == 9) {textViewDwa.setText("Opór całkowity w połączeniu szeregowym");
            String Fiszka9 = "'$R_c=R_1+{R_2}....{R_n}$'";
            Fiszka = Fiszka9;}
        else if (liczba == 10) {textViewDwa.setText("Napięcie całkowite w połączeniu szeregowym");
            String Fiszka10 = "'$U={const}$'";
            Fiszka = Fiszka10;}
        else if (liczba == 11) {textViewDwa.setText("Napięcie całkowite w połączeniu równoległym");
            String Fiszka11 = "'$U_c=U_1+{U_2}....{U_n}$'";
            Fiszka = Fiszka11;}
        else if (liczba == 12) {textViewDwa.setText(R.string.praca);
            String Fiszka12 = "'$W=UItW=I^2Rt$ <br> $W=U^2/Rt=QU$'";
            Fiszka = Fiszka12;}
        else if (liczba == 13) {textViewDwa.setText(R.string.moc);
            String Fiszka13 = "'$P=UI=I^2R=U^2/R$'";
            Fiszka = Fiszka13;}
        else if (liczba == 14) {textViewDwa.setText(R.string.prawo_ohma_dla_obowdu_zamkni_tego);
            String Fiszka14 = "'$ε=I(R+r)=U+Ir$'";
            Fiszka = Fiszka14;}
        else if (liczba == 15) {textViewDwa.setText(R.string.si_a_elektromotoryczna);
            String Fiszka15 = "'$ε={ΔW}/{Δq} [V]$'";
            Fiszka = Fiszka15;}
        else if (liczba == 16) {textViewDwa.setText("Pierwsze prawo Kirchoffa");
            String Fiszka16 = "'$I_1+I_2=I_3+I_4$'";
            Fiszka = Fiszka16;}
        else if (liczba == 17) {textViewDwa.setText("Jedna kilowatogodzina");
            String Fiszka17 = "'$1{kWh}=3,6MJ$'";
            Fiszka = Fiszka17;}





        WebView webViewFiszki = (WebView) getView().findViewById(R.id.webView563);
        WebSettings webSettings2 = webViewFiszki.getSettings();
        int dpi = getResources().getDisplayMetrics().densityDpi;
        if (liczba == 11) {
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


