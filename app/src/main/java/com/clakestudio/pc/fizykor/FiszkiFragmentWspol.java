package com.clakestudio.pc.fizykor;

import android.app.Fragment;
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
 * Created by johny_000 on 2016-11-09.
 */

public class FiszkiFragmentWspol extends Fragment {



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
    }

    public void onStart () {
        super.onStart();




        int liczba = jan.nextInt(18);
        String Fiszka = "";
        TextView textViewDwa = (TextView)getView().findViewById(R.id.textView7);


        if (liczba == 0) {textViewDwa.setText("Zjawisko fotoelektryczne zewnętrzne");
            String Fiszka0 = "'$E_f=W_0+E_k_{max}$'";
            Fiszka = Fiszka0;}
        else if (liczba == 1) {textViewDwa.setText("Energia fotonu wyrażona długością fali, lub natężeniem");
            String Fiszka1 = "'$E_f=hν={hc}/λ$'";
            Fiszka = Fiszka1;}
        else if (liczba == 2) {textViewDwa.setText("Praca wyjścia wyrażona długością fali, natężeniem");
            String Fiszka2 = "'$W_0=hν_{gra.}={hc}/λ_{gra.}$'";
            Fiszka = Fiszka2;}
        else if (liczba == 3) {textViewDwa.setText("Energia kinetyczna maksymalna");
            String Fiszka3 = "'$E_k_{max}={mv^2}/2=eU_h$'";
            Fiszka = Fiszka3;}
        else if (liczba == 4) {textViewDwa.setText("Rówannie orbity atomu modelu Bohra");
            String Fiszka4 = "'$mV_nr_n=n{h}/{2π}$'";
            Fiszka = Fiszka4;}
        else if (liczba == 5) {textViewDwa.setText("Stosunek prędkości elektronów na orbitach modelu Bohra");
            String Fiszka5 = "'$v_1:v_2:{v_3}...{v_n}=1:1/2:{1/3}....{1/n}$'";
            Fiszka = Fiszka5;}
        else if (liczba == 6) {textViewDwa.setText("Stosunek energii elektronów na orbitach modelu Bohra");
            String Fiszka6 = "'$E_1:{E_2}.....E_n=1:{1/2^2}....{1/n^2}$'";
            Fiszka = Fiszka6;}
        else if (liczba == 7) {textViewDwa.setText("Energia na orbicie dozwolonej");
            String Fiszka7 = "'$E_n={-13,6}/n^2$[eV]'";
            Fiszka = Fiszka7;}
        else if (liczba == 8) {textViewDwa.setText("Energia jonizacji");
            String Fiszka8 = "'$E_j=E_∞-E_1=13,6[eV]$'";
            Fiszka = Fiszka8;}
        else if (liczba == 9) {textViewDwa.setText("Częstotliwość widma");
            String Fiszka9 = "'$ν=cR(1/n^2-1/k^2)$'";
            Fiszka = Fiszka9;}
        else if (liczba == 10) {textViewDwa.setText("Deficity masy");
            String Fiszka10 = "'$Δm=m_{sk}-m_{j}=Zm_p+(A-Z)m_n-m_j$'";
            Fiszka = Fiszka10;}
        else if (liczba == 11) {textViewDwa.setText("Trwałośc wiązania");
            String Fiszka11 = "'${ΔE}/A $'";
            Fiszka = Fiszka11;}
        else if (liczba == 12) {textViewDwa.setText("Promieniowanie alfa");
            String Fiszka11 = "'$^A_ZX->_{Z+1}^{A}Y+_{-1}^0β^{-}$'";
            Fiszka = Fiszka11;}
        else if (liczba == 13) {textViewDwa.setText("Promieniowanie beta-minus");
            String Fiszka11 = "'$^A_ZX->_{Z+1}^{A}Y+_{-1}^0β^{-}$'";
            Fiszka = Fiszka11;}
        else if (liczba == 14) {textViewDwa.setText("Promieniowanie beta-plus");
            String Fiszka11 = "'$^A_ZX->_{Z+1}^{A}Y+_{1}^0β^{+}$'";
            Fiszka = Fiszka11;}
        else if (liczba == 15) {textViewDwa.setText("Zależność masy początkowej od czasu");
            String Fiszka11 = "'$N(t)=N_0-(1/2)^{t/T_{1/2}}$'";
            Fiszka = Fiszka11;}
        else if (liczba == 16) {textViewDwa.setText("Zasada nieznaczoności (pęd)");
            String Fiszka11 = "'$ΔxΔp≥h/{4π}$'";
            Fiszka = Fiszka11;}
        else if (liczba == 17) {textViewDwa.setText("Zasada nieoznaczoności (Energia)");
            String Fiszka11 = "'$ΔEΔt≥h/{4π}$'";
            Fiszka = Fiszka11;}










        WebView webViewFiszki = (WebView) getView().findViewById(R.id.webView563);
        WebSettings webSettings2 = webViewFiszki.getSettings();
        int dpi = getResources().getDisplayMetrics().densityDpi;
        if (liczba == 5 || liczba == 6) {
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
