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

public class FiszkiMatTermoFragment extends Fragment {



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
                liczba = jan.nextInt(31);
                sharedPreferences.edit().putInt("currentLiczba", liczba).apply();
            }

        }



        String Fiszka = "";
        TextView textViewDwa = (TextView)getView().findViewById(R.id.textView7);


        if (liczba == 0) {textViewDwa.setText("0 Stopni Keliwnów to");
            String Fiszka0 = "'$0°K=-273,15°C$,$0°C=273,15°K$'";
            Fiszka = Fiszka0;}
        else if (liczba == 1) {textViewDwa.setText("Siła wyporu");
            String Fiszka4 = "' $F↖{→}_w=ρ_cgV_{ciala}$'";
            Fiszka = Fiszka4;}
        else if (liczba == 2) {textViewDwa.setText("Liczba Moli");
            String Fiszka6 = "'$n={m_s/M}=N/N_a=V/V_{mol}$'";
            Fiszka = Fiszka6;}
        else if (liczba == 3) {textViewDwa.setText("Przemiana izotermiczna");
            String Fiszka8 = "'$pV={const}$'";
            Fiszka = Fiszka8;}
        else if (liczba == 4) {textViewDwa.setText("Przemiana izobaryczna");
            String Fiszka9 = "'$V/T=const$'";
            Fiszka = Fiszka9;}
        else if (liczba == 5) {textViewDwa.setText("Przemiana izohoryczna");
            String Fiszka10 = "'$p/T=const$'";
            Fiszka = Fiszka10;}
        else if (liczba == 6) {textViewDwa.setText("Przemiana adiabatyczna");
            String Fiszka11 = "'$pV^χ={const}$'";
            Fiszka = Fiszka11;}
        else if (liczba == 7) {textViewDwa.setText("Współczynnik adiabaty");
            String Fiszka12 = "'$χ=C_p/C_v$'";
            Fiszka = Fiszka12;}
        else if (liczba == 8) {textViewDwa.setText("Definicja przemiany adiabatyczej");
            String Fiszka13 = "'W przemianie adiabatycznej, nie zachodzi wymiana ciepła z otoczeniem, podczas sprężania wzrasta temperatura i ciśnienie gazu'";
            Fiszka = Fiszka13;}
        else if (liczba == 9) {textViewDwa.setText("Ciepło molowe gazu doskonałego przy stałej objętości");
            String Fiszka14 = "'$C_v=Q_v/{n*ΔT}$'";
            Fiszka = Fiszka14;}
        else if (liczba == 10) {textViewDwa.setText("Ciepło molowe gazu doskonałego przy stałym ciśnieniu");
            String Fiszka15 = "'$C_p=Q_c/{n*ΔT}$'";
            Fiszka = Fiszka15;}
        else if (liczba == 11) {textViewDwa.setText("Ciepło molowe gazu doskonałego przy stałej objętości dla cząsteczek 2-atomowych");
            textViewDwa.setTextSize(30);
            String Fiszka16 = "'$C_v=3/2R+R$'";
            Fiszka = Fiszka16;}
        else if (liczba == 12) {textViewDwa.setText("Ciepło molowe gazu doskonałego przy stałej objętości dla cząsteczek 1-atomowych");
            textViewDwa.setTextSize(30);
            String Fiszka17 = "'$C_v=3/2R$'";
            Fiszka = Fiszka17;}
        else if (liczba == 13) {textViewDwa.setText("Ciepło molowe gazu doskonałego przy stałym ciśnieniu dla cząsteczek 2-atomowych");
            textViewDwa.setTextSize(30);
            String Fiszka18 = "'$C_p=5/2R+R$'";
            Fiszka = Fiszka18;}
        else if (liczba == 14) {textViewDwa.setText("Ciepło molowe gazu doskonałego przy stałym ciśnieniu dla cząsteczek 1-atomowych");
            textViewDwa.setTextSize(30);
            String Fiszka19 = "'$C_p=5/2R$'";
            Fiszka = Fiszka19;}
        else if (liczba == 15) {textViewDwa.setText("Pierwsza zasada termodynamiki z wykorzystaniem ciepła molowego przy stałym ciśnieniu");
            textViewDwa.setTextSize(25 );
            String Fiszka22 = "'$ΔU=nC_vΔT$'";
            Fiszka = Fiszka22;}
        else if (liczba == 16) {textViewDwa.setText("Praca wykonana przez siły zewnętrzne nad gazdem podczas jego sprężania");
            String Fiszka23 = "'$W=∫_cpdV$'";
            Fiszka = Fiszka23;}
        else if (liczba == 17) {textViewDwa.setText("Praca wykonana przez gaz podczas sprężania się");
            String Fiszka24 = "'$W=-∫_cpdV$'";
            Fiszka = Fiszka24;}
        else if (liczba == 18) {textViewDwa.setText("Praca w przemianie izohorycznej");
            String Fiszka25 = "'$W=0$'";
            Fiszka = Fiszka25;}
        else if (liczba == 19) {textViewDwa.setText("Entropia");
            String Fiszka26 = "'$S={ΔQ}/T$'";
            Fiszka = Fiszka26;}
        else if (liczba == 20) {textViewDwa.setText("Sprawność dla silników Carno");
            String Fiszka28 = "'$η={T_1-T_2}/T_1=1-T_2/T_1$'";
            Fiszka = Fiszka28;}
        else if (liczba == 21) {textViewDwa.setText("Druga zasada termodynamiki");
            String Fiszka29 = "'Niemożliwy jest taki proces termodynamiczny, którego jedynym rezultatem byłoy przekazanie ciepła przez ciało chłodniejsze do ciała cieplejszego.'";
            Fiszka = Fiszka29;}
        else if (liczba == 22) {textViewDwa.setText("Entropia dla procesów odwracalnych i nieodwracalnych");
            String Fiszka30 = "'$S≥{ΔQ}/T$'";
            Fiszka = Fiszka30;}





        WebView webViewFiszki = (WebView) getView().findViewById(R.id.webView563);
        WebSettings webSettings2 = webViewFiszki.getSettings();
        int dpi = getResources().getDisplayMetrics().densityDpi;
        if (liczba == 13 || liczba == 29) {
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
