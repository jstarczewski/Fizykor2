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
 * Created by pc on 2016-10-29.
 */

public class FiszkiFragmentMagne extends Fragment {



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
                liczba = jan.nextInt(16);
                sharedPreferences.edit().putInt("currentLiczba", liczba).apply();
            }

        }




        String Fiszka = "";
        TextView textViewDwa = (TextView)getView().findViewById(R.id.textView7);


        if (liczba == 0) {textViewDwa.setText("Wektor indukcji magnetycznej");
            String Fiszka0 = "'$B↖{→}=F↖{→}_{⊥}/{qv}=F↖{→}_{⊥}/Il$'";
            Fiszka = Fiszka0;}
        else if (liczba == 1) {textViewDwa.setText("Pole magnetyczne cewki");
            String Fiszka1 = "'$B↖{→}=μ_0μ_r{nI}/l$'";
            Fiszka = Fiszka1;}
        else if (liczba == 2) {textViewDwa.setText("Pole magnetyczne przewodnika prosoliniowego");
            String Fiszka2 = "'$B↖{→}=μ_0μ_r{I}/2πr$'";
            Fiszka = Fiszka2;}
        else if (liczba == 3) {textViewDwa.setText("Pole magnetyczne pętli (w jej środku)");
            String Fiszka3 = "'$B↖{→}=μ_0μ_r{I}/2r$'";
            Fiszka = Fiszka3;}
        else if (liczba == 4) {textViewDwa.setText("Wektor natężenia pola magnetycznego");
            String Fiszka4 = "'$H↖{→}=B↖{→}/{μ_0μ_r}$'";
            Fiszka = Fiszka4;}
        else if (liczba == 5) {textViewDwa.setText("Wektor natężenia dla cewki");
            String Fiszka5 = "'$H↖{→}={nI}/l$'";
            Fiszka = Fiszka5;}
        else if (liczba == 6) {textViewDwa.setText("Wektor natężenia dla pętli (w jej środku)");
            String Fiszka6 = "'$H↖{→}={I}/2r$'";
            Fiszka = Fiszka6;}
        else if (liczba == 7) {textViewDwa.setText("Wektor natężenia dla przewodnika prostoliniowego");
            String Fiszka7 = "'$H↖{→}=I/2πr$'";
            Fiszka = Fiszka7;}
        else if (liczba == 8) {textViewDwa.setText("Siła elektrodynamiczna");
            String Fiszka8 = "'$F↖{→}=BIl{sinα}$'";
            Fiszka = Fiszka8;}
        else if (liczba == 9) {textViewDwa.setText("Siła Lorentza");
            String Fiszka9 = "'$F↖{→}=qvB{sinα}$'";
            Fiszka = Fiszka9;}
        else if (liczba == 10) {textViewDwa.setText("Związek między siłą dośrodkową a Lorentza");
            String Fiszka10 = "'${m{v}^2}/r=qvB_{⊥}$'";
            Fiszka = Fiszka10;}
        else if (liczba == 11) {textViewDwa.setText("Związek między pracą a energią kinetyczną");
            String Fiszka11 = "'$qU={m{v}^2}/2$'";
            Fiszka = Fiszka11;}
        else if (liczba == 12) {textViewDwa.setText("Przenikalność magnetyczna");
            String Fiszka12 = "'$μ_r=B/B_0$'";
            Fiszka = Fiszka12;}
        else if (liczba == 13) {textViewDwa.setText("Przenikalność magnetyczna dla ferromagnetyków");
            String Fiszka13 = "'$μ_r>>1$'";
            Fiszka = Fiszka13;}
        else if (liczba == 14) {textViewDwa.setText("Przenikalność magnetyczna dla paramagnetyków");
            String Fiszka14 = "'$μ_r>1$'";
            Fiszka = Fiszka14;}
        else if (liczba == 15) {textViewDwa.setText("Przenikalność magnetyczna dla diamagnetyków");
            String Fiszka15 = "'$μ_r<1$'";
            Fiszka = Fiszka15;}






        WebView webViewFiszki = (WebView) getView().findViewById(R.id.webView563);
        WebSettings webSettings2 = webViewFiszki.getSettings();
        int dpi = getResources().getDisplayMetrics().densityDpi;
        if (liczba == 100 || liczba == 100) {
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



