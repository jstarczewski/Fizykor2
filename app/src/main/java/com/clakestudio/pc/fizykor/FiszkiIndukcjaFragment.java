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
 * Created by pc on 2016-10-29.
 */

public class FiszkiIndukcjaFragment extends Fragment {



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


        if (liczba == 0) {textViewDwa.setText("Strumień indukcji elektromagnetycznej");
            String Fiszka0 = "'$ϕ=B↖{→}◦S↖{→}=BScosα$'";
            Fiszka = Fiszka0;}
        else if (liczba == 1) {textViewDwa.setText("Indukowana siła elektromotoryczna");
            String Fiszka4 = "'$ε_{ind}=-{Δϕ}/{Δt}$'";
            Fiszka = Fiszka4;}
        else if (liczba == 2) {textViewDwa.setText("Napięcie przechodzacące przez przewodnik w polu jednorodnym");
            String Fiszka6 = "'$U=Bvlsinα$'";
            Fiszka = Fiszka6;}
        else if (liczba == 3) {textViewDwa.setText("Praca włożona w układzie");
            String Fiszka8 = "'$W_{wl}=P_{wl}t=Fvt$'";
            Fiszka = Fiszka8;}
        else if (liczba == 4) {textViewDwa.setText("Praca otrzymana w układzie");
            String Fiszka9 = "'$W_{ot}=I^2Rt$, $I=U/R={Bvl}/R$'";
            Fiszka = Fiszka9;}
        else if (liczba == 5) {textViewDwa.setText("Indukcyność cewki");
            String Fiszka11 = "'$L=μ_0μ_r{N^2S}/l$'";
            Fiszka = Fiszka11;}
        else if (liczba == 6) {textViewDwa.setText("Samoindukcja");
            String Fiszka12 = "'$ε_s={Δϕ}/{Δt}=-L{Δl}/{Δt}$'";
            Fiszka = Fiszka12;}
        else if (liczba == 7) {textViewDwa.setText("Indukcja wzajemna");
            String Fiszka13 = "'$ε_{wz}=-M{Δl}/{Δt}$'";
            Fiszka = Fiszka13;}
        else if (liczba == 8) {textViewDwa.setText("Siła elektromotoryczna przewodnika w polu jednorodnym");
            String Fiszka13 = "'$ε=-BLvsinα$'";
            Fiszka = Fiszka13;}
        else if (liczba == 9) {textViewDwa.setText("Strumień indukcji elektromagentycznej wyrażony za pomocą natężenia");
            String Fiszka13 = "'$ϕ=LI$'";
            Fiszka = Fiszka13;}





        WebView webViewFiszki = (WebView) getView().findViewById(R.id.webView563);
        WebSettings webSettings2 = webViewFiszki.getSettings();
        int dpi = getResources().getDisplayMetrics().densityDpi;
        if (liczba == 4) {
            if (dpi > 500) {webViewFiszki.setInitialScale(500);}
            else if (dpi > 400) { webViewFiszki.setInitialScale(400);}
            else if (dpi > 300) { webViewFiszki.setInitialScale(300);}
            else if (dpi > 200) { webViewFiszki.setInitialScale(250);}
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
