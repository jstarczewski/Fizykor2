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
 * Created by johny_000 on 2016-10-10.
 */
public class FiszkiBrylaFragment extends Fragment {



    Random jan = new Random();

    Context context;
    int liczba;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fiszki, container, false);


    context=container.getContext();

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
                liczba = jan.nextInt(21);
                sharedPreferences.edit().putInt("currentLiczba", liczba).apply();
            }

        }

        String Fiszka = "";
        TextView textViewDwa = (TextView)getView().findViewById(R.id.textView7);


        if (liczba == 0) {textViewDwa.setText(R.string.predkoscKatowa);
            String Fiszka0 = "'$ω=α/t={2π}/T={2πf}$'";
            Fiszka = Fiszka0;}
        else if (liczba == 1) {textViewDwa.setText(R.string.PrzyspieszenieStyczne);
            String Fiszka1 = "'$a↖{→}_s=εr$'";
            Fiszka = Fiszka1;}
        else if (liczba == 2) {textViewDwa.setText(R.string.PrzyspieszenieCalkowite);
            String Fiszka2 = "'$a↖{→}_c=√{a↖{→}_s^2+a↖{→}_d^2$'";
            Fiszka = Fiszka2;}
        else if (liczba == 3) {textViewDwa.setText(R.string.przy_pieszenie_do_rodkowe);
            String Fiszka3 = "'$a↖{→}_d =v^2/r$'";
            Fiszka = Fiszka3;}
        else if (liczba == 4) {textViewDwa.setText(R.string.droga_k_towa_w_ruchu_po_okr_gu);
            String Fiszka4 = "'$α=ω_0t+↙{-}{εt^2}/2$'";
            Fiszka = Fiszka4;}
        else if (liczba == 5) {textViewDwa.setText(R.string.DrogaKatowaPredKon);
            String Fiszka5 = "'$α={{ω_0+ω_k}/2}t$ '";
            Fiszka = Fiszka5;}
        else if (liczba == 6) {textViewDwa.setText(R.string.DrogaKatowaEpsilon);
            String Fiszka6 = "'$α={ω_k^2-ω_0^2}/{2ε}$'";
            Fiszka = Fiszka6;}
        else if (liczba == 7) {textViewDwa.setText(R.string.PredKatowaKon);
            String Fiszka7 = "'$ω_k =ω_o+↙{-}εt$'";
            Fiszka = Fiszka7;}
        else if (liczba == 8) {textViewDwa.setText(R.string.ZaleznoscMiedzyDroga);
            String Fiszka8 = "'$s=rα$'";
            Fiszka = Fiszka8;}
        else if (liczba == 9) {textViewDwa.setText(R.string.ZaleznoscMiedzyPred);
            String Fiszka9 = "'$v↖{→}_s=ωr$'";
            Fiszka = Fiszka9;}
        else if (liczba == 10) {textViewDwa.setText(R.string.ZaleznoscMiedzyPrzys);
            String Fiszka10 = "'$a↖{→}_s=rε$'";
            Fiszka = Fiszka10;}
        else if (liczba == 11) {textViewDwa.setText(R.string.moment_si_y);
            String Fiszka11 = "'$M↖{→}=rFsinα$'";
            Fiszka = Fiszka11;}
        else if (liczba == 12) {textViewDwa.setText(R.string.moment_bezw_adno_ci);
            String Fiszka12 = "'$I=∑↖{n}↙{i=1}mr^2$ $I=mr^2$'";
            Fiszka = Fiszka12;}
        else if (liczba == 13) {textViewDwa.setText(R.string.TwierdzenieSteinera);
            String Fiszka13 = "'$I=I_0+md^2$'";
            Fiszka = Fiszka13;}
        else if (liczba == 14) {textViewDwa.setText(R.string.SrodekMasy);
            String Fiszka14 = "'$x_{sr}={∑m_1x_1}/∑m_i$'";
            Fiszka = Fiszka14;}
        else if (liczba == 15) {textViewDwa.setText(R.string.DrugaZasDynObr);
            String Fiszka15 = "$E↖{→}=M↖{→}/I  ⇒ M↖{→}=E↖{→}/I$'";
            Fiszka = Fiszka15;}
        else if (liczba == 16) {textViewDwa.setText(R.string.DrObrPed);
            String Fiszka16 = "'$M↖{→}=ΔL↖{→}/Δt$'";
            Fiszka = Fiszka16;}
        else if (liczba == 17) {textViewDwa.setText(R.string.moment_p_du);
            String Fiszka17 = "'$L↖{→}=rmv{sinα}$'";
            Fiszka = Fiszka17;}
        else if (liczba == 18) {textViewDwa.setText(R.string.energia_kinetyczna_ruchu_obrotowego);
            String Fiszka18 = "'$E_k={Iω^2}/2+{mv^2}/2$'";
            Fiszka = Fiszka18;}
        else if (liczba == 19) {textViewDwa.setText(R.string.MomentPeduDwa);
            String Fiszka19 = "'$L↖{→}=Iω↖{→}$'";
            Fiszka = Fiszka19;}
        else if (liczba == 20) {textViewDwa.setText("Przyśpieszenie kątowe");
            String Fiszka20 = "'$ε↖{→}=Δω↖{→}/Δt$'";
            Fiszka = Fiszka20;}



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

