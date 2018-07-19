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
 * Created by pc on 2016-10-30.
 */

public class FiszkiFragmentPrzem extends Fragment {



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


        if (liczba == 0) {textViewDwa.setText("Siła elektromotoryczna prądnicy");
            String Fiszka0 = "'$ε(t)=nSBωsin(ωt)=ε_0sin(ωt)$'";
            Fiszka = Fiszka0;}
        else if (liczba == 1) {textViewDwa.setText("Napięcie skuteczne");
            String Fiszka1 = "'$U_s=U_0/√2$'";
            Fiszka = Fiszka1;}
        else if (liczba == 2) {textViewDwa.setText("Natężenie skuteczne");
            String Fiszka2 = "'$I_s=I_0/√2$'";
            Fiszka = Fiszka2;}
        else if (liczba == 3) {textViewDwa.setText("Napięcie od czasu w pustym obwodzie pradu zmiennego");
            String Fiszka3 = "'$U(t)=U_0sin(ωt)$'";
            Fiszka = Fiszka3;}
        else if (liczba == 4) {textViewDwa.setText("Natężenie od czasu w pustym obwodzie prądu zmiennego");
            String Fiszka4 = "' $I(t)=I_0sin(ωt)=U_0/Rsin(ωt)$'";
            Fiszka = Fiszka4;}
        else if (liczba == 5) {textViewDwa.setText("Moc skuteczna");
            String Fiszka5 = "'$P_s=I_sU_s={I_0U_0}/2$'";
            Fiszka = Fiszka5;}
        else if (liczba == 6) {textViewDwa.setText("Praca prądu przemiennego");
            String Fiszka6 = "'Praca to pole figury pod wykresem mocy od czasu'";
            Fiszka = Fiszka6;}
        else if (liczba == 7) {textViewDwa.setText("Opór na cewce w obwodzie RLC");
            String Fiszka7 = "'$R_L=ωL=2πfL$'";
            Fiszka = Fiszka7;}
        else if (liczba == 8) {textViewDwa.setText("Opór na kondensatorze w obwodzie RLC");
            String Fiszka8 = "'$R_c=1/{ωC}=1/{2πfC}$'";
            Fiszka = Fiszka8;}
        else if (liczba == 9) {textViewDwa.setText("Obwód RLC jest indukcyjny gdy");
            String Fiszka9 = "'$R_L>R_C$'";
            Fiszka = Fiszka9;}
        else if (liczba == 10) {textViewDwa.setText("Obwód RLC ma charakter pojemnościowy gdy ");
            String Fiszka10 = "'$R_C>R_L$'";
            Fiszka = Fiszka10;}
        else if (liczba == 11) {textViewDwa.setText("Zawada oporu RLC");
            String Fiszka11 = "'$Z_{RLC}=√{R^2+(R_L-R_C)^2}$'";
            Fiszka = Fiszka11;}
        else if (liczba == 12) {textViewDwa.setText("Napięcie na obwodzie RLC");
            String Fiszka12 = "'$U_{RLC}=√{U_R^2+(U_L-U_C)^2}$'";
            Fiszka = Fiszka12;}
        else if (liczba == 13) {textViewDwa.setText("Zależność napięcia od czasu dla obwodu RLC");
            String Fiszka13 = "'$U(t)=U_0sin(ωt+φ_0)$'";
            Fiszka = Fiszka13;}
        else if (liczba == 14) {textViewDwa.setText("Zależność natężenia od czasu dla obwodu RLC");
            String Fiszka14 = "'$I(t)=I_0sint(ωt+φ_0)$'";
            Fiszka = Fiszka14;}
        else if (liczba == 15) {textViewDwa.setText("Zależność uzwojenia/napiecia/natężenia w transformatorze");
            String Fiszka15 = "'$n_p/n_p=U_p/U_p=I_p/I_p$'";
            Fiszka = Fiszka15;}
        else if (liczba == 16) {textViewDwa.setText("Okres drgania obwodu drgajacego LC");
            String Fiszka16 = "'$T=2π√{LC}$'";
            Fiszka = Fiszka16;}
        else if (liczba == 17) {textViewDwa.setText("Ładunek od czasu obwodu LC");
            String Fiszka17 = "'$Q(t)=Q_0cos(ωt)$'";
            Fiszka = Fiszka17;}






        WebView webViewFiszki = (WebView) getView().findViewById(R.id.webView563);
        WebSettings webSettings2 = webViewFiszki.getSettings();
        int dpi = getResources().getDisplayMetrics().densityDpi;
        if (liczba == 11 || liczba == 0) {
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