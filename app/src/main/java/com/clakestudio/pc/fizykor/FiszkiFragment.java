package com.clakestudio.pc.fizykor;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.util.Log;
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
 * Created by pc on 2016-10-08.
 */

public class FiszkiFragment extends Fragment {



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
        else if (webViewFiszki.getVisibility()== View.VISIBLE){
            webViewFiszki.setVisibility(View.INVISIBLE);
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
                    liczba = jan.nextInt(24);
                    sharedPreferences.edit().putInt("currentLiczba", liczba).apply();
                }

            }


                String Fiszka = "";
                TextView textViewDwa = (TextView) getView().findViewById(R.id.textView7);

            if (liczba == 0) {
                textViewDwa.setText(R.string.predkoscJednostajny);
                String Fiszka0 = "'$v↖{→}={∆s}/t [m/s]$'";
                Fiszka = Fiszka0;
            } else if (liczba == 1) {
                textViewDwa.setText(R.string.predkosczmienny);
                String Fiszka1 = "'$v↖{→}=v_0+at [m/s]$'";
                Fiszka = Fiszka1;
            } else if (liczba == 2) {
                textViewDwa.setText(R.string.przyspieszenieZmienny);
                String Fiszka2 = "'$a↖{→}={∆v}/t [m/s^2]$'";
                Fiszka = Fiszka2;
            } else if (liczba == 3) {
                textViewDwa.setText(R.string.drogaZmienny1);
                String Fiszka3 = "'$s = v_0t +↙{-} {at^2}/2$ $[m/s]$'";
                Fiszka = Fiszka3;
            } else if (liczba == 4) {
                textViewDwa.setText(R.string.drogaZmienny2);
                String Fiszka4 = "'$s = {v_0 + v_k}/2 t$'";
                Fiszka = Fiszka4;
            } else if (liczba == 5) {
                textViewDwa.setText(R.string.drogaZmienny3);
                String Fiszka5 = "'$s = {v_k^2-v_0^2}/{2a}$'";
                Fiszka = Fiszka5;
            } else if (liczba == 6) {
                textViewDwa.setText(R.string.stosunkiDrog);
                String Fiszka6 = "'$s_1:s_2:s_3:..s_n = 1:3:5..n$'";
                Fiszka = Fiszka6;
            } else if (liczba == 7) {
                textViewDwa.setText(R.string.rowRuchV);
                String Fiszka7 = "'$v↖{→}(t)=v_0+at$ $[m/s]$'";
                Fiszka = Fiszka7;
            } else if (liczba == 8) {
                textViewDwa.setText(R.string.RowRuchuT);
                String Fiszka8 = "'$x(t)=x_0+s$ $[m/s]$'";
                Fiszka = Fiszka8;
            } else if (liczba == 9) {
                textViewDwa.setText(R.string.Spadek);
                String Fiszka9 = "'$h(t)=x_0+v_0↖{→}t+s$'";
                Fiszka = Fiszka9;
            } else if (liczba == 10) {
                textViewDwa.setText(R.string.Zasieg);
                String Fiszka10 = "'$Z=v↖{→}_ot$ $[m/s]$'";
                Fiszka = Fiszka10;
            } else if (liczba == 11) {
                textViewDwa.setText(R.string.PionowaSkladowa);
                String Fiszka11 = "'$v↖{→}_{ky}=gt$'";
                Fiszka = Fiszka11;
            } else if (liczba == 12) {
                textViewDwa.setText(R.string.TangensAlfa);
                String Fiszka12 = "'$tgα={v_y}/{v_x}={gt}/v_o$'";
                Fiszka = Fiszka12;
            } else if (liczba == 13) {
                textViewDwa.setText(R.string.PredCal);
                String Fiszka13 = "'$v↖{→}_c=√{v↖{→}_x^2+v↖{→}_y^2}$'";
                Fiszka = Fiszka13;
            } else if (liczba == 14) {
                textViewDwa.setText(R.string.pozioma0ukosny);
                String Fiszka14 = "'$v↖{→}_{0x}=v_0cosα$'";
                Fiszka = Fiszka14;
            } else if (liczba == 15) {
                textViewDwa.setText(R.string.pionow0ukosny);
                String Fiszka15 = "'$v↖{→}_{0y}=v_0sinα$'";
                Fiszka = Fiszka15;
            } else if (liczba == 16) {
                textViewDwa.setText(R.string.czasWznoszenia);
                String Fiszka16 = "'$t_{wz}={v_0sinα}/g$'";
                Fiszka = Fiszka16;
            } else if (liczba == 17) {
                textViewDwa.setText(R.string.czasCalkowity);
                String Fiszka17 = "'$t_{cal}={2v_0sinα}/g$'";
                Fiszka = Fiszka17;
            } else if (liczba == 18) {
                textViewDwa.setText(R.string.maxWysokosc);
                String Fiszka18 = "'$h_{max}={v_0^2sin^2α}/{2g}$'";
                Fiszka = Fiszka18;
            } else if (liczba == 19) {
                textViewDwa.setText(R.string.zasiegUkosny);
                String Fiszka19 = "'$Z={v↖{→}_0^2sin2α}/g$'";
                Fiszka = Fiszka19;
            } else if (liczba == 20) {
                textViewDwa.setText(R.string.predkoscPoOkregu);
                String Fiszka20 = "'$v↖{→}= s/t= {2πr}/T = {2πfr}$'";
                Fiszka = Fiszka20;
            } else if (liczba == 21) {
                textViewDwa.setText(R.string.PrzyspieszenieDosrodkowe);
                String Fiszka21 = "'$a_d↖{→}=v^2/r$'";
                Fiszka = Fiszka21;
            } else if (liczba == 22) {
                textViewDwa.setText(R.string.PredkoscSrednia);
                String Fiszka22 = "'$v_{sr}={v_o+v_k}/2$'";
                Fiszka = Fiszka22;
            } else if (liczba == 23) {
                textViewDwa.setText(R.string.czestotliwosc);
                String Fiszka23 = "'$f=1/T$'";
                Fiszka = Fiszka23;
            }


                WebView webViewFiszki = (WebView) getView().findViewById(R.id.webView563);
                WebSettings webSettings2 = webViewFiszki.getSettings();
            int dpi = getResources().getDisplayMetrics().densityDpi;
                if (liczba == 6) {
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
