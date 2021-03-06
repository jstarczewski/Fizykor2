package com.clakestudio.pc.fizykor;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import FlashCards.FlashCard;

/**
 * Created by Jan on 7/20/2018.
 */

public class FlashCardsFragment extends Fragment {



    private WebView webViewFiszki;
    private CardView cvFlashCards;

    Context context;
    int liczba;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flash_cards, container, false);
        context = container.getContext();

        cvFlashCards = (CardView)view.findViewById(R.id.cvFlashCards);
        return view;
    }
    public void setDefaultWebViewVisibility() {
        webViewFiszki.setVisibility(View.INVISIBLE);
    }


    public void onStart () {
        super.onStart();


        /*
        *
        *  Animate Card View
        *
        *
        * */

        FlashCardsActivity flashCardsActivity = (FlashCardsActivity)getActivity();
        FlashCard flashCard = flashCardsActivity.getFlashCard();

        TextView textViewDwa = (TextView)getView().findViewById(R.id.textView7);
        textViewDwa.setText(flashCard.getName());
        webViewFiszki = (WebView)getView().findViewById(R.id.webView563);

        setDefaultWebViewVisibility();

        WebSettings webSettings2 = webViewFiszki.getSettings();
        int dpi = getResources().getDisplayMetrics().densityDpi;
        if (liczba == 2) {
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
                + "<script>var s = "+flashCard.getAnswer()+";M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


        webViewFiszki.loadDataWithBaseURL("file:///android_asset/", fiszka, "text/html", "UTF-8", null);

    }
    public void showWebView() {
        if (webViewFiszki.getVisibility()==View.VISIBLE)
            webViewFiszki.setVisibility(View.INVISIBLE);
        else
            webViewFiszki.setVisibility(View.VISIBLE);
    }


}
