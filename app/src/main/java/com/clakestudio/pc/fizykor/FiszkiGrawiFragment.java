package com.clakestudio.pc.fizykor;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
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
 * Created by johny_000 on 2016-10-12.
 */

public class FiszkiGrawiFragment extends Fragment {



    Random jan = new Random();




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fiszki, container, false);




        return view;
    }
    public void widzialnosc() {
        final WebView webViewFiszki = (WebView) getView().findViewById(R.id.webView563);
        if (webViewFiszki.getVisibility() == View.INVISIBLE) {
            webViewFiszki.setVisibility(View.VISIBLE);
        }
        else {webViewFiszki.setVisibility(View.INVISIBLE);}
    }

    public void onStart () {
        super.onStart();
        dzialanie();
    }
    public int liczbaMetoda() {
        int liczba3 = jan.nextInt(14);
        return liczba3;
    }

    public void dzialanie() {
        int liczba = liczbaMetoda();
        String Fiszka = "";
        TextView textViewDwa = (TextView)getView().findViewById(R.id.textView7);

        if (liczba == 0) {textViewDwa.setText(R.string.drugie_prawo_keplera);
            String Fiszka0 = "'${ΔA}/{Δt}={const}↖{→}$'";
            Fiszka = Fiszka0;}
        else if (liczba == 1) {textViewDwa.setText("Trzecie prawo Keplera");
            String Fiszka1 = "'$T^2/R^3={const}↖{→}$'";
            Fiszka = Fiszka1;}
        else if (liczba == 2) {textViewDwa.setText(R.string.prawo_powszechnego_ci_enia);
            String Fiszka2 = "'$F↖{→}_{M,m}=G{Mm}/r^2$'";
            Fiszka = Fiszka2;}
        else if (liczba == 3) {textViewDwa.setText(R.string.przy_pieszenie_grawitacyjne);
            String Fiszka3 = "'$g↖{→}_2=GMm/{Mr}=Gm/r^2$'";
            Fiszka = Fiszka3;}
        else if (liczba == 4) {textViewDwa.setText(R.string.nat_enie_pola_grawitacyjnego);
            String Fiszka4 = "'$γ↖{→}=F_g↖{→}/m=GM/r^2$'";
            Fiszka = Fiszka4;}
        else if (liczba == 5) {textViewDwa.setText(R.string.energia_potencjalna);
            String Fiszka5 = "'$E_p=-G{Mm}/r$'";
            Fiszka = Fiszka5;}
        else if (liczba == 6) {textViewDwa.setText(R.string.praca_w_polu_grawitacyjnym);
            String Fiszka6 = "'$W=∫↖{r_2}↙{r_1}Fdr=GMm(1/r_2-1/r_1)$'";
            Fiszka = Fiszka6;}
        else if (liczba == 7) {textViewDwa.setText(R.string.potencja_pola_grawitacyjnego);
            String Fiszka7 = "'$V=E_p/m_o=-{GM}/r$'";
            Fiszka = Fiszka7;}
        else if (liczba == 8) {textViewDwa.setText("Pierwsza prędkość kosmiczna");
            String Fiszka8 = "'$v↖{→}_1=√{{GM}/r}$'";
            Fiszka = Fiszka8;}
        else if (liczba == 9) {textViewDwa.setText("Druga prędkość kosmiczna");
            String Fiszka9 = "'$v_2↖{→}=√{{2GM}/r}=√{2}v↖{→}_1$'";
            Fiszka = Fiszka9;}
        else if (liczba == 10) {textViewDwa.setText(R.string.energia_kinetyczna);
            String Fiszka10 = "'$E_k=-1/2{E_p}=GMm/{2r}$'";
            Fiszka = Fiszka10;}
        else if (liczba == 11) {textViewDwa.setText("Energia całkowita");
            String Fiszka11 = "'$E_c=-E_k=1/2{e_p}=-GMm/{2r}$'";
            Fiszka = Fiszka11;}
        else if (liczba == 12) {textViewDwa.setText("Natężenie pola grawitacyjnego ziemi dla Promienia ziemi>r");
            String Fiszka12 = "'$γ↖{→}={{GM}/R^3}r$'";
            Fiszka = Fiszka12;}
        else if (liczba == 13) {textViewDwa.setText("Natęzenie pola grawitacyjnego ziemi dla r>>Promien ziemi  ");
            String Fiszka13 = "'$γ↖{→}={GM}/r^2$'";
            Fiszka = Fiszka13;}




        WebView webViewFiszki = (WebView) getView().findViewById(R.id.webView563);
        WebSettings webSettings2 = webViewFiszki.getSettings();

        int dpi = getResources().getDisplayMetrics().densityDpi;
        if (liczba == 6 || liczba == 11) {
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


        webViewFiszki.loadDataWithBaseURL("file:///android_asset/", "<style>img{display: inline;height: auto;max-width: 100%;}</style>" + fiszka, "text/html", "UTF-8", null);


    }
}


