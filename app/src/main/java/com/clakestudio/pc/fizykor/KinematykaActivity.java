package com.clakestudio.pc.fizykor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import android.support.v4.view.NestedScrollingChild;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

import FlashCards.FlashCard;

import static android.view.View.GONE;

public class KinematykaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ScrollView scrollView;
    private int sprawdzenie = 0;
    private int sprawdzenieMat = 0;
    private int backpress;
    private static final String STATE_LEVEL = "sprawdzenie";
    private TextView[] textViews;
    private CardView[] cardViews;
    private WebView[] webViews;



    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinematyka);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));


        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);


        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu first item clicked

                FiszkiMaturalne();
            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Fiszki();


            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked

                Nauka();

            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.kinematyka);


        WebView webView1 = (WebView) findViewById(R.id.webView1);
        WebView webView2 = (WebView) findViewById(R.id.webView2);
        WebView webView3 = (WebView) findViewById(R.id.webView3);
        WebView webView4 = (WebView) findViewById(R.id.webView4);
        WebView webView5 = (WebView) findViewById(R.id.webView5);
        WebView webView6 = (WebView) findViewById(R.id.webView6);
        WebView webView7 = (WebView) findViewById(R.id.webView7);
        WebView webView8 = (WebView) findViewById(R.id.webView8);
        WebView webView9 = (WebView) findViewById(R.id.webView9);
        WebView webView10 = (WebView) findViewById(R.id.webView10);
        WebView webView11 = (WebView) findViewById(R.id.webView11);
        WebView webView12 = (WebView) findViewById(R.id.webView12);
        WebView webView13 = (WebView) findViewById(R.id.webView13);
        WebView webView14 = (WebView) findViewById(R.id.webView14);
        WebView webView15 = (WebView) findViewById(R.id.webView15);
        WebView webView16 = (WebView) findViewById(R.id.webView16);

        WebSettings webSettings1 = webView1.getSettings();
        WebSettings webSettings2 = webView2.getSettings();
        WebSettings webSettings3 = webView3.getSettings();
        WebSettings webSettings4 = webView4.getSettings();
        WebSettings webSettings5 = webView5.getSettings();
        WebSettings webSettings6 = webView6.getSettings();
        WebSettings webSettings7 = webView7.getSettings();
        WebSettings webSettings8 = webView8.getSettings();
        WebSettings webSettings9 = webView9.getSettings();
        WebSettings webSettings10 = webView10.getSettings();
        WebSettings webSettings11 = webView11.getSettings();
        WebSettings webSettings12 = webView12.getSettings();
        WebSettings webSettings13 = webView13.getSettings();
        WebSettings webSettings14 = webView14.getSettings();
        WebSettings webSettings15 = webView15.getSettings();
        WebSettings webSettings16 = webView16.getSettings();


        webSettings1.setJavaScriptEnabled(true);
        webSettings3.setJavaScriptEnabled(true);
        webSettings2.setJavaScriptEnabled(true);
        webSettings4.setJavaScriptEnabled(true);
        webSettings5.setJavaScriptEnabled(true);
        webSettings6.setJavaScriptEnabled(true);
        webSettings7.setJavaScriptEnabled(true);
        webSettings8.setJavaScriptEnabled(true);
        webSettings9.setJavaScriptEnabled(true);
        webSettings10.setJavaScriptEnabled(true);
        webSettings11.setJavaScriptEnabled(true);
        webSettings12.setJavaScriptEnabled(true);
        webSettings13.setJavaScriptEnabled(true);
        webSettings14.setJavaScriptEnabled(true);
        webSettings15.setJavaScriptEnabled(true);
        webSettings16.setJavaScriptEnabled(true);

        if (Build.VERSION.SDK_INT >= 11) {
            webView1.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            webView2.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            webView3.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            webView4.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            webView5.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            webView6.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            webView7.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            webView8.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            webView9.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            webView10.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            webView11.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            webView12.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            webView13.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            webView14.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            webView15.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            webView16.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        CardView card1 = (CardView) findViewById(R.id.card1);
        CardView card2 = (CardView) findViewById(R.id.card2);
        CardView card3 = (CardView) findViewById(R.id.card3);
        CardView card4 = (CardView) findViewById(R.id.card4);
        CardView card5 = (CardView) findViewById(R.id.card5);
        CardView card6 = (CardView) findViewById(R.id.card6);
        CardView card7 = (CardView) findViewById(R.id.card7);
        CardView card8 = (CardView) findViewById(R.id.card8);
        CardView card9 = (CardView) findViewById(R.id.card9);
        CardView card10 = (CardView) findViewById(R.id.card10);
        CardView card11 = (CardView) findViewById(R.id.card11);
        CardView card12 = (CardView) findViewById(R.id.card12);
        CardView card13 = (CardView) findViewById(R.id.card13);
        CardView card14 = (CardView) findViewById(R.id.card14);
        CardView card15 = (CardView) findViewById(R.id.card15);
        CardView card16 = (CardView) findViewById(R.id.card16);


        TextView textView11 = (TextView) findViewById(R.id.textView11);
        TextView textView12 = (TextView) findViewById(R.id.textView12);
        TextView textView13 = (TextView) findViewById(R.id.textView13);
        TextView textView14 = (TextView) findViewById(R.id.textView14);
        TextView textView15 = (TextView) findViewById(R.id.textView15);
        TextView textView16 = (TextView) findViewById(R.id.textView16);
        TextView textView17 = (TextView) findViewById(R.id.textView17);
        TextView textView18 = (TextView) findViewById(R.id.textView18);
        TextView textView19 = (TextView) findViewById(R.id.textView19);
        TextView textView20 = (TextView) findViewById(R.id.textView20);
        TextView textView21 = (TextView) findViewById(R.id.textView21);
        TextView textView22 = (TextView) findViewById(R.id.textView22);
        TextView textView23 = (TextView) findViewById(R.id.textView23);
        TextView textView24 = (TextView) findViewById(R.id.textView24);
        TextView textView25 = (TextView) findViewById(R.id.textView25);
        TextView textView26 = (TextView) findViewById(R.id.textView26);

        textViews = new TextView[]{textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26};
        webViews = new WebView[]{webView1, webView2, webView3, webView4, webView5, webView6, webView7, webView8, webView9, webView10, webView11, webView12, webView13, webView14, webView15, webView16};
        cardViews = new CardView[]{card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15, card16};
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(STATE_LEVEL, sprawdzenie);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onStart() {
        super.onStart();
        backpress = 0;

        android.support.v7.app.ActionBar menu = getSupportActionBar();
        menu.setTitle(R.string.kinematyka);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (sprawdzenie == 101) {
        } else if (sprawdzenie == 102) {
            menu.setTitle(R.string.dynamika);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.dynamika));
        } else if (sprawdzenie == 103) {
            menu.setTitle(R.string.praca_moc_energia);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.pracaMocEnergia));
        } else if (sprawdzenie == 104) {
            menu.setTitle(R.string.bry_a_sztywna);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.bryla));
        } else if (sprawdzenie == 105) {
            menu.setTitle(R.string.termodynamika);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.termodynamika));
        } else if (sprawdzenie == 106) {
            menu.setTitle(R.string.grawitacja_i_kosmos);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.grawitacja));
        } else if (sprawdzenie == 107) {
            menu.setTitle(R.string.ruch_drgaj_cy);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.drgajacy));
        } else if (sprawdzenie == 108) {
            menu.setTitle(R.string.fale_mechaniczne);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.mechaniczne));
        } else if (sprawdzenie == 109) {
            menu.setTitle(R.string.elektrostatyka);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.Elektorstatyka));
        } else if (sprawdzenie == 110) {
            menu.setTitle(R.string.pr_d_sta_y);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.pradstatly));
        } else if (sprawdzenie == 111) {
            menu.setTitle(R.string.magnetyzm);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.magnetyzm));
        } else if (sprawdzenie == 112) {
            menu.setTitle(R.string.indukcja_elektromagnetyczna);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.IndukcjaElektro));
        } else if (sprawdzenie == 113) {
            menu.setTitle(R.string.pr_d_przemienny_i_obwody);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.przemienny));
        } else if (sprawdzenie == 114) {
            menu.setTitle(R.string.optyka);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.optyka));
        } else if (sprawdzenie == 115) {
            menu.setTitle(R.string.fizyka_wsp_czesna);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.wspolczesna));
        } else if (sprawdzenie == 100) {
            menu.setTitle(R.string.kinematyka);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.kinematyka));
        } else if (sprawdzenie == 116) {
            menu.setTitle(R.string.sta_e_fizyczne);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.stale));
        } else if (sprawdzenie == 117) {
            menu.setTitle(R.string.przedrostki);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.przedrostki));
        }

    }


    public void Info() {
        Intent infoActivity = new Intent(this, InfoActivity.class);
        startActivity(infoActivity);
    }

    public void FiszkiMaturalne() {


        if (sprawdzenieMat == 0) {
            Intent FiszkiDynamo = new Intent(this, FlashCardsActivity.class);
            FiszkiDynamo.putExtra("liczba", 20);
            materialDesignFAM.setClosedOnTouchOutside(true);
            startActivity(FiszkiDynamo);


        } else if (sprawdzenieMat == 2) {
            Intent FiszkiDynamo = new Intent(this, ActivityTest.class);
            FiszkiDynamo.putExtra("liczba", 21);
            materialDesignFAM.close(true);
            startActivity(FiszkiDynamo);

        } else if (sprawdzenieMat == 3) {
            Intent FiszkiDynamo = new Intent(this, FlashCardsActivity.class);
            FiszkiDynamo.putExtra("liczba", 22);
            materialDesignFAM.close(true);
            startActivity(FiszkiDynamo);
        }
/*
           Intent FiszkiDynamo = new Intent(this, ActivityTest.class);
            FiszkiDynamo.putExtra("liczba", 34);
            materialDesignFAM.close(true);
            startActivity(FiszkiDynamo);
        }
*/

    }

    public void Fiszki() {


        Intent FiszkiDynamo = new Intent(this, FlashCardsActivity.class);
        if (sprawdzenie == 0) {
            FiszkiDynamo.putExtra("flashCards", "kinematyka.txt");
            FiszkiDynamo.putExtra("liczba", 0);

        } else if (sprawdzenie == 1) {
            FiszkiDynamo.putExtra("flashCards", "dynamika.txt");
            FiszkiDynamo.putExtra("liczba", 1);
        } else if (sprawdzenie == 2) {

        }
        startActivity(FiszkiDynamo);

    }

    public void Nauka() {
        Intent Nauka = new Intent(this, NaukaActivity.class);
        overridePendingTransition(R.animator.animationenter, R.animator.animationleave);
        startActivity(Nauka);
    }

    @Override
    public void onBackPressed() {

        backpress++;

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence sequence = "Wciśnij jeszcze raz, aby wyjść";
        Toast toast = Toast.makeText(context, sequence, duration);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            if (backpress > 1) {
                super.onBackPressed();
            } else {
                toast.show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.kinematyka, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {


            Info();


            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        android.support.v7.app.ActionBar menu = getSupportActionBar();
        scrollView = (ScrollView) findViewById(R.id.scroll_view);
        int id = item.getItemId();

        scrollView.fullScroll(ScrollView.FOCUS_UP);
        String empty = "file:///android_asset/empty.html";


        if (id == R.id.kinematyka) {
            scrollView.fullScroll(ScrollView.FOCUS_UP);
            sprawdzenieMat = 1;
            sprawdzenie = 1;
            setViewsVisibility(10);
            int[] titles = {R.string.ruch_jednostajny,
                    R.string.ruch_jednostajnie_zmienny,
                    R.string.droga_w_ruchu_jednostajnie_zmiennym,
                    R.string.r_wnania_ruchu,
                    R.string.spadek_swobodny,
                    R.string.rzut_poziomy,
                    R.string.rzut_uko_ny,
                    R.string.ruch_po_okr_gu,
                    R.string.przy_pieszenie_do_rodkowe,
                    R.string.pr_dko_rednia
            };
            fillTextViews(titles);
            ArrayList<String> rawEquations = new ArrayList<>();
            rawEquations.add(" '$v↖{→}={∆s}/t [m/s]$ <br> $v↖{→}$ prędkość, $∆s$ przemieszczenie/przebyta droga, $t$ czas '");
            rawEquations.add("'$v↖{→}=v_0+at [m/s]$ , $a↖{→}={∆v}/t [m/s^2]$ <br> $v↖{→}$ prędkość, $v_0$ prędkość początkowa, $a↖{→}$ przyśpieszenie, $t$ czas, dla $a↖{→}>0$ ruch jednostajnie przyśpieszony, dla $a↖{→}<0$ ruch jednostajnie opóźniony '");
            rawEquations.add("'$s = v_0t +↙{-} {at^2}/2$ $[m]$,   $s = {v_0 + v_k}/2 t$,   $s = {v_k^2-v_0^2}/{2a}$ <br> $s$ droga , $a↖{→}$ przyśpieszenie, $t$ czas, $v_k$ prędkość końcowa, $v_0$ prędkość początkowa <br> $s_1:s_2:s_3 ..s_n = 1:3:5..n$ <br> Drogi przebyte przez ciało w ruchu jednostajnie przyśpieszonym bez prędkości początkowej mają się do siebie jak kolejne liczby nieparzyste.'");
            rawEquations.add("'$v↖{→}(t)=v_0+↙{-}at$ $[m/s]$ <br> $v(t)$ prędkość od czasu, $a↖{→}$ przyśpieszenie, $t$ czas <br> $x(t)=x_0+s$ $[m]$ <br> $x(t)$ położenie od czasu, $x_0$ położenie początkowe, w miejsce $s$ wstawiamy wzór na drogę w zależności od ruchu jakim porusza się rozpatrywane ciało '");
            rawEquations.add("'Przy spadku swobodnym, w pionie, bez oporów ruchu $a↖{→}=g↖{→}$, $v↖{→}_0 = 0$. Spadek swobodny jest ruchem jednostajnie przyśpieszonym, Dla rzutu pionowego $h(t)=x_0+↙{-}v_0↖{→}t+↙{-}{g↖{→}t^2}/2$, gdzie $g$ to przyśpiesznie ziemskie.'");
            rawEquations.add("'$Z=v↖{→}_ot$ ,  $v↖{→}_{ky}=g↖{→}t$,  $tgα={v_y}/{v_x}={g_t}/v_o$,   $v↖{→}_c=√{v↖{→}_x^2+v↖{→}_y^2}$ <br> $Z$ zasięg, $v↖{→}_{ky}$ prędkość końcowa pionowej składowej wekotra prędkości całkowitej, $tgα$ tangens kąta pod jakim ciało uderzy w ziemię, $v↖{→}_c$ prędkość całkowita, która zawsze jest styczna do toru, $v↖{→}_x$ pozioma składowa wektora prędkośi całkowitej, $v↖{→}_y$ pionowa składowa wektora prędkości całkowitej '");
            rawEquations.add("'$v↖{→}_{0y}=v_0sinα$, $v↖{→}_{0x}=v_0cosα$, $t_{wz}={v↖{→}_0sinα}/g↖{→}$, $t_{cal}={2v_0sinα}/g$, $h_{max}={v_0^2sin^2α}/{2g}$, $Z={v_0^2sin2α}/g$ <br> $α$ kąt pod jakim ciało jest nachylone do osi O:X, $v↖{→}_0$, $v_0$ prędkość początkowa, $v↖{→}_{0x}$  prędkość początkowa poziomej skłądowej prędkości, $v↖{→}_{0y}$  prędkość początkowa pionowej składowej prędkości, $t_{wz}$ czas wznoszenia, $t_{cal}$ czas całkowity, $h_{max}$ maksymalna wysokość na jaką wzniesie się ciało. Czas wznoszenia jest równy czasowi spadania ciała.'");
            rawEquations.add("'$v↖{→}= s/t= {2πr}/T = {2πrf}$, $f=1/T$ <br> $v↖{→}$ prędkość ciała w ruchu po okręgu, $f$ czestotliwość, $r$ promień okręgu, $T$ okres, czas jednego pełnego ruchu, '");
            rawEquations.add("'Szybkość średnia to stosunek całkowitej drogi przebytej podczasu ruchu do całkowitego czasu trwania tego ruchu.'");
            rawEquations.add("'$a_d↖{→}=v^2/r$ $[m/s^2]$ <br> $a_d↖{→}$ przyśpieszenie dośrodkowe, $r$ promień, $v$ prędkość'");
            fillWebViews(generateEquationsInHtmlStrings(rawEquations));
            materialDesignFAM.setVisibility(View.VISIBLE);
            menu.setTitle(R.string.kinematyka);
        }

/*
        } else if (id == R.id.dynamika) {

            sprawdzenieMat = 2;
            sprawdzenie = 2;
            scrollView.fullScroll(ScrollView.FOCUS_UP);


            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.VISIBLE);
            card3.setVisibility(View.VISIBLE);
            card4.setVisibility(View.VISIBLE);
            card5.setVisibility(View.VISIBLE);
            card6.setVisibility(View.VISIBLE);
            card7.setVisibility(View.VISIBLE);
            card8.setVisibility(View.GONE);
            card9.setVisibility(View.GONE);
            card10.setVisibility(View.GONE);
            card11.setVisibility(View.GONE);
            card12.setVisibility(View.GONE);
            card13.setVisibility(View.GONE);
            card14.setVisibility(View.GONE);
            card15.setVisibility(View.GONE);
            card16.setVisibility(View.GONE);

            textView11.setVisibility(View.VISIBLE);
            textView12.setVisibility(View.VISIBLE);
            textView13.setVisibility(View.VISIBLE);
            textView14.setVisibility(View.VISIBLE);
            textView15.setVisibility(View.VISIBLE);
            textView16.setVisibility(View.VISIBLE);
            textView17.setVisibility(View.VISIBLE);
            textView18.setVisibility(GONE);
            textView19.setVisibility(GONE);
            textView20.setVisibility(GONE);
            textView21.setVisibility(GONE);
            textView22.setVisibility(GONE);
            textView23.setVisibility(GONE);
            textView24.setVisibility(GONE);
            textView25.setVisibility(GONE);
            textView26.setVisibility(GONE);


            webView1.setVisibility(View.VISIBLE);
            webView2.setVisibility(View.VISIBLE);
            webView3.setVisibility(View.VISIBLE);
            webView4.setVisibility(View.VISIBLE);
            webView5.setVisibility(View.VISIBLE);
            webView6.setVisibility(View.VISIBLE);
            webView7.setVisibility(View.VISIBLE);
            webView8.setVisibility(GONE);
            webView9.setVisibility(GONE);
            webView10.setVisibility(GONE);
            webView11.setVisibility(GONE);
            webView12.setVisibility(GONE);
            webView13.setVisibility(GONE);
            webView14.setVisibility(GONE);
            webView15.setVisibility(GONE);
            webView16.setVisibility(GONE);


            textView11.setText(R.string.pierwsza_zasada_dynamiki);
            textView12.setText(R.string.druga_zasada_dynamiki);
            textView13.setText(R.string.trzecia_zasada_dynamiki);
            textView14.setText(R.string.dynamiczne_r_wania_ruchu);
            textView15.setText(R.string.tarcie);
            textView16.setText(R.string.r_wnia_pochy_a);
            textView17.setText(R.string.niewa_ko_i_winda);


            String path = "file:///android_asset/";
            String zasadaJeden = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Jeżeli $F↖{→}_w=0$ to w izolowanym układzie ciało/punkt materialny spoczywa, lub porusza się ruchem jednostajnym, $F↖{→}_w$ siła wypadkowa';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String zasadaDwa = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$a↖{→}=F↖{→}/m [{{kg*m/{s^2}}/{kg}=N/{kg}]$ <br> $F↖{→}={∆p↖{→}}/{t}$ <br> $p↖{→}=mv↖{→}$ $[kg*{m/s}]$ <br> $F↖{→}$ siła, $a↖{→}$ przyśpieszenie, $m$ masa, $∆p$ zmiana pędu, $t$ czas, $N$ Newton, jednostka siły <br> $p↖{→}=p↖{→}_1+p↖{→}_{2}...p↖{→}_n={const}↖{→}$ <br> Suma pędów ciał wchodzących w skład układu izolowanego jest stała. <br> $p↖{→}$ pęd, $v↖{→}$ prędkość, $m$ masa, $p↖{→}_c$ pęd całkowity,';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String trzeciaZasda = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$F↖{→}_{AB}=-F↖{→}_{BA}$ <br> $F↖{→}_{AB}$ siła z jaką ciało A działa na ciało B, $F↖{→}_{BA}$ siła z jaką ciało B działa na ciało A';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String dynamiczneRownaniaWprowadzenie = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Dla dwóch bloczków o masach $m_1$ i $m_2$ połączonych nierozciągliwą, lekką nitką, bez siły tarcia ciągniętych siłą $F↖{→}$, zaczepioną o drugi bloczek, o zwrocie skierowanym w prawo <br> $F_{w1}=F_n$, $F_{w2}=F-F_n$ <br> $m_1a=F_n$, $m_2a=F-F_n$ <br>  $m_1a+m_2a=F ⇒ a(m_1+m_2)=F ⇒$ $a=F/{m_1+m_2}$ <br> $F_{w1}$, $F_{w2}$ siła wypadkowa pierwsza u druga, $F_n$ siła naciągu miedzy bloczkami, $a_1$, $a_2$ przyśpieszenie pierwszego, drugie ciała, $a$ przyśpieszenie układu ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String tarcie = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$T=μF_n$ <br> $T↖{→}_s=μ_sF_n$, $T↖{→}_k=μ_kF_n$ <br> $T↖{→}$ tarcie, $μ$ współczynnik tarcia, $F_n$ siła nacisku, $T↖{→}_s$ tarcie statyczne, $μ_s$ wsp. tarcia statycznego, $T↖{→}_k$ tarcie kinetyczne $μ_k$ wsp. tarcia kinetycznego <br> $T_{smax}>T_{kmax}$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String rowniaWprowadzenie = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Dla ciała leżącego na boku $S$ równi pochyłej o krótszej przyprostokątnej $h$ i dłuższej $l$, przeciwprostokątnej $S$, oraz kącie $α$, dla którego $sinα=h/s$ <br> $F↖{→}_g=mg$,  $sinα=F_s/F_g ⇒ F↖{→}_s=mgsinα$, $cosα=F_n/F_g ⇒ F↖{→}_n=mgcosα$, $T↖{→}=μmgcosα$ <br> $F↖{→}_n$ siła nacisku, $F↖{→}_s$ siła zsuwająca, $F↖{→}_g$ siła grawitacji, $T↖{→}$ siła tarcia, $μ$ wsp. tarcia na równi, na ciało wjeżdżające na równię działa jedynie siła zsuwająca.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String winda1 = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Dla windy jadącej w górę $F↖{→}_n=mg+ma$, Dla windy jadącej w dół $F↖{→}_n=mg-ma$, Ruch przyśpieszony w górę to ruch opóźniony w dół, a przyśpieszony w dół, to opóźniony w górę <br> $F↖{→}_n$ siła nacisku, $g$ przyśpieszenie ziemskie, $a$ przyśpieszenie windy, $m$ masa obiektu w windzie. Jeżeli $a=g$ to występuje nieważkość.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            webView1.loadDataWithBaseURL("file:///android_asset/", zasadaJeden, "text/html", "UTF-8", null);
            webView2.loadDataWithBaseURL("file:///android_asset/", zasadaDwa, "text/html", "UTF-8", null);
            webView3.loadDataWithBaseURL("file:///android_asset/", trzeciaZasda, "text/html", "UTF-8", null);
            webView4.loadDataWithBaseURL("file:///android_asset/", dynamiczneRownaniaWprowadzenie, "text/html", "UTF-8", null);
            webView5.loadDataWithBaseURL("file:///android_asset/", tarcie, "text/html", "UTF-8", null);
            webView6.loadDataWithBaseURL("file:///android_asset/", rowniaWprowadzenie, "text/html", "UTF-8", null);
            webView7.loadDataWithBaseURL("file:///android_asset/", winda1, "text/html", "UTF-8", null);


            materialDesignFAM.setVisibility(View.VISIBLE);
            menu.setTitle(R.string.dynamika);


        } else if (id == R.id.pracaMocEnergia) {


            scrollView.fullScroll(ScrollView.FOCUS_UP);


            sprawdzenieMat = 3;
            sprawdzenie = 3;

            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.VISIBLE);
            card3.setVisibility(View.VISIBLE);
            card4.setVisibility(View.VISIBLE);
            card5.setVisibility(View.VISIBLE);
            card6.setVisibility(View.GONE);
            card7.setVisibility(View.GONE);
            card8.setVisibility(View.GONE);
            card9.setVisibility(View.GONE);
            card10.setVisibility(View.GONE);
            card11.setVisibility(View.GONE);
            card12.setVisibility(View.GONE);
            card13.setVisibility(View.GONE);
            card14.setVisibility(View.GONE);
            card15.setVisibility(View.GONE);
            card16.setVisibility(View.GONE);

            textView11.setVisibility(View.VISIBLE);
            textView12.setVisibility(View.VISIBLE);
            textView13.setVisibility(View.VISIBLE);
            textView14.setVisibility(View.VISIBLE);
            textView15.setVisibility(View.VISIBLE);
            textView16.setVisibility(View.VISIBLE);
            textView17.setVisibility(GONE);
            textView18.setVisibility(GONE);
            textView19.setVisibility(GONE);
            textView20.setVisibility(GONE);
            textView21.setVisibility(GONE);
            textView22.setVisibility(GONE);
            textView23.setVisibility(GONE);
            textView24.setVisibility(GONE);
            textView25.setVisibility(GONE);
            textView26.setVisibility(GONE);


            webView1.setVisibility(View.VISIBLE);
            webView2.setVisibility(View.VISIBLE);
            webView3.setVisibility(View.VISIBLE);
            webView4.setVisibility(View.VISIBLE);
            webView5.setVisibility(View.VISIBLE);
            webView6.setVisibility(View.VISIBLE);
            webView7.setVisibility(GONE);
            webView8.setVisibility(GONE);
            webView9.setVisibility(GONE);
            webView10.setVisibility(GONE);
            webView11.setVisibility(GONE);
            webView12.setVisibility(GONE);
            webView13.setVisibility(GONE);
            webView14.setVisibility(GONE);
            webView15.setVisibility(GONE);
            webView16.setVisibility(GONE);


            textView11.setText(R.string.praca);
            textView12.setText(R.string.moc);
            textView13.setText(R.string.energia_kientyczna);
            textView14.setText(R.string.energia_potencjalna);
            textView15.setText(R.string.energia_potencjalna_spr_ysto_ci);
            textView16.setText(R.string.zasadaEnergii);


            String path = "file:///android_asset/";
            String praca = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$W=F↖{→}◦∆r↖{→}$, $W=Frcosα$, $[N*m=J]$ <br> $W$ praca, $F↖{→}$ siła, $∆r↖{→}$ zmiana położenia, $α$ kąt zawarty między wektorem siły i przemieszczenia, $J$ dżul <br> $W=∫F↖{→}{dr↖{→}$ <br> $W=∫F↖{→}dr↖{→}$ całka siły po przemiszeczeniu ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String moc = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$P=W/t$, $[J/s=W]$, gdy $v↖{→}={const}↖{→}$ to $P=Fv$ <br> $P$ moc, $v$ prędkość, $F$ siła, jednostka mocy to Wat $W$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String energiaKinetyczna = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$E_k={mv^2}/2$, $[kg * m^2/{s^2}=J]$ <br> $E_k$ energia kinetyczna, $m$ masa, $v↖{→}$ prędkość, jednostka energi to dżul $J$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String energiaPotencjalna = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$E_p=mgh$, $[kg*m^2/{s^2}=J]$, $R_z>>h$ <br> $E_p$ energia potencjalna, $m$ masa, $g↖{→}$ przyśpieszenie grawitacyjne, $h$ wysokość, $R_z$ promień ziemi, $J$ dżul';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String energiaSprez = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$E_{ps}={k*x^2}/2$, $[J]$ <br> $E_{ps}$ energia potencjalna sprężystości, $k$ współczynnik sprężystości $[N/m]$, $x$ wychylenie/wydłużenie sprężyny';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String zasadaZachowania = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'W izolowanym układzie, całkowita energia mechaniczna nie zmienia sie.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            webView1.loadDataWithBaseURL("file:///android_asset/", praca, "text/html", "UTF-8", null);
            webView2.loadDataWithBaseURL("file:///android_asset/", moc, "text/html", "UTF-8", null);
            webView3.loadDataWithBaseURL("file:///android_asset/", energiaKinetyczna, "text/html", "UTF-8", null);
            webView4.loadDataWithBaseURL("file:///android_asset/", energiaPotencjalna, "text/html", "UTF-8", null);
            webView5.loadDataWithBaseURL("file:///android_asset/", energiaSprez, "text/html", "UTF-8", null);
            webView6.loadDataWithBaseURL("file:///android_asset/", zasadaZachowania, "text/html", "UTF-8", null);

            materialDesignFAM.setVisibility(View.VISIBLE);
            menu.setTitle(R.string.praca_moc_energia);


        } else if (id == R.id.bryla) {

            scrollView.fullScroll(ScrollView.FOCUS_UP);

            sprawdzenieMat = 4;
            sprawdzenie = 4;

            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.VISIBLE);
            card3.setVisibility(View.VISIBLE);
            card4.setVisibility(View.VISIBLE);
            card5.setVisibility(View.VISIBLE);
            card6.setVisibility(View.VISIBLE);
            card7.setVisibility(View.VISIBLE);
            card8.setVisibility(View.VISIBLE);
            card9.setVisibility(View.VISIBLE);
            card10.setVisibility(View.VISIBLE);
            card11.setVisibility(View.VISIBLE);
            card12.setVisibility(View.GONE);
            card13.setVisibility(View.GONE);
            card14.setVisibility(View.GONE);
            card15.setVisibility(View.GONE);
            card16.setVisibility(View.GONE);

            textView11.setVisibility(View.VISIBLE);
            textView12.setVisibility(View.VISIBLE);
            textView13.setVisibility(View.VISIBLE);
            textView14.setVisibility(View.VISIBLE);
            textView15.setVisibility(View.VISIBLE);
            textView16.setVisibility(View.VISIBLE);
            textView17.setVisibility(View.VISIBLE);
            textView18.setVisibility(View.VISIBLE);
            textView19.setVisibility(View.VISIBLE);
            textView20.setVisibility(View.VISIBLE);
            textView21.setVisibility(View.VISIBLE);
            textView22.setVisibility(GONE);
            textView23.setVisibility(GONE);
            textView24.setVisibility(GONE);
            textView25.setVisibility(GONE);
            textView26.setVisibility(GONE);


            webView1.setVisibility(View.VISIBLE);
            webView2.setVisibility(View.VISIBLE);
            webView3.setVisibility(View.VISIBLE);
            webView4.setVisibility(View.VISIBLE);
            webView5.setVisibility(View.VISIBLE);
            webView6.setVisibility(View.VISIBLE);
            webView7.setVisibility(View.VISIBLE);
            webView8.setVisibility(View.VISIBLE);
            webView9.setVisibility(View.VISIBLE);
            webView10.setVisibility(View.VISIBLE);
            webView11.setVisibility(View.VISIBLE);
            webView12.setVisibility(GONE);
            webView13.setVisibility(GONE);
            webView14.setVisibility(GONE);
            webView15.setVisibility(GONE);
            webView16.setVisibility(GONE);


            textView11.setText(R.string.ruch_obrotowy);
            textView12.setText(R.string.droga_k_towa_w_ruchu_po_okr_gu);
            textView13.setText(R.string.zale_no_ci_mi_dzy_warto_ciami_liniowymi_a_k_towymi);
            textView14.setText(R.string.moment_si_y);
            textView15.setText(R.string.moment_bezw_adno_ci);
            textView16.setText(R.string.twierdzenie_steinera_i_rodek_masy);
            textView17.setText(R.string.pierwsza_zasada_dynamiki_ruchu_obrotowego);
            textView18.setText(R.string.druga_zasada_dynamiki_ruchu_obrotowego);
            textView19.setText(R.string.dynamiczne_r_wania_ruchu);
            textView20.setText(R.string.moment_p_du);
            textView21.setText(R.string.energia_kinetyczna_ruchu_obrotowego);


            String path = "file:///android_asset/";
            String ruchObrotowy = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$ω↖{→}=α/t={2π}/T={2πf}$ $[{rad}/s]$, <br> $a↖{→}_s=εr$, $[{rad}/s^2]$ <br> $a↖{→}_c=√{a↖{→}_s^2+a↖{→}_d^2$, <br> $ε↖{→}={Δω}/{Δt}$ $[{rad}/s^2]$ <br> $ω↖{→}$ szybkość kątowa, $T$ okres (czas jednego pełnego ruchu), $f$ częstotliwość, $t$ czas, $a↖{→}_s$ przyśpieszenie styczne (do okręgu), $r$ promień okręgu, $a↖{→}_c$ przyśpieszenie całkowite, $ε↖{→}$ przyśpieszenie kątowe,';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String ruchObrotowy2 = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$ω↖{→}_k =ω_o+↙{-}εt$, $α=ω↖{→}_0t+↙{-}{εt^2}/2$ $[rad]$, $α={{ω_0+ω_k}/2}t$, $α={ω_k^2-ω_0^2}/2ε$ <br> $α$ droga kątowa wyrażona w radianach $[{rad}]$, $ω↖{→}_o$ szybkość kątowa początkowa, $ω↖{→}_k$ szybkość kątowa końcowa';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String zaleznosciLinKat = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$s=rα$, $v_s↖{→}=rω$, $a_s↖{→}=rε$ <br> $s$ droga, $r$ odległość od osi obrotu, $α$ droga kątowa, $v_s↖{→}$ prędkość styczna, $ω↖{→}$ prędkość kątowa, $a_s↖{→}$ przyśpieszenie styczne, $ε↖{→}$ przyśpieszenie kątowe';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String momentSily = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$M↖{→}=r↖{→}×F↖{→}, $[N*m]$ M↖{→}=rFsinα$ <br> $M↖{→}$ moment siły, $r↖{→}$ wektor przemieszczenia, $F↖{→}$ siła, $α$ kąt zawarty między wektorem przemieszczenia a siły';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


            String momentBezwladnosci = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$I=∑↖{n}↙{i=1}mr^2$, $[kg*m^2]$ $I=mr^2$ <br> $I$ moment bezwładności, $∑$ suma, $m$ masa, $r$ promień <br> Momenty bezwładności wybranych brył/przedmiotów: <br> pręt o długości $l$ $I=1/{12}ml^2$ <br> walec $I=1/2mr^2$ <br> krążek $I=1/2mr^2$ <br> cienkościenny pierścień $I=mr^2$ <br> kula $I=2/5mr^2$, $r$ promień';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String twierdzenieSTEI = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$I=I_0+md^2$ <br> $I$ moment bezwladnosci, $I_0$ moment bezwładnośći dla bryły, w której oś obrotu przechodzi przez środek masy, $m$ masa, $d$ odległość od osi obrotu <br> $x_{sr}={∑m_1x_1}/∑m_i$, $r↖{→}=1/M↖{→}{∑m_ir↖{→}_i$ <br> Dla układu wsp. rozpoczynającego się w środku najcięższego ciała, $x_{sr}$ pierwsza współrzędna środka masy, $∑m_ir_i$ suma iloczynów mas i odległości od położenia 0, $∑m_i$ masa punktów całęgo układu, $r↖{→}$ wektor położenia środka, $M↖{→}$ moment siły ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String zasadaBrylyjeden = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Jeżeli $M↖{→}_w=0$ to w izolowanym układzie bryła pozostaje w spoczynku, lub porusza się ruchem jednostjanym obrotowym. ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String zasadaObr2 = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$E↖{→}=M↖{→}/I  ⇒ M↖{→}=E↖{→}/I$, $M↖{→}={ΔL↖{→}}/{Δt}$ <br> $M↖{→}$ moment siły, $E↖{→}$ przyśpieszenie kątowe, $I$ moment bezwładności, $ΔL↖{→}$ zmiana momentu pędu, $Δt$ zmiana czasu';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


            String rownanieWPR = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Dla krążka o masie $m_k$ przywieszonego do sufitu, mogącego się swobodnie obracać, z przywieszonym bloczkiem na lekkim, nierozciągliwym sznurku o masie m <br> $F_w↖{→}=F_g↖{→}-F_n↖{→}$ <br> $IE↖{→}=M↖{→}$ <br> $ma=mg-F_n$ <br> $IE=rF_n ⇒ 1/2m_k*r^2*a/r=r*F_n$, $a={mg}/{m+1/2m_k}$ <br> $F_w↖{→}$ siła wypadkowa, $F_g↖{→}$ siła grawitacji, $F_n↖{→}$ siła naciągu, $I$ moment bezwładności krążka, $E↖{→}$ przyśpieszenie kątowe, $M↖{→}$ moment siły działający na krążek, $a↖{→}$przyśpieszenie liniowe bloczka, $m$ masa bloczka, $m_k$ masa krążka, $r$ promień krążka';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


            String momentPedu = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$L↖{→}=r↖{→}×p↖{→}$, $[kg*m^2]$ $L↖{→}=rmv, L↖{→}=Iω$ <br> $L↖{→}$ moment pedu, $r↖{→}$ promień, $p↖{→}$ pęd, $m$ masa, $v↖{→}$ prędkość, $I$ moment bezwładności, $ω↖{→}$ prędkość katowa <br> Jeżeli $M↖{→}_w=0$ to $L↖{→}={const}↖{→}$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String energiaKin = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Dla toczącej się kuli $E_k={Iω^2}/2+{mv↖{→}^2}/2$, $[J]$ $v↖{→}=ωr$ <br> $E_k$ energia kinetyczna, $I$ moment bezwładności, $ω↖{→}$ szybkość kątowa, $m$ masa, $v↖{→}$ prędkość, $r$ promień';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            webView1.loadDataWithBaseURL("file:///android_asset/", ruchObrotowy, "text/html", "UTF-8", null);
            webView2.loadDataWithBaseURL("file:///android_asset/", ruchObrotowy2, "text/html", "UTF-8", null);
            webView3.loadDataWithBaseURL("file:///android_asset/", zaleznosciLinKat, "text/html", "UTF-8", null);
            webView4.loadDataWithBaseURL("file:///android_asset/", momentSily, "text/html", "UTF-8", null);
            webView5.loadDataWithBaseURL("file:///android_asset/", momentBezwladnosci, "text/html", "UTF-8", null);
            webView6.loadDataWithBaseURL("file:///android_asset/", twierdzenieSTEI, "text/html", "UTF-8", null);
            webView7.loadDataWithBaseURL("file:///android_asset/", zasadaBrylyjeden, "text/html", "UTF-8", null);
            webView8.loadDataWithBaseURL("file:///android_asset/", zasadaObr2, "text/html", "UTF-8", null);
            webView9.loadDataWithBaseURL("file:///android_asset/", rownanieWPR, "text/html", "UTF-8", null);
            webView10.loadDataWithBaseURL("file:///android_asset/", momentPedu, "text/html", "UTF-8", null);
            webView11.loadDataWithBaseURL("file:///android_asset/", energiaKin, "text/html", "UTF-8", null);


            materialDesignFAM.setVisibility(View.VISIBLE);
            menu.setTitle(R.string.bry_a_sztywna);


        } else if (id == R.id.termodynamika) {

            scrollView.fullScroll(ScrollView.FOCUS_UP);


            sprawdzenieMat = 5;
            sprawdzenie = 5;

            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.VISIBLE);
            card3.setVisibility(View.VISIBLE);
            card4.setVisibility(View.VISIBLE);
            card5.setVisibility(View.VISIBLE);
            card6.setVisibility(View.VISIBLE);
            card7.setVisibility(View.VISIBLE);
            card8.setVisibility(View.VISIBLE);
            card9.setVisibility(View.VISIBLE);
            card10.setVisibility(View.VISIBLE);
            card11.setVisibility(View.VISIBLE);
            card12.setVisibility(View.VISIBLE);
            card13.setVisibility(View.VISIBLE);
            card14.setVisibility(View.VISIBLE);
            card15.setVisibility(View.VISIBLE);
            card16.setVisibility(View.VISIBLE);

            textView11.setVisibility(View.VISIBLE);
            textView12.setVisibility(View.VISIBLE);
            textView13.setVisibility(View.VISIBLE);
            textView14.setVisibility(View.VISIBLE);
            textView15.setVisibility(View.VISIBLE);
            textView16.setVisibility(View.VISIBLE);
            textView17.setVisibility(View.VISIBLE);
            textView18.setVisibility(View.VISIBLE);
            textView19.setVisibility(View.VISIBLE);
            textView20.setVisibility(View.VISIBLE);
            textView21.setVisibility(View.VISIBLE);
            textView22.setVisibility(View.VISIBLE);
            textView23.setVisibility(View.VISIBLE);
            textView24.setVisibility(View.VISIBLE);
            textView25.setVisibility(View.VISIBLE);
            textView26.setVisibility(View.VISIBLE);


            webView1.setVisibility(View.VISIBLE);
            webView2.setVisibility(View.VISIBLE);
            webView3.setVisibility(View.VISIBLE);
            webView4.setVisibility(View.VISIBLE);
            webView5.setVisibility(View.VISIBLE);
            webView6.setVisibility(View.VISIBLE);
            webView7.setVisibility(View.VISIBLE);
            webView8.setVisibility(View.VISIBLE);
            webView9.setVisibility(View.VISIBLE);
            webView10.setVisibility(View.VISIBLE);
            webView11.setVisibility(View.VISIBLE);
            webView12.setVisibility(View.VISIBLE);
            webView13.setVisibility(View.VISIBLE);
            webView14.setVisibility(View.VISIBLE);
            webView15.setVisibility(View.VISIBLE);
            webView16.setVisibility(View.VISIBLE);

            textView11.setText(R.string.skala_kelwina);
            textView12.setText(R.string.ci_nienie_i_obj_to);
            textView13.setText(R.string.ciep_o_w_a_ciwe);
            textView14.setText(R.string.cz_steczka);
            textView15.setText(R.string.r_wnanie_clapeyrona);
            textView16.setText(R.string.przemiana_izotermiczna_t_const);
            textView17.setText(R.string.przemina_izobaryczna_p_const);
            textView18.setText(R.string.przemiana_izohoryczna_v_const);
            textView19.setText(R.string.przemiana_adiabatyczna_q_const);
            textView20.setText(R.string.cieplo_przy_obje);
            textView21.setText(R.string.energia_kinetyczna);
            textView22.setText(R.string.pierwsza_zasada_termodynamiki);
            textView23.setText(R.string.praca);
            textView24.setText(R.string.druga_zasada_termodynamiki);
            textView25.setText(R.string.sprawno);
            textView26.setText(R.string.entropia);


            String path = "file:///android_asset/";
            String kelwin = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$0°K=-273,15°C$,$0°C=273,15°K$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String liczbamoli = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$n={m_s/M}=N/N_a=V/V_{mol}$ <br> $n$ liczba moli, $m_s$ masa substancji $M$ masa molowa, $N$ liczba cząstek gazu, $N_a$ liczba avogadra, $V$ objętość gazu, $V_{mol}$ objętość molowa gazu <br> $N_a=6,022*10^23$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String clapeyron = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Dla gazu doskonałego (Clapeyron) <br> $pV=nRT$ <br> $pV={NKT}$ <br> Dla gazu rzeczywistego (van der Waals) <br> $(p+a/V_m^2)(V_m-b)=RT$ <br> $p$ ciśnienie $[N/m={Pa}]$, $N$ liczba cząstek gazu, $K$ stała Boltzmana  $V$ objętość $[m^3]$, $a,b$ stałe dla danego gazu, $V_m=V/n$ objętość molowa  $n$ liczba moli, $R$ stała gazowa $R=8,31$ $[J/{{mol}*K}]$, $T$ temperatura $[K]$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String przemianaizotermiczna = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$pV={const}$, $p$ ciśnienie, $V$ objętość <br> Jeżeli podczas przemiany masa gazu nie ulega zmianie to ciśnienie jest odwrotnie proporcjonalne do objętośći.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String przemianaIzobaryczna = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$V/T=const$, $V$ objętość, $T$ temperatura <br> Dla stałej masy gazu objętość jest wprost proporcjonalna do temperatury.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String przeminaIzohoryczna = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$p/T=const$, $p$ ciśnienie, $T$ temperatura <br> Dla stałej masy gazu ciśnienie jest wprost proporcjonalne do temperatury.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String adiabatycznaWprowadzenie = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'W przemianie adiabatycznej, nie zachodzi wymiana ciepła z otoczeniem, podczas sprężania wzrasta temperatura i ciśnienie gazu. <br> $pV^χ={const}$, $p_0V_0^χ=p_kV_k^χ$, $χ=C_p/C_v$ <br> $p$ ciśnienie, $V$ objętość, $χ$ współczynnik adiabaty, $C_p$ ciepło molowe przy stałym ciśnieniu, $C_v$ ciepło molowe przy stałej objętości, $p_0$ ciśnienie początkowe, $V_0$ objętość początkowa, $p_k$ ciśnienie końcowe, $V_k$ objętość końcowa';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


            String energiaKinetycznaTermo = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$E_{ksr}=i/2KT$, $[J]$ $E_{ksr}$ średnia energia kinetyczna, $K$ stała Boltzmana, $T$ temperatura <br> $i=3$  dla cząsteczek 1 atomowych, $i=5$ dla cząsteczek 2 atomowych, $i=6$ dla cząsteczek 3 i więcej atomowych';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String termoJeden = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$ΔU=Q+W$, $[J]$ $ΔU=nC_vΔT$ <br> $ΔU$ zmiana energii wewnętrznej, $Q$ ciepło, $W$ praca, $ΔT$ zmiana temperatury, $n$ liczba moli, $C_v$ ciepło molowe przy stałej objetosci';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String pracaTermo = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$W=∫_cpdV$ lub $W=-∫_cpdV$, dla przemiany izohorycznej $W=0$ <br> Praca to pole figury pod wykresem ciśnienia od objętości, sprężaniu gazu czyli dodatniej pracy sił zewnęrznych towarzyszy wzrost tempratury, a rozpręzaniu czyli ujemnej pracy sił zewnętrznych spadek temperatury. Jeżeli siły zwenętrzne wykonują ujemną pracę to gaz wykonuje dodatnią. W zamkniętym cyklu termodynamicznym praca zawsze jest dodatnia.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String drugaZasada = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Niemożliwy jest taki proces termodynamiczny, którego jedynym rezultatem byłoby przekazanie ciepła przez ciało chłodniejsze do ciała cieplejszego. Niemożliwe jest zbudowanie silnika cieplnego, którego sprawność wynosi 100%.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String entropia = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$S={ΔQ}/T$, $[J/K]$ <br> Dla procesów odwracalnych i nieodwracalnych mozemy zapisać nierówność $S≥{ΔQ}/T$ <br> $S$ entropia czyli miara nieuporządkowania, $ΔQ$ zmiana ciepła, $T$ temperatura, drugą zasadę termodynamiki można zapisać następująco: <br> Całkowita entropia układu nie może maleć.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String sprawnosc = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$η=W/Q_1={Q_1-Q_2}/Q_1=1-Q_2/Q_1$ <br> Dla silników Carno $η={T_1-T_2}/T_1=1-T_2/T_1$ <br> $η$ sprawność, $W$ praca, $Q_1$ ciepło początkowe, $Q_2$ ciepło końcowe, $T_1$ temperatura początkowa, $T_2$ temperatura końcowa';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String cisnienieobj = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$ρ=m/V$ $[{kg}/m^3]$, $p=F↖{→}_n/s={mg↖{→}}/s$ $[N/m^2=Pa]$ <br> $p_h=ρgh$ <br> $F↖{→}_w=ρ_cgV_{ciala}$ <br> $ρ$ gęstość, $m$ masa $V$ objętość, $p$ ciśnienie, $F↖{→}_n$ siła nacisku, $g↖{→}$ przyśpiesznie grawitacyjne, $Pa$ pascal, $p_h$ ciśnienie hydrostatyczne, $h$ wysokość, $F↖{→}_w$ siła wyporu, $ρ_c$ gęstość cieczy, $V_{ciala}$ objętość zanurzonej częsci ciała';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String cieploWlasciwe = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$C_w=Q/{mΔT}$ $[J/{kg*K}]$ <br> $Q=mC_wΔT$ <br> $C_w$ ciepło właściwe, $Q$ ciepło, Ciepło właściwe ważnych substancji to $C_{wody}=4190$ <br> $[J/{kg*k}]$ $C_{lodu}=2100$  $[J/{kg*k}]$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String cieploPrzy = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$Q=nCΔT$ <br> $C$ ciepło w zależności od rodzaju przemiany <br> $C_v=Q_v/{n*ΔT}$ <br> Dla czastek 1 atomowych $C_v=3/2R$, a $C_p=5/2R$, dla czastek 2 atomowych $C_v=3/2R$, a $C_p=7/2R$ <br> $Q_v$ ciepło przy stałej objętości, $Q_p$ ciepło przy stałym ciśnieniu, $ΔT$ rożnica temperatur, $n$ liczba moli <br> $C_p$ ciepło molowe przy stałym ciśnieniu, $C_v$ ciepło molowe przy stałej objętości';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


            webView1.loadDataWithBaseURL("file:///android_asset/", kelwin, "text/html", "UTF-8", null);
            webView2.loadDataWithBaseURL("file:///android_asset/", cisnienieobj, "text/html", "UTF-8", null);
            webView3.loadDataWithBaseURL("file:///android_asset/", cieploWlasciwe, "text/html", "UTF-8", null);
            webView4.loadDataWithBaseURL("file:///android_asset/", liczbamoli, "text/html", "UTF-8", null);
            webView5.loadDataWithBaseURL("file:///android_asset/", clapeyron, "text/html", "UTF-8", null);
            webView6.loadDataWithBaseURL("file:///android_asset/", przemianaizotermiczna, "text/html", "UTF-8", null);
            webView7.loadDataWithBaseURL("file:///android_asset/", przemianaIzobaryczna, "text/html", "UTF-8", null);
            webView8.loadDataWithBaseURL("file:///android_asset/", przeminaIzohoryczna, "text/html", "UTF-8", null);
            webView9.loadDataWithBaseURL("file:///android_asset/", adiabatycznaWprowadzenie, "text/html", "UTF-8", null);
            webView10.loadDataWithBaseURL("file:///android_asset/", cieploPrzy, "text/html", "UTF-8", null);
            webView11.loadDataWithBaseURL("file:///android_asset/", energiaKinetycznaTermo, "text/html", "UTF-8", null);
            webView12.loadDataWithBaseURL("file:///android_asset/", termoJeden, "text/html", "UTF-8", null);
            webView13.loadDataWithBaseURL("file:///android_asset/", pracaTermo, "text/html", "UTF-8", null);
            webView14.loadDataWithBaseURL("file:///android_asset/", drugaZasada, "text/html", "UTF-8", null);
            webView15.loadDataWithBaseURL("file:///android_asset/", sprawnosc, "text/html", "UTF-8", null);
            webView16.loadDataWithBaseURL("file:///android_asset/", entropia, "text/html", "UTF-8", null);


            materialDesignFAM.setVisibility(View.VISIBLE);
            menu.setTitle(R.string.termodynamika);


        } else if (id == R.id.grawitacja) {
            scrollView.fullScroll(ScrollView.FOCUS_UP);


            sprawdzenieMat = 6;
            sprawdzenie = 6;


            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.VISIBLE);
            card3.setVisibility(View.VISIBLE);
            card4.setVisibility(View.VISIBLE);
            card5.setVisibility(View.VISIBLE);
            card6.setVisibility(View.VISIBLE);
            card7.setVisibility(View.VISIBLE);
            card8.setVisibility(View.VISIBLE);
            card9.setVisibility(View.VISIBLE);
            card10.setVisibility(View.VISIBLE);
            card11.setVisibility(View.VISIBLE);
            card12.setVisibility(View.VISIBLE);
            card13.setVisibility(View.VISIBLE);
            card14.setVisibility(View.GONE);
            card15.setVisibility(View.GONE);
            card16.setVisibility(View.GONE);


            textView11.setVisibility(View.VISIBLE);
            textView12.setVisibility(View.VISIBLE);
            textView13.setVisibility(View.VISIBLE);
            textView14.setVisibility(View.VISIBLE);
            textView15.setVisibility(View.VISIBLE);
            textView16.setVisibility(View.VISIBLE);
            textView17.setVisibility(View.VISIBLE);
            textView18.setVisibility(View.VISIBLE);
            textView19.setVisibility(View.VISIBLE);
            textView20.setVisibility(View.VISIBLE);
            textView21.setVisibility(View.VISIBLE);
            textView22.setVisibility(View.VISIBLE);
            textView23.setVisibility(View.VISIBLE);
            textView24.setVisibility(GONE);
            textView25.setVisibility(GONE);
            textView26.setVisibility(GONE);


            webView1.setVisibility(View.VISIBLE);
            webView2.setVisibility(View.VISIBLE);
            webView3.setVisibility(View.VISIBLE);
            webView4.setVisibility(View.VISIBLE);
            webView5.setVisibility(View.VISIBLE);
            webView6.setVisibility(View.VISIBLE);
            webView7.setVisibility(View.VISIBLE);
            webView8.setVisibility(View.VISIBLE);
            webView9.setVisibility(View.VISIBLE);
            webView10.setVisibility(View.VISIBLE);
            webView11.setVisibility(View.VISIBLE);
            webView12.setVisibility(View.VISIBLE);
            webView13.setVisibility(View.VISIBLE);
            webView14.setVisibility(GONE);
            webView15.setVisibility(GONE);
            webView16.setVisibility(GONE);

            textView11.setText(R.string.pierwsze_prawo_keplera);
            textView12.setText(R.string.drugie_prawo_keplera);
            textView13.setText(R.string.trzecie_prawo_keplera);
            textView14.setText(R.string.prawo_powszechnego_ci_enia);
            textView15.setText(R.string.przy_pieszenie_grawitacyjne);
            textView16.setText(R.string.nat_enie_pola_grawitacyjnego);
            textView17.setText(R.string.energia_potencjalna);
            textView18.setText(R.string.potencja_pola_grawitacyjnego);
            textView19.setText(R.string.praca_w_polu_grawitacyjnym);
            textView20.setText(R.string.pr_dko_ci_kosmiczne);
            textView21.setText(R.string.ca_kowita_energia);
            textView22.setText(R.string.nat_enie_pola_grawitacyjnego_ziemi);
            textView23.setText(R.string.odleglosci);


            String path = "file:///android_asset/";
            String keplerjeden = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'W układzie słonecznym składającym się ze słońca i powiązanych z nim ciał niebieskich znajduje się osiem planet,w kolejności rosnącej odległości od słońca to: Merkury, Wenus, Ziemia, Mars Jowisz, Saturn, Uran, Neptun. Każda planeta Układu Słonecznego porusza się wokół Słońca po orbicie w kształcie elipsy, w której w jednym z ognisk jest Słońce.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String keplerdwa = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '${ΔA}/{Δt}={const}↖{→}$ <br> $ΔA$  pole zakreślone przez wektor położenia planety, $Δt$ zmiana czasu';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String keplertrzy = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$T^2/R^3={const}↖{→}$ <br> $T$ okres obiegu planety, $R$ odległośc od słońca ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String prawoPowszechnegoCiazenia = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$F↖{→}_{M,m}=G{Mm}/r^2$, $G=6,67*10^-11$ $[m^3/{kg*s^2}]$ <br> $F↖{→}_{M,m}$ siła z jaką ciało o masie $M$ działa na ciało o masie $m$, $G$ stała grawitacyjna, $r$ odległość między planetami, $M$ masa pierwszego ciała (np. planety), $m$ masa drugiego ciała (np. satelity) ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String przyspieszenieGrawitacyjne = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$g↖{→}_2=GMm/{Mr}=Gm/r^2$ $[m/s^2]$ <br> $g↖{→}_2$ przyśpieszenie ciała 2 przyciąganego przez ciało pierwsze, $G$ stała grawitacyjna, $M$ masa ciała pierwszego, $m$ masa ciała drugiego, $r$ promień';M.parseMath(s);document.body.style.color = \"white\";document.body.style.backgroundColor = \"black\";document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String natezeniepola = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$γ↖{→}=F_g↖{→}/m=GM/r^2$ $[N/kg]$ <br> $γ↖{→}$ natężenie pola grawitacyjnego, $F_g$ siła grawitacji działająca na masę próbną $m$, $m$ masa próbna, $G$ stała grawitacji, $M$ masa ciała pierwszego $r$ promień ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String energiaPotencjalnaGrawi = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$E_p=-G{Mm}/r$ $[J]$ <br> $E_p$ energia potencjalna, $G$ stała grawitacyjna, $M$ masa pierwszego ciała, $m$ masa drugiego ciała, $r$ odległość między ciałami';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String potencjal = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$V=E_p/m_o=-{GM}/r$ $[J/kg]$ <br> $V$ potencjał pola grawitacyjnego, $G$ stała grawitacyjna, $E_p$ energia potencjalna, $M$ masa pierwszego ciała, $m_0$ masa próbna, $r$ odległość między ciałami ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String pracaGrawi = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$W=∫↖{r_2}↙{r_1}Fdr=GMm(1/r_2-1/r_1)$ $[J]$ <br> $W$ praca, $G$ stała grawitacyjna, $M$ masa pierwszego ciała, $m$ masa drugiego ciała, $r_1$ odległość początkowa, $r_2$ odległość końcowa';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String predkosc = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$v↖{→}_1=√{{GM}/r}$ <br> $v_2↖{→}=√{{2GM}/r}=√2v↖{→}_1$ <br> $v_1↖{→}$ pierwsza prędkośc kosmiczna, $G$ Stała grawitacji, $M$ masa planety, $r$ promień $v↖{→}_2$ druga prędkość kosmiczna';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


            String energiaKinetycznaGrawi = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = ' $E_k=-1/2{E_p}=GMm/{2r}$ <br> $E_c=-E_k=1/2{e_p}=-GMm/{2r}$ <br> $E_k$ energia kinetyczna, $E_c$ energia całkowita, $G$ stała grawitacyjna, $M$ masa planety (pierwszego ciała), $m$ masa drugiego ciała $R$ promień';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String natKuli = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$γ↖{→}={GM}/R^3*r$, dla $R>r$, $γ↖{→}={GM}/r^2$, dla $r>>R$, $γ↖{→}$ natężenie, $G$ stała grawitacyjna, $M$ masa ziemi , $R$ promien ziemi, $r$ promien ciała oddalnego od środka ziemi';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String odleglosci = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s =  'Jedna jednostka astronomiczna oznaczana $au$ to średnia odległość Ziemi od Słońca, w przybliżeniu $1,5*10^11 m$. Jeden rok świetlny to odległość jaką światło o prędkosći $c=3*10^8[m/s]$ przebyłoby w ciagu roku. Rok świetlny w przybliżeniu to $9.46*10^{15}m$. Parsek to odległość, dla której paralaksa roczna położenia Ziemi widzianej prostopadle do płaszczyzny orbity wynosi 1 sekundę łuku, wynosi ok. $3.09*10^{16}m$ ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


            webView1.loadDataWithBaseURL("file:///android_asset/", keplerjeden, "text/html", "UTF-8", null);
            webView2.loadDataWithBaseURL("file:///android_asset/", keplerdwa, "text/html", "UTF-8", null);
            webView3.loadDataWithBaseURL("file:///android_asset/", keplertrzy, "text/html", "UTF-8", null);
            webView4.loadDataWithBaseURL("file:///android_asset/", prawoPowszechnegoCiazenia, "text/html", "UTF-8", null);
            webView5.loadDataWithBaseURL("file:///android_asset/", przyspieszenieGrawitacyjne, "text/html", "UTF-8", null);
            webView6.loadDataWithBaseURL("file:///android_asset/", natezeniepola, "text/html", "UTF-8", null);
            webView7.loadDataWithBaseURL("file:///android_asset/", energiaPotencjalnaGrawi, "text/html", "UTF-8", null);
            webView8.loadDataWithBaseURL("file:///android_asset/", potencjal, "text/html", "UTF-8", null);
            webView9.loadDataWithBaseURL("file:///android_asset/", pracaGrawi, "text/html", "UTF-8", null);
            webView10.loadDataWithBaseURL("file:///android_asset/", predkosc, "text/html", "UTF-8", null);
            webView11.loadDataWithBaseURL("file:///android_asset/", energiaKinetycznaGrawi, "text/html", "UTF-8", null);
            webView12.loadDataWithBaseURL("file:///android_asset/", natKuli, "text/html", "UTF-8", null);
            webView13.loadDataWithBaseURL("file:///android_asset/", odleglosci, "text/html", "UTF-8", null);


            materialDesignFAM.setVisibility(View.VISIBLE);
            menu.setTitle(R.string.grawitacja_i_kosmos);


        } else if (id == R.id.drgajacy) {

            scrollView.fullScroll(ScrollView.FOCUS_UP);


            sprawdzenieMat = 7;
            sprawdzenie = 7;


            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.VISIBLE);
            card3.setVisibility(View.VISIBLE);
            card4.setVisibility(View.VISIBLE);
            card5.setVisibility(View.VISIBLE);
            card6.setVisibility(View.VISIBLE);
            card7.setVisibility(View.VISIBLE);
            card8.setVisibility(View.VISIBLE);
            card9.setVisibility(View.VISIBLE);
            card10.setVisibility(View.GONE);
            card11.setVisibility(View.GONE);
            card12.setVisibility(View.GONE);
            card13.setVisibility(View.GONE);
            card14.setVisibility(View.GONE);
            card15.setVisibility(View.GONE);
            card16.setVisibility(View.GONE);


            textView11.setVisibility(View.VISIBLE);
            textView12.setVisibility(View.VISIBLE);
            textView13.setVisibility(View.VISIBLE);
            textView14.setVisibility(View.VISIBLE);
            textView15.setVisibility(View.VISIBLE);
            textView16.setVisibility(View.VISIBLE);
            textView17.setVisibility(View.VISIBLE);
            textView18.setVisibility(View.VISIBLE);
            textView19.setVisibility(View.VISIBLE);
            textView20.setVisibility(GONE);
            textView21.setVisibility(GONE);
            textView22.setVisibility(GONE);
            textView23.setVisibility(GONE);
            textView24.setVisibility(GONE);
            textView25.setVisibility(GONE);
            textView26.setVisibility(GONE);


            webView1.setVisibility(View.VISIBLE);
            webView2.setVisibility(View.VISIBLE);
            webView3.setVisibility(View.VISIBLE);
            webView4.setVisibility(View.VISIBLE);
            webView5.setVisibility(View.VISIBLE);
            webView6.setVisibility(View.VISIBLE);
            webView7.setVisibility(View.VISIBLE);
            webView8.setVisibility(View.VISIBLE);
            webView9.setVisibility(View.VISIBLE);
            webView10.setVisibility(GONE);
            webView11.setVisibility(GONE);
            webView12.setVisibility(GONE);
            webView13.setVisibility(GONE);
            webView14.setVisibility(GONE);
            webView15.setVisibility(GONE);
            webView16.setVisibility(GONE);


            textView11.setText(R.string.po_o_enie_od_czasu);
            textView12.setText(R.string.pr_dko_od_czasu);
            textView13.setText(R.string.przy_pieszenie_od_czasu);
            textView14.setText(R.string.si_aA);
            textView15.setText(R.string.praca_i_energia);
            textView16.setText(R.string.zale_no_energi_od_czasu);
            textView17.setText(R.string.wahad_o_matematyczne);
            textView18.setText(R.string.wahad_o_fizyczne);
            textView19.setText(R.string.wahadlo_sprez);

            String path = "file:///android_asset/";
            String polozenie = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$x(t)=Asin(ωt+ϕ_o)[m]$, $x_{max}=A$ <br> $x(t)$ położenie od czasu, $A$ amplituda, $ω$ częstość kołowa, $t$ czas, $ϕ_o$ przesunięcie początkowe';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String predkoscodCZasu = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$v↖{→}(t)=ωAcos(ωt+ϕ_o)[m/s]$, $v_{max}= ωA$ <br> $v↖{→}(t)$ prędkość od czasu, $A$ amplituda, $ω$ częstość kołowa, $t$ czas, $ϕ_o$ przesunięcie początkowe';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String przyspieszenieOdT = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$a↖{→}(t)=-ω^2Asin(ωt+ϕ_o)[m/s^2]$, $a_{max}= -ω^2A$ <br> $a↖{→}(t)$ przyśpieszenie od czasu, $A$ amplituda, $ω$ częstość kołowa, $t$ czas, $ϕ_o$ przesunięcie początkowe';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String silasprez = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$F↖{→}_s=-kx[kg*m/s^2=N]$, $F_x↖{→}=kx$, $k=mω^2$ <br> $F↖{→}_s$ siła sprężystości, $F_x$ siła wychylająca $k$ współczynnik sprężystości, $x$ wychylenie z punktu równowagi, $m$ masa, $ω$ częstość kołowa';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String energiaPotSp = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$E_{ps}={kx^2}/2$, $E_c={kA^2}/2$, $E_k=E_c-E_{ps}=k/2(A^2-x^2)$ $[J]$ <br> $E_{ps}$ energia potencjalna sprężystości, $E_k$ energia kinetyczna, $E_c$ energia całkowita, $F↖{→}_x$ siła ciągnąca, $x$ wychylenie, $k$ wsp sprężystośći, $A$ amplituda <br> <br> Praca $W$ to pole figury pod wykresem $F_x(x)$ i $W=E_{ps}[J]$ Energia całkowita nie zależy od wychylenia.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


            String ecalCzas = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$E_{ps}={kx^2}/2={kA}/2sin(ωt+ϕ_o)$ <br> $E_k={mv↖{→}^2}/2={mω^2A^2cos^2(ωt+ϕ_o)}/2={kA^2}/2cos^2(ωt+ϕ_o)$ <br> $E_c={kA^2}/2$ <br> $E_{ps}$ energia potencjalna sprężystości, $E_k$ energia kinetyczna, $E_c$ energia całkowita, $k$ wsp spręzystości, $v↖{→}$ prędkość, $A$ amplituda, $ω$ częstość kołowa, $t$ czas, $ϕ_o$ przesunięcie początkowe, $m$ masa';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String wahtMat = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$T=2π√{l/g↖{→}}$ <br> $T$ okres, $l$ długość linki, $g$ przyśpieszenie grawitacyjne, wzór jest poprawny tylko dla małych wychyleń, ok. 10 stopni.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String wahFiz = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$T=2π√{I/{mg↖{→}d}}$ <br> $T$ okres, $I$ moment bezwładności, $m$ masa $g↖{→}$ przyśpieszenie grawitacyjne, $d$ odległość miedzy środkiem masy a osią obrotu';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String wahSpr = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$T=2π√{m/k}$ <br> $T$ okres, $m$ masa obciążenia, $k$ wsp. sprężystości ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


            webView1.loadDataWithBaseURL("file:///android_asset/", polozenie, "text/html", "UTF-8", null);
            webView2.loadDataWithBaseURL("file:///android_asset/", predkoscodCZasu, "text/html", "UTF-8", null);
            webView3.loadDataWithBaseURL("file:///android_asset/", przyspieszenieOdT, "text/html", "UTF-8", null);
            webView4.loadDataWithBaseURL("file:///android_asset/", silasprez, "text/html", "UTF-8", null);
            webView5.loadDataWithBaseURL("file:///android_asset/", energiaPotSp, "text/html", "UTF-8", null);
            webView6.loadDataWithBaseURL("file:///android_asset/", ecalCzas, "text/html", "UTF-8", null);
            webView7.loadDataWithBaseURL("file:///android_asset/", wahtMat, "text/html", "UTF-8", null);
            webView8.loadDataWithBaseURL("file:///android_asset/", wahFiz, "text/html", "UTF-8", null);
            webView9.loadDataWithBaseURL("file:///android_asset/", wahSpr, "text/html", "UTF-8", null);

            materialDesignFAM.setVisibility(View.VISIBLE);
            menu.setTitle(R.string.ruch_drgaj_cy);


        } else if (id == R.id.mechaniczne) {

            scrollView.fullScroll(ScrollView.FOCUS_UP);


            sprawdzenieMat = 8;
            sprawdzenie = 8;


            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.VISIBLE);
            card3.setVisibility(View.VISIBLE);
            card4.setVisibility(View.VISIBLE);
            card5.setVisibility(View.VISIBLE);
            card6.setVisibility(View.VISIBLE);
            card7.setVisibility(View.VISIBLE);
            card8.setVisibility(View.VISIBLE);
            card9.setVisibility(View.VISIBLE);
            card10.setVisibility(View.VISIBLE);
            card11.setVisibility(View.GONE);
            card12.setVisibility(View.GONE);
            card13.setVisibility(View.GONE);
            card14.setVisibility(View.GONE);
            card15.setVisibility(View.GONE);
            card16.setVisibility(View.GONE);

            textView11.setVisibility(View.VISIBLE);
            textView12.setVisibility(View.VISIBLE);
            textView13.setVisibility(View.VISIBLE);
            textView14.setVisibility(View.VISIBLE);
            textView15.setVisibility(View.VISIBLE);
            textView16.setVisibility(View.VISIBLE);
            textView17.setVisibility(View.VISIBLE);
            textView18.setVisibility(View.VISIBLE);
            textView19.setVisibility(View.VISIBLE);
            textView20.setVisibility(View.VISIBLE);
            textView21.setVisibility(GONE);
            textView22.setVisibility(GONE);
            textView23.setVisibility(GONE);
            textView24.setVisibility(GONE);
            textView25.setVisibility(GONE);
            textView26.setVisibility(GONE);


            webView1.setVisibility(View.VISIBLE);
            webView2.setVisibility(View.VISIBLE);
            webView3.setVisibility(View.VISIBLE);
            webView4.setVisibility(View.VISIBLE);
            webView5.setVisibility(View.VISIBLE);
            webView6.setVisibility(View.VISIBLE);
            webView7.setVisibility(View.VISIBLE);
            webView8.setVisibility(View.VISIBLE);
            webView9.setVisibility(View.VISIBLE);
            webView10.setVisibility(View.VISIBLE);
            webView11.setVisibility(GONE);
            webView12.setVisibility(GONE);
            webView13.setVisibility(GONE);
            webView14.setVisibility(GONE);
            webView15.setVisibility(GONE);
            webView16.setVisibility(GONE);


            textView11.setText(R.string.pr_dko_fali);
            textView12.setText(R.string.r_wnanie_fali);
            textView13.setText(R.string.interferencja_fali);
            textView14.setText(R.string.wypadkowa_amplituda_fali);
            textView15.setText(R.string.maksymalne_wzmocnienie_fali);
            textView16.setText(R.string.maksymalne_wygaszenie_fali);
            textView17.setText(R.string.nat_enie_fal_i);
            textView18.setText(R.string.zjawisko_dopplera);
            textView19.setText(R.string.piszcza_ka_otwarta);
            textView20.setText(R.string.piszcza_ka_otwarta);


            String path = "file:///android_asset/";
            String predkoscFali = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$v↖{→}=λ/T=λf$, $[m/s]$ <br> $v↖{→}$ prędkość, $λ$ długość fali, $T$ okres, $f$ czestotliwość';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String polozenieJeden = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$y(x,t)=Asin[ω(t-x/v)+ϕ_o]$ $[m]$ <br> $y(x,t)=Asin(x/λ-t/T)$ $[m]$ <br> $y(x,t)$ położenie punkt w zależnosci od $x$ i $t$, $A$ amplituda, $λ$ długość fali, $T$ okres, $x$ przesuniecie $λ$ długość fali';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String interferencjaJeden = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$y(x,t)=y_1+y_2$, $y(x,t)=A_1sin[2π(t/T_1-x_1/λ_1)]$ + $A_2sin[2π(t/T_2-x_2/λ_2)]$ <br> $y(x,t)=y_1+y_2$, $y(x,t)=2Acos[π({x_2-x_1}/λ)]$ * $sin[2π(t/T-{x_1+x_2}/{2λ})]$ <br> $y(x,t)$ położenie punkt w zależnosci od $x$ i $t$, $y_1$ funkcja opisująca pierwszą falę, $y_2$ funkcja opisująca drugą falę, $A$ amplituda, $T$ okres, $λ$ długość fali, $λ_1$ długość pierwszej fali, $λ_2$ długość drugiej fali, $x_1$ położenie pierwszego punkut, $x_2$ położenie drugiego punktu';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String wypadkowaA = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$A_w=2Acos[π({x_2-x_1}/λ)]$ <br> $A_w$ wypadkowa amplituda, $λ$ długość fali, $λ$ długość fali, $x_1$ położenie pierwszego punkut, $x_2$ położenie drugiego punktu ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String wygaszenie = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Maksymalne wygaszenie fali wystepuje gdy różnica przebytych dróg jest równa nieparzystej wielokrotnościa połowy długości fali <br>  $Δx=(2n+1)λ/2$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String wzmocnienie = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Maksymalne wzmocnienie fali występuje gdy różnica przebytych dróg jest równa całkowitej wielokrotności długości fali <br> $Δx=nλ$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String natezenie = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$I=E/{st}$ $[J/{m^2*s}=W/m^2]$ <br> $I$ natężenie, $E$ energia, $s$ sfera(powierzchnia), $t$ czas <br> Próg słyszalności $I_0=10^{-12}$ $[W/m^2]$ <br> Czlowiek słyszy dźwieki czyli fale akustyczne z zakresu częstotliwości od $16{Hz}$ do $20 000{Hz}$ <br> Poziom natężenia dźwięku $Λ=10{log}J/J_0 [db]$ ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String doppler = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$f_k=f_o{{v↖{→}+↙{-}v↖{→}_{odp}}/{v↖{→}+↙{-}v↖{→}_{zr}}}$ <br> $f_k$ czestotliwość koncowa, $f$ czestotliwośc początkowa, $v↖{→}$ prędkość dźwieku, $v_{odb}$ prędkość odbiornika, $v_{zr}$ prędkość źródła, $v↖{→}=340$ $m/s$ ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String piszczalkiotwarte = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$f={nv}/{2L}$ $[1/s=Hz]$ <br> Piszczałki otwarte (od strzałki do strzałki), $f$ częstotliwość, $n$ liczba naturalna, $v$ prędkość dźwieku, $L$ długość piszczałki';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String pisczalkiZamkniete = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>" + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$f=(2n-1)v/{4L}$ $[1/s=Hz]$ <br> Piszczałka zamknięta (od strzałki do węzła), $f$ częstotliwość, $n$ liczba naturalna, $v$ prędkość dźwieku, $L$ długość piszczałki ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            webView1.loadDataWithBaseURL("file:///android_asset/", predkoscFali, "text/html", "UTF-8", null);
            webView2.loadDataWithBaseURL("file:///android_asset/", polozenieJeden, "text/html", "UTF-8", null);
            webView3.loadDataWithBaseURL("file:///android_asset/", interferencjaJeden, "text/html", "UTF-8", null);
            webView4.loadDataWithBaseURL("file:///android_asset/", wypadkowaA, "text/html", "UTF-8", null);
            webView5.loadDataWithBaseURL("file:///android_asset/", wzmocnienie, "text/html", "UTF-8", null);
            webView6.loadDataWithBaseURL("file:///android_asset/", wygaszenie, "text/html", "UTF-8", null);
            webView7.loadDataWithBaseURL("file:///android_asset/", natezenie, "text/html", "UTF-8", null);
            webView8.loadDataWithBaseURL("file:///android_asset/", doppler, "text/html", "UTF-8", null);
            webView9.loadDataWithBaseURL("file:///android_asset/", piszczalkiotwarte, "text/html", "UTF-8", null);
            webView10.loadDataWithBaseURL("file:///android_asset/", pisczalkiZamkniete, "text/html", "UTF-8", null);

            materialDesignFAM.setVisibility(View.VISIBLE);
            menu.setTitle(R.string.fale_mechaniczne);

        } else if (id == R.id.Elektorstatyka) {

            scrollView.fullScroll(ScrollView.FOCUS_UP);
            sprawdzenieMat = 9;
            sprawdzenie = 9;


            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.VISIBLE);
            card3.setVisibility(View.VISIBLE);
            card4.setVisibility(View.VISIBLE);
            card5.setVisibility(View.VISIBLE);
            card6.setVisibility(View.VISIBLE);
            card7.setVisibility(View.VISIBLE);
            card8.setVisibility(View.VISIBLE);
            card9.setVisibility(View.VISIBLE);
            card10.setVisibility(View.VISIBLE);
            card11.setVisibility(View.VISIBLE);
            card12.setVisibility(View.GONE);
            card13.setVisibility(View.GONE);
            card14.setVisibility(View.GONE);
            card15.setVisibility(View.GONE);
            card16.setVisibility(View.GONE);

            textView11.setVisibility(View.VISIBLE);
            textView12.setVisibility(View.VISIBLE);
            textView13.setVisibility(View.VISIBLE);
            textView14.setVisibility(View.VISIBLE);
            textView15.setVisibility(View.VISIBLE);
            textView16.setVisibility(View.VISIBLE);
            textView17.setVisibility(View.VISIBLE);
            textView18.setVisibility(View.VISIBLE);
            textView19.setVisibility(View.VISIBLE);
            textView20.setVisibility(View.VISIBLE);
            textView21.setVisibility(View.VISIBLE);
            textView22.setVisibility(GONE);
            textView23.setVisibility(GONE);
            textView24.setVisibility(GONE);
            textView25.setVisibility(GONE);
            textView26.setVisibility(GONE);


            webView1.setVisibility(View.VISIBLE);
            webView2.setVisibility(View.VISIBLE);
            webView3.setVisibility(View.VISIBLE);
            webView4.setVisibility(View.VISIBLE);
            webView5.setVisibility(View.VISIBLE);
            webView6.setVisibility(View.VISIBLE);
            webView7.setVisibility(View.VISIBLE);
            webView8.setVisibility(View.VISIBLE);
            webView9.setVisibility(View.VISIBLE);
            webView10.setVisibility(View.VISIBLE);
            webView11.setVisibility(View.VISIBLE);
            webView12.setVisibility(GONE);
            webView13.setVisibility(GONE);
            webView14.setVisibility(GONE);
            webView15.setVisibility(GONE);
            webView16.setVisibility(GONE);


            textView11.setText(R.string.adunek_cz_stek);
            textView12.setText(R.string.si_a_elektrostatyczna);
            textView13.setText(R.string.energia_potencjalna_pola_elektrostatycznego);
            textView14.setText(R.string.potencja_pola_elektrostatycznego);
            textView15.setText(R.string.nat_enie_pola_elektrostatycznego);
            textView16.setText(R.string.praca_w_polu_elekstrostatycznym);
            textView17.setText(R.string.pojemno_kondensatora);
            textView18.setText(R.string.po_czenie_szeregowe_kondensator_w);
            textView19.setText(R.string.po_czenie_r_wnoleg_e_kondensator_w);
            textView20.setText(R.string.praca_w_kondensatorach);
            textView21.setText(R.string.nat_zenie_pola_elektrostatycznego_kuli);


            String path = "file:///android_asset/";
            String ladunekJeden = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$1e=-1,6*10^{-19}C$ <br> $1p=1,6*10^{-19}C$, $C$ kulomb, <br> $1N=1,6*10^{-27}C$, <br> $C$ Kulomb, $e$ elektron, $p$ proton, $N$ neutron <br> $q=ne$ $[C]$, $q$ ładunek, $n$ ilość cząstek elementarnych, $e$ cząstka elementarna (proton, elektron lub neutron)';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String silaelektro = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$F↖{→}_{qQ}=k{{qQ}/r^2}[N]$ <br> $k=1/{4πε}[{N*m^2}/C^2]$, $ε=ε_rε_0$ <br> $F↖{→}_{qQ}$ siła z jaką ładunek $q$ i $Q$ oddziałwywują na siebie, $r$ odległość między ładunkami, $k$ stała elektrostatyczna $ε$ względna przenikalność elektryczna, $ε_0$ wzg. przenikalność próżni, $ε_r$ skala przenialność ośrodka wzgledem próżni <br><br> W polu jednorodnym lecąca przez nie cząstka zachowuje się jak ciało podczas rzutu poziomego.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String natezPolaElektro = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$E↖{→}=F↖{→}/q_0=kQ/r^2$ $[N/C]$ <br> $E↖{→}$ natężenie pola elektrostatycznego, $Q$ ładunek ciała, $r$ promień, $q_0$ ładunek próbny <br> W polu jednorodnym $E↖{→}=U/d$ <br> W polu centralnym $E↖{→}=V/r$ <br> $E↖{→}$ natężenie, $U$ napięcie, $d$ odległość między okładkami, $V$ potencjał, $r$ promień';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String energiaPoteElek = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$E_p=k{Qq}/r$ $[J]$ <br> $E_p$ energia potencjalna, $k$ stała elektrostatyczna, $Q$ ładunek ciała pierwszego, $q$ ładunek ciała drugiego, $r$ promień';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String potencjalElektryczny = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$V=E_p/q_0=kQ/r$ $[J/C=V]$ <br> $U=ΔV[V]$, $V$ wolt <br> $v$ potencjał pola elektrostatycznego,$U$ napięcie, $k$ stała elektrostatyczna, $Q$ ładunek ciała pierwszego, $q$ ładunek ciała drugiego, $r$ promień';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String pracaJeden = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Praca to $W=ΔE_p[J]$, lub $W=qΔV=qU$ $[J]$, $W=kQq(1/r_2-1/r_1)$ <br> $W$ praca, $E_p$ różnica energii potencjalnych,$Q$ ładunek pierwszy $q$ ładunek drugi, $ΔV$ różnica potencjałów, $k$ stała elektrostatyczna, $r_1$ promien pierwszy, $r_2$ promień drugi';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String pojemnoscKon = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$C=Q/{ΔV}$, $C=Q/U$ $[C/V=F]$, $F$ farad <br> $C$ pojemność, $Q$ ładunek, $ΔV$ różnica potencjałów <br> Dla kondensatora płaskiego $C=ε_0*ε_rs/d$ $[F]$, $ε_0= 8,841941283·10^{-12} F/m$ <br> $C$ pojemność, $ε_r$ stała dielektryczna substancji między okładkami kondensatora $ε_0$ stała dielektryczna próżni, powierzchnia czynna podkładek/wspólna część powierzchni, $d$ odległość między okłądkami';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String polaczenieRownolegle = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$U={const}$ <br> $Q_c=Q_1+{Q_2}...+{Q_n}$ <br> $C_c=C_1+{C_2}...{C_n}$, gdzie $U$ napięcie, $Q_c$ ładunek całkowity, $C_c$ pojemność całkowita';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String polaczenieSzeregowe = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$Q={const}$ <br> $U_c=U_1+{U_2}....{U_n}$ <br> $1/C_c=1/C_1+{1/C_2}....+{1/C_n}$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String pracaKondensatory = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$W={QU}/2=Q^2/{2C}={CU^2}/2$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String natKuli = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$E↖{→}={kQ}/R^3*r$ dla $R>r$ <br> $E↖{→}={kQ}/r^2$ dla $r>>R$, $E↖{→}$ <br> natężenie, $k$ stała elektrostatyczna, $Q$ ładunek , $R$ promien kuli, $r$ promien ciała oddalnego od środka kuli ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            webView1.loadDataWithBaseURL("file:///android_asset/", ladunekJeden, "text/html", "UTF-8", null);
            webView2.loadDataWithBaseURL("file:///android_asset/", silaelektro, "text/html", "UTF-8", null);
            webView3.loadDataWithBaseURL("file:///android_asset/", energiaPoteElek, "text/html", "UTF-8", null);
            webView4.loadDataWithBaseURL("file:///android_asset/", potencjalElektryczny, "text/html", "UTF-8", null);
            webView5.loadDataWithBaseURL("file:///android_asset/", natezPolaElektro, "text/html", "UTF-8", null);
            webView6.loadDataWithBaseURL("file:///android_asset/", pracaJeden, "text/html", "UTF-8", null);
            webView7.loadDataWithBaseURL("file:///android_asset/", pojemnoscKon, "text/html", "UTF-8", null);
            webView8.loadDataWithBaseURL("file:///android_asset/", polaczenieSzeregowe, "text/html", "UTF-8", null);
            webView9.loadDataWithBaseURL("file:///android_asset/", polaczenieRownolegle, "text/html", "UTF-8", null);
            webView10.loadDataWithBaseURL("file:///android_asset/", pracaKondensatory, "text/html", "UTF-8", null);
            webView11.loadDataWithBaseURL("file:///android_asset/", natKuli, "text/html", "UTF-8", null);

            materialDesignFAM.setVisibility(View.VISIBLE);
            menu.setTitle(R.string.elektrostatyka);


        } else if (id == R.id.pradstatly) {

            scrollView.fullScroll(ScrollView.FOCUS_UP);

            sprawdzenieMat = 10;
            sprawdzenie = 10;

            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.VISIBLE);
            card3.setVisibility(View.VISIBLE);
            card4.setVisibility(View.VISIBLE);
            card5.setVisibility(View.VISIBLE);
            card6.setVisibility(View.VISIBLE);
            card7.setVisibility(View.VISIBLE);
            card8.setVisibility(View.VISIBLE);
            card9.setVisibility(View.VISIBLE);
            card10.setVisibility(View.VISIBLE);
            card11.setVisibility(View.VISIBLE);
            card12.setVisibility(View.VISIBLE);
            card13.setVisibility(View.VISIBLE);
            card14.setVisibility(View.GONE);
            card15.setVisibility(View.GONE);
            card16.setVisibility(View.GONE);

            textView11.setVisibility(View.VISIBLE);
            textView12.setVisibility(View.VISIBLE);
            textView13.setVisibility(View.VISIBLE);
            textView14.setVisibility(View.VISIBLE);
            textView15.setVisibility(View.VISIBLE);
            textView16.setVisibility(View.VISIBLE);
            textView17.setVisibility(View.VISIBLE);
            textView18.setVisibility(View.VISIBLE);
            textView19.setVisibility(View.VISIBLE);
            textView20.setVisibility(View.VISIBLE);
            textView21.setVisibility(View.VISIBLE);
            textView22.setVisibility(View.VISIBLE);
            textView23.setVisibility(View.VISIBLE);
            textView24.setVisibility(View.GONE);
            textView25.setVisibility(View.GONE);
            textView26.setVisibility(View.GONE);


            webView1.setVisibility(View.VISIBLE);
            webView2.setVisibility(View.VISIBLE);
            webView3.setVisibility(View.VISIBLE);
            webView4.setVisibility(View.VISIBLE);
            webView5.setVisibility(View.VISIBLE);
            webView6.setVisibility(View.VISIBLE);
            webView7.setVisibility(View.VISIBLE);
            webView8.setVisibility(View.VISIBLE);
            webView9.setVisibility(View.VISIBLE);
            webView10.setVisibility(View.VISIBLE);
            webView11.setVisibility(View.VISIBLE);
            webView12.setVisibility(View.VISIBLE);
            webView13.setVisibility(View.VISIBLE);
            webView14.setVisibility(View.GONE);
            webView15.setVisibility(GONE);
            webView16.setVisibility(GONE);


            textView11.setText(R.string.nat_enie_pr_du);
            textView12.setText(R.string.g_sto_pr_du_i_pr_dko_unoszenia_adunku);
            textView13.setText(R.string.op_r_elektryczny_i_op_r_w_a_ciwy);
            textView14.setText(R.string.prawo_ohma);
            textView15.setText(R.string.po_czenie_r_wnoleg_e_opornik_w);
            textView16.setText(R.string.po_czenie_szeregowe_opornik_w);
            textView17.setText(R.string.praca);
            textView18.setText(R.string.moc);
            textView19.setText(R.string.prawo_ohma_dla_obowdu_zamkni_tego);
            textView20.setText(R.string.si_a_elektromotoryczna);
            textView21.setText(R.string.pierwsze_prawo_kirchoffa);
            textView22.setText(R.string.drugie_prawo_kirchoffa);
            textView23.setText(R.string.pr_d_zwarcia_i_moc_obwodu);


            String path = "file:///android_asset/";
            String natezenie = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$I={Δq}/{Δt}[C/s=A]$ <br> $I$ natężenie, $Δq$ zmiana ładunki, $Δt$ zmiana czasu, $C$ kulomb, $s$ sekunda, $A$ amper';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String gestoscPraduPred = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$j=l/s[A/m^2]$, $v=j/{ne}[m/s]$ <br> $j$ gęstość prądu, $l$ długość przewodnika, $s$ pole przekroju przewodnika, $n$ liczba przenoszonych czastek, $e$ ładunek elementarny';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String opor = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$R=U/I={ρl}/s$ [V/A=Ω] <br> $ρ={Rs}/l$ <br> $R$ opór, $U$ napięcie, czyli różnica potencjałów, $I$ natężenie prądu, $Ω$ Ohm, jednostka oporu, $s$ pole przekroju przewodnika, $l$ długość przewodnika $ρ$ opór właściwy ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String prawoOhma = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Natężenie przyłożonego prądu jest wprost proporcjonale do przyłożonego napięcia $I∼U$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String polaczenieRownolegleOpr = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = ' $U={const}$ <br> $I_c=I_1+{I_2}....{I_n}$ <br> $1/R_c=1/R_1+{1/R_2}.....{1/R_n}$ <br> $U$ napięcie, $R_c$ opór całkowity, $I_c$ natężenie całkowite, $I_1,I_2...I_n$ natężenia na kolejnych opornikach w obwodzie $R_1,R_2...R_n$ opory kolejnych oporników należących do obwodu';M.parseMath(s);document.body.style.color = \"black\";document.body.style.fontSize = \"13pt\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String polaczenieSzerOpr = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$I={const}$ <br> $U_c=U_1+{U_2}+....{U_n}$ <br> $R_c=R_1+{R_2}....{R_n}$ <br> $I$ natężenie, $U_c$ napięcie całkowite, $U_1,U_2,U_c$ napięcie na kolejnych opornikach obwodu, $R_c$ opór całkowity, $R_1,R_2...R_n$, opory na kolejnych opornika obwodu';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String pracaPrad = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$W=UIt=I^2Rt=U^2/Rt=QU[J]$ <br> $W$ praca, $U$ napięcie, $I$ natężenie, $t$ czas, $R$ opór, $Q$ łądunek';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String mocPrad = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$P=UI=I^2R=U^2/R[V*A=W]$, $1{kWh}=3,6{MJ}$ <br> $P$ moc, $U$ napięcie, $I$ natężenie, $R$ opór $W$ watt, jednostka mocy, ${kWh}$ kilowatogodzina';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String prawoOhmaZam = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$I=ε/{(R+r)}[A]$ <br> $ε=I(R+r)=U+Ir[V]$ <br> $ε$ siła elektromotoryczna SEM, $I$ natężenie prądu w obwodzie, $R$ opór zewnętrzny, $r$ opór wewnętrzny, $U$ napięcie';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.write(s);</script></body>";

            String PierwszeprawoKirchoffa = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Suma natężen wpływających do węzła jest równa sumie natężeń z niego wypływających. <br> $I_1+I_2=I_3+I_4$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String DrugiePrawoKirchoffa = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'W każdym zamkniętym oczku obwodu suma spadków napięć na odbiornikach energii (wraz z oporami wewnętrznymi) jest równa sumie sił elektromotorycznych.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String silaElektromotoryczna = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$ε={ΔW}/{Δq}[V]$, $ε$ siła elektromotoryczna SEM, $ΔW$ zmiana pracy, $Δq$ zmiana ładunku';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String mocobwod = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Maksymalna moc na obwodzie wydziela się kiedy opór zewnętrzny jest równy oporowi wewnętrznemu. Praca w zamkniętej pętli jest równa zero. Gdy nie ma różnicy potencjałów prąd nie płynie. Jeżeli prąd może przepłynąć drogą bez oporu to występuje prąd zwarcia.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            webView1.loadDataWithBaseURL("file:///android_asset/", natezenie, "text/html", "UTF-8", null);
            webView2.loadDataWithBaseURL("file:///android_asset/", gestoscPraduPred, "text/html", "UTF-8", null);
            webView3.loadDataWithBaseURL("file:///android_asset/", opor, "text/html", "UTF-8", null);
            webView4.loadDataWithBaseURL("file:///android_asset/", prawoOhma, "text/html", "UTF-8", null);
            webView5.loadDataWithBaseURL("file:///android_asset/", polaczenieRownolegleOpr, "text/html", "UTF-8", null);
            webView6.loadDataWithBaseURL("file:///android_asset/", polaczenieSzerOpr, "text/html", "UTF-8", null);
            webView7.loadDataWithBaseURL("file:///android_asset/", pracaPrad, "text/html", "UTF-8", null);
            webView8.loadDataWithBaseURL("file:///android_asset/", mocPrad, "text/html", "UTF-8", null);
            webView9.loadDataWithBaseURL("file:///android_asset/", prawoOhmaZam, "text/html", "UTF-8", null);
            webView10.loadDataWithBaseURL("file:///android_asset/", silaElektromotoryczna, "text/html", "UTF-8", null);
            webView11.loadDataWithBaseURL("file:///android_asset/", PierwszeprawoKirchoffa, "text/html", "UTF-8", null);
            webView12.loadDataWithBaseURL("file:///android_asset/", DrugiePrawoKirchoffa, "text/html", "UTF-8", null);
            webView13.loadDataWithBaseURL("file:///android_asset/", mocobwod, "text/html", "UTF-8", null);


            materialDesignFAM.setVisibility(View.VISIBLE);
            menu.setTitle(R.string.pr_d_sta_y);

        } else if (id == R.id.magnetyzm) {

            scrollView.fullScroll(ScrollView.FOCUS_UP);

            sprawdzenieMat = 11;
            sprawdzenie = 11;


            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.VISIBLE);
            card3.setVisibility(View.VISIBLE);
            card4.setVisibility(View.VISIBLE);
            card5.setVisibility(View.VISIBLE);
            card6.setVisibility(View.VISIBLE);
            card7.setVisibility(View.VISIBLE);
            card8.setVisibility(View.VISIBLE);
            card9.setVisibility(View.VISIBLE);
            card10.setVisibility(View.VISIBLE);
            card11.setVisibility(View.GONE);
            card12.setVisibility(View.GONE);
            card13.setVisibility(View.GONE);
            card14.setVisibility(View.GONE);
            card15.setVisibility(View.GONE);
            card16.setVisibility(View.GONE);

            textView11.setVisibility(View.VISIBLE);
            textView12.setVisibility(View.VISIBLE);
            textView13.setVisibility(View.VISIBLE);
            textView14.setVisibility(View.VISIBLE);
            textView15.setVisibility(View.VISIBLE);
            textView16.setVisibility(View.VISIBLE);
            textView17.setVisibility(View.VISIBLE);
            textView18.setVisibility(View.VISIBLE);
            textView19.setVisibility(View.VISIBLE);
            textView20.setVisibility(View.VISIBLE);
            textView21.setVisibility(GONE);
            textView22.setVisibility(GONE);
            textView23.setVisibility(GONE);
            textView24.setVisibility(GONE);
            textView25.setVisibility(GONE);
            textView26.setVisibility(GONE);


            webView1.setVisibility(View.VISIBLE);
            webView2.setVisibility(View.VISIBLE);
            webView3.setVisibility(View.VISIBLE);
            webView4.setVisibility(View.VISIBLE);
            webView5.setVisibility(View.VISIBLE);
            webView6.setVisibility(View.VISIBLE);
            webView7.setVisibility(View.VISIBLE);
            webView8.setVisibility(View.VISIBLE);
            webView9.setVisibility(View.VISIBLE);
            webView10.setVisibility(View.VISIBLE);
            webView11.setVisibility(GONE);
            webView12.setVisibility(GONE);
            webView13.setVisibility(GONE);
            webView14.setVisibility(GONE);
            webView15.setVisibility(GONE);
            webView16.setVisibility(GONE);


            textView11.setText(R.string.wekTorMag);
            textView12.setText(R.string.indukcja_magnetyczna_wybranych_przewodnik_w);
            textView13.setText(R.string.wektor_nat_enia_pola_magnetycznego);
            textView14.setText(R.string.si_a_elektrodynamiczna);
            textView15.setText(R.string.si_a_lorentza);
            textView16.setText(R.string.zwi_zek_mi_dzy_si_a_do_rodkow_a_lorentza);
            textView17.setText(R.string.zwi_zek_miedzy_prac_a_energi_kinetyczn);
            textView18.setText(R.string.regu_a_lewej_d_oni);
            textView19.setText(R.string.dodatkowe_informacje);
            textView21.setText(R.string.wzgl_dna_przenikalno_c_magnetyczna);


            String path = "file:///android_asset/";
            String indukcjaMag = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$B↖{→}=F↖{→}_{⊥}/{qv}=F↖{→}_{⊥}/Il$ $[N/{C{m/s}}={{Wb}/m^2}=T]$ <br> $B↖{→}$ indukcja magnetyczna, $I$ natężenie, $l$ długość, $F↖{→}_⊥$ prostopadła siła Lorentza działajaca na łądunek,  $q$ ładunek $v↖{→}$ prędkość, ${Wb}$ Weber, $T$ tesla';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String indukcjaPrzyklady = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Pole cewki cewki $B↖{→}=μ_0μ_r{nI}/l$, Pole przewodnika prosoliniowego $B↖{→}=μ_0μ_r{I}/2πr$, Pole pętli (w jej środku) $B↖{→}=μ_0μ_r{I}/2r$ <br> $B↖{→}$ indukcja magnetyczna, $n$ liczba zwojów, $μ_0$ przenikalność magnetyczna próżni, $μ_r$ względna przenikalność magnetyczna, $I$ natężenie prądu $l$ długośc cewki, $r$ promień przewodnika';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String natezPolaMag = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$H↖{→}=B↖{→}/{μ_0μ_r}$, $[{{Wb}/m^2}=T]$, $H↖{→}$ wektor natężenia pola magentycznego <br> Dla cewki $H↖{→}={nI}/l$, Dla przewodnika prostoliniowego $H↖{→}=I/2πr$, Dla pętli w jej środku $H↖{→}={I}/2r$ <br> $H↖{→}$, $I$ natężenie prąu, $l$ długośc cewki, $r$ promień przewodnika';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String SiłaElektromotoryczna = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$F↖{→}={Il}↖{→}×B↖{→}$, $F↖{→}=BIl{sinα}$ <br> $F↖{→}$ siła elektrodynamiczna działajaca na przewodnik, $I$ natężenie, $l$ długość przewodnika, $B↖{→}$ indukcja magentyczna, $sinα$ kat zawarty między wektorami iloczynu natęzenia i długośi przewodnika, a indukcji magnetycznej';M.parseMath(s);document.body.style.color = \"black\";document.body.style.fontSize = \"13pt\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


            String silaLorentza1 = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$F↖{→}=B{Il}{sinα}=B{q/t}l{sinα}=qvB{sinα}$ <br> $F↖{→}_{max}=B↖{→}_{⊥}{Il}↖{→}=B↖{→}_{⊥}{q/t}l=qvB_{⊥}$ <br> $F↖{→}$ siła Lorentza działająca na cząstkę w polu magnetycznym, $⊥$ symbol prostopadłości, $B↖{→}$ wektor indukcji magnetycznej, $q$ ładunek, $I$ natężenie, $l$ odcinek jaki przebędzie ładunek, $t$ czas <br> $F↖{→}_{max}=B_{⊥}{Il}=B↖{→}_{⊥}{q/t}l=qvB_{⊥}$ <br> Siła Lorentza nie wpływa na prędkość cząstki, działą ona na określony ładunek elektryczny, gdy $q>0$ to zwrot wyzanaczamy za pomocą reguły lewej dłoni, a gdy $0>q$ tak samo, ale siła ma przeciwny zwrot.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String zwiazekJeden = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Na cząstkę poruszającą się w polu magnetycznym działa siła Lorentza, która zakrzywia jej tor ruchu i jest równa sile dośrodkowej. ${m{v}^2}/r=qvB_{⊥}$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String zwiazekDwa = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Praca wykonana nad czastka poruszającą sie w polu magnetycznym jest równa zmianie energi kinetycznej tej cząstki, praca w polu magnetycznym jest opisywana jest jak w polu elektrostaycznym. $qU={m{v↖{→}}^2}$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String lewaDlon = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Kierunek i zwrot wektora siły elektrodynamicznej, czy zwortu prędkości ładunku (pod wpływem siły Lorentza) wyznacza reguła lewej ręki, jeżeli linie pola magnetycznego wbijają się w wewnętrzną stronę lewej dłoni, a 4 proste palce wskazują kierunek przepływu prądu, to odchylony kciuk wskazuje maksymalną wartość siły.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String zasadaTrzy = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Jeżeli pole magnetyczne jest stałe w czasie to nazywamy je polem magnetostatycznym, całkowity strumień magnetyczny przenikający przez dowolną powierzchnię zamkniętą jest równy zeru.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.write(s);</script></body>";
            String przenikalnoscMagnetyczna = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Względna przenikalność magnetyczna $μ_r$ czyli stosunek $B$ indukowanego (namagnesowania) do $B_0$ czyli wielkości pola magnesującego $μ_r=B/B_0$ <br> Względna przenikalność magnetyczna dla ferromagnetyków $μ_r>>1$, dla paragamentyków $μ_r>1$, dla diamagnetyków $μ_r<1$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.write(s);</script></body>";


            webView1.loadDataWithBaseURL("file:///android_asset/", indukcjaMag, "text/html", "UTF-8", null);
            webView2.loadDataWithBaseURL("file:///android_asset/", indukcjaPrzyklady, "text/html", "UTF-8", null);
            webView3.loadDataWithBaseURL("file:///android_asset/", natezPolaMag, "text/html", "UTF-8", null);
            webView4.loadDataWithBaseURL("file:///android_asset/", SiłaElektromotoryczna, "text/html", "UTF-8", null);
            webView5.loadDataWithBaseURL("file:///android_asset/", silaLorentza1, "text/html", "UTF-8", null);
            webView6.loadDataWithBaseURL("file:///android_asset/", zwiazekJeden, "text/html", "UTF-8", null);
            webView7.loadDataWithBaseURL("file:///android_asset/", zwiazekDwa, "text/html", "UTF-8", null);
            webView8.loadDataWithBaseURL("file:///android_asset/", lewaDlon, "text/html", "UTF-8", null);
            webView9.loadDataWithBaseURL("file:///android_asset/", zasadaTrzy, "text/html", "UTF-8", null);
            webView10.loadDataWithBaseURL("file:///android_asset/", przenikalnoscMagnetyczna, "text/html", "UTF-8", null);


            materialDesignFAM.setVisibility(View.VISIBLE);
            menu.setTitle(R.string.magnetyzm);


        } else if (id == R.id.IndukcjaElektro) {

            scrollView.fullScroll(ScrollView.FOCUS_UP);


            sprawdzenieMat = 12;
            sprawdzenie = 12;


            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.VISIBLE);
            card3.setVisibility(View.VISIBLE);
            card4.setVisibility(View.VISIBLE);
            card5.setVisibility(View.VISIBLE);
            card6.setVisibility(View.VISIBLE);
            card7.setVisibility(View.VISIBLE);
            card8.setVisibility(View.VISIBLE);
            card9.setVisibility(View.VISIBLE);
            card10.setVisibility(View.GONE);
            card11.setVisibility(View.GONE);
            card12.setVisibility(View.GONE);
            card13.setVisibility(View.GONE);
            card14.setVisibility(View.GONE);
            card15.setVisibility(View.GONE);
            card16.setVisibility(View.GONE);

            textView11.setVisibility(View.VISIBLE);
            textView12.setVisibility(View.VISIBLE);
            textView13.setVisibility(View.VISIBLE);
            textView14.setVisibility(View.VISIBLE);
            textView15.setVisibility(View.VISIBLE);
            textView16.setVisibility(View.VISIBLE);
            textView17.setVisibility(View.VISIBLE);
            textView18.setVisibility(View.VISIBLE);
            textView19.setVisibility(View.VISIBLE);
            textView20.setVisibility(GONE);
            textView21.setVisibility(GONE);
            textView22.setVisibility(GONE);
            textView23.setVisibility(GONE);
            textView24.setVisibility(GONE);
            textView25.setVisibility(GONE);
            textView26.setVisibility(GONE);


            webView1.setVisibility(View.VISIBLE);
            webView2.setVisibility(View.VISIBLE);
            webView3.setVisibility(View.VISIBLE);
            webView4.setVisibility(View.VISIBLE);
            webView5.setVisibility(View.VISIBLE);
            webView6.setVisibility(View.VISIBLE);
            webView7.setVisibility(View.VISIBLE);
            webView8.setVisibility(View.VISIBLE);
            webView9.setVisibility(View.VISIBLE);
            webView10.setVisibility(GONE);
            webView11.setVisibility(GONE);
            webView12.setVisibility(GONE);
            webView13.setVisibility(GONE);
            webView14.setVisibility(GONE);
            webView15.setVisibility(GONE);
            webView16.setVisibility(GONE);


            textView11.setText(R.string.wektor_powierzchni_powierzchniowy);
            textView12.setText(R.string.strumie_indukcji_elektromagnetycznej);
            textView13.setText(R.string.indukowana_si_a_elektromotoryczna);
            textView14.setText(R.string.regu_a_przekory);
            textView15.setText(R.string.przewodnik_w_polu_jednorodnym);
            textView16.setText(R.string.praca_w_uk_adzie);
            textView17.setText(R.string.indukcyjno_i_energia_pola_magnetycznego);
            textView18.setText(R.string.samoindukcja);
            textView19.setText(R.string.indukcja_wzajemna);


            String path = "file:///android_asset/";
            String wektorPowierzchni = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Wektor powierzchni/powierzchniowy to peseudowektor, którego wartość jest równa polu powierzchni wybranej figury, jest prostopadły do tej figury.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String strumien = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$ϕ=B↖{→}◦S↖{→}=BScosα=LI$$[T*m^2={Wb}]$ <br> $ϕ$ strumień indukcji elektromagnetycznej, $L$ indukcyjność, $I$ natężenie, $B↖{→}$ wektor indukcji magnetycznej, $S↖{→}$ wektor powierzchniowy, $cosα$ cosinus kąta zawartego miedzy wektorem indkucji magnetycznej a powierzchniowym, $Wb$ weber';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String silaIndukcji = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$ε_{ind}=-{Δϕ}/{Δt}$$[Wb/s=V]$ <br> $ε_{ind}$ indukowana siła elektromotoryczna, $Δϕ$ ZMIANA strumienia indukcji, $Δt$ czas, $V$ wolt';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String regulaPrzekory = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Kierunek prądu indukcyjnego wzynaczamy na podstawie reguły Lenza, która mówi, że prąd indukcyjny ma taki kierunek, że jego własne pole magnetyczne przeciwdziała zmianie strumienia (przyczynie, która ten prąd wywołała).';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String przewodnikWprowadzenie = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Dla przewodnika (np. pręta) o koncach oddalonych od siebie o $l$ poruszajacego się z prędkością $v$ w jdnorodnym polu magnetycznym: <br> $U=Bvlsinα$ $[V]$, $ε=-BLvsinα$ <br> $U$ napięcie, $B↖{→}$ wektor indukcji magnetycznej, $v↖{→}$ prędkość $l$ długość, $ε$ siła elektromotoryczna, $sinα$ kąt zawarty między wektorami indukcji magnetycznej a prędkości';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String pracawukladzie = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$W_{wl}=P_{wl}t=F↖{→}v↖{→}t$$[J]$ $W_{wl}=W_{ot}$ <br> $W_{ot}=I^2Rt$, $I=U/R={B↖{→}v↖{→}l}/R$ <br> $W_{wl}$ praca włożona, $P_{wl}$ moc włożona, $t$ czas $F↖{→}$ siła, $v↖{→}$ prędkość, $W_{ot}$ praca otrzymana/wydzielona na oporniku, $I$ natężenie prądu,  $R$ opór';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String indukcyjnoscCewkiEnergia = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$L=μ_0μ_r{N^2S}/l$ $[{Wb}/A=H]$ <br> $L=μ_0μ_r{N^2S}/l$$[J]$ <br> $L$ indukcyjność cewki,  $μ_0$ przenikalność magnetyczna próżni, $μ_r$ względna przenikalność magnetyczna $n$ liczba zwojów, $S$ pole przekroju $l$ długość, $E_{ind}$ energia pola elektromagnetycznego zgromadzona w cewce, $H$ henr,  $I$ natężenie prądu';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String samoindukcja = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$ε_s={Δϕ}/{Δt}=-L{Δl}/{Δt}$ <br> $ε_s$ samoindukcja (wzbudzana w zwojnicy podczas zmiany jej własnego pola magnetycznego) $Δϕ$ zamiana strumienia indukcji, $Δt$ zmiana czasu, $L$ indukcyjnosć $Δl$ zmiana długości';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.write(s);</script></body>";

            String indukcjaNieSama = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$ε_{wz}=-M{ΔI}/{Δt}$ <br> $ε_{wz}$ indukcja wzajemna (wzbudzana gdy np. właczamy i wyłaczamy jedną zwojniecę, to u drugiej obok wzbudza się prąd indukcyjny) $M$ wsp. proporcjonalności $ΔI$ zmiana natężenia, $Δt$ czas';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.write(s);</script></body>";


            webView1.loadDataWithBaseURL("file:///android_asset/", wektorPowierzchni, "text/html", "UTF-8", null);
            webView2.loadDataWithBaseURL("file:///android_asset/", strumien, "text/html", "UTF-8", null);
            webView3.loadDataWithBaseURL("file:///android_asset/", silaIndukcji, "text/html", "UTF-8", null);
            webView4.loadDataWithBaseURL("file:///android_asset/", regulaPrzekory, "text/html", "UTF-8", null);
            webView5.loadDataWithBaseURL("file:///android_asset/", przewodnikWprowadzenie, "text/html", "UTF-8", null);
            webView6.loadDataWithBaseURL("file:///android_asset/", pracawukladzie, "text/html", "UTF-8", null);
            webView7.loadDataWithBaseURL("file:///android_asset/", indukcyjnoscCewkiEnergia, "text/html", "UTF-8", null);
            webView8.loadDataWithBaseURL("file:///android_asset/", samoindukcja, "text/html", "UTF-8", null);
            webView9.loadDataWithBaseURL("file:///android_asset/", indukcjaNieSama, "text/html", "UTF-8", null);


            materialDesignFAM.setVisibility(View.VISIBLE);
            menu.setTitle(R.string.Indukcja_elektromagnetyczna);

        } else if (id == R.id.przemienny) {

            scrollView.fullScroll(ScrollView.FOCUS_UP);


            sprawdzenieMat = 13;
            sprawdzenie = 13;


            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.VISIBLE);
            card3.setVisibility(View.VISIBLE);
            card4.setVisibility(View.VISIBLE);
            card5.setVisibility(View.VISIBLE);
            card6.setVisibility(View.VISIBLE);
            card7.setVisibility(View.VISIBLE);
            card8.setVisibility(View.VISIBLE);
            card9.setVisibility(View.VISIBLE);
            card10.setVisibility(View.VISIBLE);
            card11.setVisibility(View.VISIBLE);
            card12.setVisibility(View.GONE);
            card13.setVisibility(View.GONE);
            card14.setVisibility(View.GONE);
            card15.setVisibility(View.GONE);
            card16.setVisibility(View.GONE);

            textView11.setVisibility(View.VISIBLE);
            textView12.setVisibility(View.VISIBLE);
            textView13.setVisibility(View.VISIBLE);
            textView14.setVisibility(View.VISIBLE);
            textView15.setVisibility(View.VISIBLE);
            textView16.setVisibility(View.VISIBLE);
            textView17.setVisibility(View.VISIBLE);
            textView18.setVisibility(View.VISIBLE);
            textView19.setVisibility(View.VISIBLE);
            textView20.setVisibility(View.VISIBLE);
            textView21.setVisibility(View.VISIBLE);
            textView22.setVisibility(GONE);
            textView23.setVisibility(GONE);
            textView24.setVisibility(GONE);
            textView25.setVisibility(GONE);
            textView26.setVisibility(GONE);


            webView1.setVisibility(View.VISIBLE);
            webView2.setVisibility(View.VISIBLE);
            webView3.setVisibility(View.VISIBLE);
            webView4.setVisibility(View.VISIBLE);
            webView5.setVisibility(View.VISIBLE);
            webView6.setVisibility(View.VISIBLE);
            webView7.setVisibility(View.VISIBLE);
            webView8.setVisibility(View.VISIBLE);
            webView9.setVisibility(View.VISIBLE);
            webView10.setVisibility(View.VISIBLE);
            webView11.setVisibility(View.VISIBLE);
            webView12.setVisibility(GONE);
            webView13.setVisibility(GONE);
            webView14.setVisibility(GONE);
            webView15.setVisibility(GONE);
            webView16.setVisibility(GONE);


            textView11.setText(R.string.praca_pr_du_przemiennego);
            textView12.setText(R.string.napi_cie_i_nat_enie_skuteczne);
            textView13.setText(R.string.napi_cie_i_nat_enie_chwilowe);
            textView14.setText(R.string.moc_skuteczna);
            textView15.setText(R.string.praca_pr_du_przemiennego);
            textView16.setText(R.string.wprowadznie_do_obwodu_rlc);
            textView17.setText(R.string.zawada_obwodu_rlc);
            textView18.setText(R.string.napi_cie_i_nat_enie_na_oporze_rlc);
            textView19.setText(R.string.transformator);
            textView20.setText(R.string.obw_d_drgaj_cy_lc);
            textView21.setText(R.string.dioda);


            String path = "file:///android_asset/";
            String pradnica = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$ε(t)=nSBωsin(ωt)=ε_0sin(ωt)$, $V$ <br> $ε(t)$ siła elektromotoryczna od czasu, $n$ liczba zwojów, $S$ przekrój poprzeczny zwojów, $B$ wartość indukcji pola magnetycznego, $ω$ częstość kołowa, $t$ czas $ε_0$ siła elektromotoryczna początkowa, $ωt$ faza pradu przemiennego, <br> W prądnicy wytwarza się prąd indukcyjny poprzez obrót uzwojenia w polu magnetycznym.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String skuteczne = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$I_s=I_0/√2$, $U_s=U_0/√2$  <br> Natężenie skuteczne prądu zmiennego to takie natężenie prądu stałego, ze w tym samym obwodzie i czasie wydzielałoby taką samą energię jak prad zmienny <br> $I_s$ natężenie skuteczne, $I_0$ natężenie początkowe, $U_s$ napięcie skuteczne, $U_o$ napięcie początkowe';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String chwilowe = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Jeśli obwód prądu zmiennego nie zawiera zwojnic i kondensatorów to chwilowe napiecie miedzy dwoma punktami jest zgodne w fazie z natężeniem. <br> $U(t)=U_0sin(ωt)$ <br> $I(t)=I_0sin(ωt)=U_0/Rsin(ωt)$ <br> $I_o$ natężenie początkowe, $I(t)$ natężenie od czasu, $U(t)$ napięcie od czasu, $U_0$ napięcie początkowe $ωt$ faza prądu $R$ opór';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String mocskuteczna = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$P_s=I_sU_s={I_0U_0}/2$ <br> $P_s$ moc skuteczna, $I_s$ natężenie skuteczne, $U_s$ napięcie skuteczne, $I_0$ natężenie początkowe, $U_0$ napięcie początkowe';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String pracaprad = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Praca to pole figury pod wykresem mocy od czasu. <br> $W=1/2I_0^2RT$, gdzi $W$ praca, $I_0$ natężenie początkowe, $R$ opór, $T$ czas, czyli okres prądu przemiennego';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String rlcwprowadznie = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Dla obwodu połączonego szeregowo, składającego się z opornika o oporze R, zwojnicy/cewki o indukcyjności L i kondensatora o pojemności C, podłączonym do zródła prądu przemiennego. <br> Opór na oporniku $=R$, opór na cewce $R_L=ωL=2πfL$, $R_c=1/{ωC}=1/{2πfC}$ <br> Gdy $R_L>R_C$ obwód ma charakter indukcyjny/napięcie wyprzedza w fazie natężenie, gdy $R_C>R_L$ opór ma charakter pojemnościowy/napiecie opóźnia sie w fazie wzg.  natęzenia.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String rlczawada = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$Z_{RLC}=√{R^2+(R_L-R_C)^2}$,$[Ω]$ $tgα={R_L-R_C}/R$ <br> $Z_{RLC}$ zawada, $R$ opór opornika, $R_L$ opór cewki, $R_C$ opór kondensatora, zawada to wektor wypadkowy wektorów: $R$ biegnacego wzdłóz osi x, $R_L$ biegnącego wzdłóż osi y, w kierunku wartości dodatnich, $R_C$ wzdłóż osi y w kierunku wartości ujemnych.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String rlcnapiecie = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$U_{RLC}=√{U_R^2+(U_L-U_C)^2}$ <br> $U_{RLC}$ napięcie w obwodzie, $U_R$ napięcie na oporniku, $U_L$ napięcie na cewce, $U_C$ napięcie na kondensatorze <br> $U(t)=U_0sin(ωt+φ_0)$, $I(t)=I_0sint(ωt+φ_0)$ <br> $U(t)$ napięcie od czasu, $I(t)$ natężenie od czasu, $U_0$ napięcie początkowe, $I_0$ natężenie początkowe, $ωt$ faza prądu, $φ_0$ przesunięcie początkowe';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.write(s);</script></body>";

            String transformator = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$n_p/n_p=U_p/U_p=I_p/I_p, k=n_2/n_1$ <br> $n_p$ ilość zwojów na uzwojeniu pierwotnym, $n_w$ ilość zwojów na uzwojeniu wtórnym, $U_p$ napięcnie na uzwojeniu pierwotnym, $U_w$ napięcie na uzwojeniu wtórnym, $I_p$ natężenie na uzwojeniu pierwotnym, $I_w$ natężenie na uzwojeniu wtórnym';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String drgajacyLcwprowadzenie = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Obwód LC w którym opór jest bardzo mały $(R≈0)$, składa się z kondeansatora o pojemności $C$ i cewki o indukcyjności $L$ <br> Naładowanie kondensatora, a potem jego rozładowywanie prowadzi do wytworzenia drgań elektromagentycznych o okresie: $T=2π√{LC}$  <br> Energia zgromadzona na kondensatorze podczas jego naładowania, $E_p={CU^2}/2$, energia zgromadzona na cewce gdy popłynęły przez nią ładunki z kondensatora $E_w={LI^2}/2$ <br> $Q(t)=Q_0cos(ωt)$, $Q$ ładunek, $Q_0$ ładunek początkowy, $ωt$ faza';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String dioda = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Dioda to element prostowniczy obwodu, przewodzi prąd w jednym kierunku bardziej niż w drugim. Idealną dioda (nie przepuszczająca żadnego łądunku, lub przepuszczającą cały łądunek w jedną ze stron) możemy umieścić w kierunku zaporowym (nie przepuszcza) lub przepustowym (przepuszcza).';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.write(s);</script></body>";


            webView1.loadDataWithBaseURL("file:///android_asset/", pradnica, "text/html", "UTF-8", null);
            webView2.loadDataWithBaseURL("file:///android_asset/", skuteczne, "text/html", "UTF-8", null);
            webView3.loadDataWithBaseURL("file:///android_asset/", chwilowe, "text/html", "UTF-8", null);
            webView4.loadDataWithBaseURL("file:///android_asset/", mocskuteczna, "text/html", "UTF-8", null);
            webView5.loadDataWithBaseURL("file:///android_asset/", pracaprad, "text/html", "UTF-8", null);
            webView6.loadDataWithBaseURL("file:///android_asset/", rlcwprowadznie, "text/html", "UTF-8", null);
            webView7.loadDataWithBaseURL("file:///android_asset/", rlczawada, "text/html", "UTF-8", null);
            webView8.loadDataWithBaseURL("file:///android_asset/", rlcnapiecie, "text/html", "UTF-8", null);
            webView9.loadDataWithBaseURL("file:///android_asset/", transformator, "text/html", "UTF-8", null);
            webView10.loadDataWithBaseURL("file:///android_asset/", drgajacyLcwprowadzenie, "text/html", "UTF-8", null);
            webView11.loadDataWithBaseURL("file:///android_asset/", dioda, "text/html", "UTF-8", null);


            materialDesignFAM.setVisibility(View.VISIBLE);
            menu.setTitle(R.string.pr_d_przemienny_i_obwody);


        } else if (id == R.id.optyka) {

            scrollView.fullScroll(ScrollView.FOCUS_UP);


            sprawdzenieMat = 14;
            sprawdzenie = 14;


            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.VISIBLE);
            card3.setVisibility(View.VISIBLE);
            card4.setVisibility(View.VISIBLE);
            card5.setVisibility(View.VISIBLE);
            card6.setVisibility(View.VISIBLE);
            card7.setVisibility(View.VISIBLE);
            card8.setVisibility(View.VISIBLE);
            card9.setVisibility(View.VISIBLE);
            card10.setVisibility(View.VISIBLE);
            card11.setVisibility(View.VISIBLE);
            card12.setVisibility(View.GONE);
            card13.setVisibility(View.GONE);
            card14.setVisibility(View.GONE);
            card15.setVisibility(View.GONE);
            card16.setVisibility(View.GONE);

            textView11.setVisibility(View.VISIBLE);
            textView12.setVisibility(View.VISIBLE);
            textView13.setVisibility(View.VISIBLE);
            textView14.setVisibility(View.VISIBLE);
            textView15.setVisibility(View.VISIBLE);
            textView16.setVisibility(View.VISIBLE);
            textView17.setVisibility(View.VISIBLE);
            textView18.setVisibility(View.VISIBLE);
            textView19.setVisibility(View.VISIBLE);
            textView20.setVisibility(View.VISIBLE);
            textView21.setVisibility(View.VISIBLE);
            textView22.setVisibility(GONE);
            textView23.setVisibility(GONE);
            textView24.setVisibility(GONE);
            textView25.setVisibility(GONE);
            textView26.setVisibility(GONE);


            webView1.setVisibility(View.VISIBLE);
            webView2.setVisibility(View.VISIBLE);
            webView3.setVisibility(View.VISIBLE);
            webView4.setVisibility(View.VISIBLE);
            webView5.setVisibility(View.VISIBLE);
            webView6.setVisibility(View.VISIBLE);
            webView7.setVisibility(View.VISIBLE);
            webView8.setVisibility(View.VISIBLE);
            webView9.setVisibility(View.VISIBLE);
            webView10.setVisibility(View.VISIBLE);
            webView11.setVisibility(View.VISIBLE);
            webView12.setVisibility(GONE);
            webView13.setVisibility(GONE);
            webView14.setVisibility(GONE);
            webView15.setVisibility(GONE);
            webView16.setVisibility(GONE);
            textView11.setText(R.string.zwierciad_a);
            textView12.setText(R.string.soczewki);
            textView13.setText(R.string.soczewki_skup);
            textView14.setText(R.string.obrazy);
            textView15.setText(R.string.za_amanie_wiet_a);
            textView16.setText(R.string.zaleznosc_katy);
            textView17.setText(R.string.kat_graniczny);
            textView18.setText(R.string.polaryzacja);
            textView19.setText(R.string.polaryzacja_odbicie);
            textView20.setText(R.string.polaryzacja_zalamanie);
            textView21.setText(R.string.siatka);
            String path = "file:///android_asset/";
            String zwiercdialo = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Dla zwierciadła płaskiego wklęsłego, lub wypukłego o promieniu krzywizny $O$, ogniskowej $f=1/2O$, w pobliżu którego umieszczono przedmiot o wysokości $h_x$ i odległości od zwierciadła $x$, powstaje obraz o wysokości $h_y$ i odgległości od zwierciadła $y$ <br> $1/x+1/y=1/f$ <br> Zdolność skupiająca $Z=1/f[1/m=D]$ <br> Powiększenie $p=∣{y/x}∣=∣{h_y/h_x}∣$ <br> $D$ dioptria';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String soczewki = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Dla soczewki o ogniskowej rozpraszającej, lub skupiającej o ogniskowej $f$, w pobliżu której umieszczono przedmiot o wysokości $h_x$ i odległości od soczewki $x$, powstaje obraz o wysokości $h_y$ i odgległości od soczewki $y$ <br> $1/x+1/y=1/f$ <br> Zdolność skupiająca $Z=1/f[1/m=D]$ <br> Powiększenie $p=∣{y/x}∣=∣{h_y/h_x}∣$ <br> $D$ dioptria <br> ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String soczewkiskup = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Dla soczewki o takich samych właściwościach jak w temacie wyżej uwzględniając współćzynnik załamania światła w soczewce i ośrodku zewnętrznym. <br> $1/f=(n_{sc}/n_{os}-1)(1/r_1+1/r_2)$ <br> $n_{sc}$ współczynnik załamania soczewki, $n_{os}$ współczynnik załamania ośrodka, $r_1$ promień pierwszy, $r_2$ promień drugi $f$ ogniskowa <br> dla soczewki skupiającej $r>0$, dla soczewki rozpraszającej $0>r$ <br> jeżeli $f>0$ to soczewka jest skupiająca, jeżeli $0>f$ to soczewka jest rozpraszająca <br> ogniskowej soczewki rozpraszającej przypisujemy wartość ujemną';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


            String obraz = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'W soczewka, zwierciadłach powstajające obrazy wykazują następujące cechy, mogą być: <br> 1.powięszkone/pomniejszone <br> 2.proste/odwrócone <br> 3.pozorne/rzeczywiste <br> Na ekranie powstaje zawsze obraz rzeczywisty, obraz pozorny powstaje po przecięciu się przedłużen promieni. Gdy obraz jest pozorny to w rówaniu soczewki/zwierciadła składnik $1/y$ zapisujemy $-1/y$ ';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String zalamanieswiatla = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Światło przechodząc z jednego ośrodka do drugiego ulega załamaniu, kąt padania światła jest zawsze równy kątowi odbicia. <br> Kąt padania/odbicia jest to kąt miedzy promieniem światła a osią $y$, która jest prostopadła do powierzchni styku ośrodka perwszego i drugiego. <br> Podczas przejścia z ośrodka pierwszego do drugiego, gdzie $v_1>v_2$, $λ_1>λ_2$ to <br> $n_{1,2}={sinα}/{sinβ}=n_2/n_1=v_1/v_2=λ_1/λ_2$ <br> $n_1$ współczynnik załamania światła ośrodka pierwszego $n_1=c/v_1$, $n_2$ współczynnik załamania ośrodka drugiego, $α$ kąta pod jakim pada światło w 1 ośrodku, $β$ kąt pod jakim pada światło w drugim ośrodku $λ_1$ długość fali w 1 ośrodku, $λ_2$ długość fali w 2 ośrodku';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String zaleznosc = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = ' Kąt odbicia jest mniejszy od końca padania gdy: <br> $v_1>v_2$, $λ_1>λ_2$, $n_2>n_1$ <br> Kąt odbicia jest większy od kąta padania gdy: <br> $v_2>v_1$, $λ_2>λ_1$ lub $n_1>n_2$ <br> Podczas przejść swiatła między ośrodkami nie zmienia się jego częstotliwość.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


            String katgraniczny = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Kąt graniczny jest to maksymalny kąt pod jakim padajacy promień ulega załamaniu. <br> ${sinα}=n_2/n_1$ <br> ${sinα}$ sinus kąta padania, $n_2$ współczynnik załamania ośrodka drugiego, $n_1$ współczynnik załamania ośrodka pierwszego';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String polaryzacja = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Promień jest spolaryzowany gdy kąt zawarty miedzy promieniem odbity, a załamanym jest kątem prostym. Taki kat nazywamy kątem Brustera.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String odbicie = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Polaryzowanie przez odbicie <br> ${tgα}=n_2/n_1$ <br> ${tgα}$ tangens kąta padania, $n_2$ współczynnik załamania światła w ośrodku drugim, $n_1$ wsp. załamania światła w oś. pierwszym';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String szczelina = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Gdy promień niespolaryzowanego światła pada na płytkę polaryzacyjną to przepuszczana jest składowa wektora natężenia pola równoległa do kierunku polaryzacji polaryzatora. <br> $I=I_0/2$ <br> Gdy wiązka spolaryzowanego światła pada na kolejną płytkę to natężenie zależy od kąta miedzy kierunkiem polaryzacji swiatla a kier. polaryzacji polaryzatora. <br> $I=I_0{cos^2θ}$.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


            String siatka = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Światło białe przechodzące przez siątkę dyfrakcyjną ulega rozszczepieniu sie na barwy (światło monochormatyczne nie), powstają prążki w określonych rzędach <br><br> $nλ=d{sin}α$ <br><br> $n$ rząd prążka, $λ$ długośc fali, $d$ stała siatki dyfrakcyjnej ${sin}α_n$ kąt między promieniem rzędu ($P_0$) prostopadłego na ekran, a promieniem padającym na wysokość określonego rzędu, $d$ stała siatki dyfrakcyjnej <br> $d= $ jednostka długości/ilość rys';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


            webView1.loadDataWithBaseURL("file:///android_asset/", zwiercdialo, "text/html", "UTF-8", null);
            webView2.loadDataWithBaseURL("file:///android_asset/", soczewki, "text/html", "UTF-8", null);
            webView3.loadDataWithBaseURL("file:///android_asset/", soczewkiskup, "text/html", "UTF-8", null);
            webView4.loadDataWithBaseURL("file:///android_asset/", obraz, "text/html", "UTF-8", null);
            webView5.loadDataWithBaseURL("file:///android_asset/", zalamanieswiatla, "text/html", "UTF-8", null);
            webView6.loadDataWithBaseURL("file:///android_asset/", zaleznosc, "text/html", "UTF-8", null);
            webView7.loadDataWithBaseURL("file:///android_asset/", katgraniczny, "text/html", "UTF-8", null);
            webView8.loadDataWithBaseURL("file:///android_asset/", polaryzacja, "text/html", "UTF-8", null);
            webView9.loadDataWithBaseURL("file:///android_asset/", odbicie, "text/html", "UTF-8", null);
            webView10.loadDataWithBaseURL("file:///android_asset/", szczelina, "text/html", "UTF-8", null);
            webView11.loadDataWithBaseURL("file:///android_asset/", siatka, "text/html", "UTF-8", null);


            menu.setTitle(R.string.optyka);
            materialDesignFAM.setVisibility(View.VISIBLE);


        } else if (id == R.id.wspolczesna) {

            scrollView.fullScroll(ScrollView.FOCUS_UP);

            sprawdzenieMat = 15;
            sprawdzenie = 15;


            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.VISIBLE);
            card3.setVisibility(View.VISIBLE);
            card4.setVisibility(View.VISIBLE);
            card5.setVisibility(View.VISIBLE);
            card6.setVisibility(View.VISIBLE);
            card7.setVisibility(View.VISIBLE);
            card8.setVisibility(View.VISIBLE);
            card9.setVisibility(View.VISIBLE);
            card10.setVisibility(View.GONE);
            card11.setVisibility(View.GONE);
            card12.setVisibility(View.GONE);
            card13.setVisibility(View.GONE);
            card14.setVisibility(View.GONE);
            card15.setVisibility(View.GONE);
            card16.setVisibility(View.GONE);

            textView11.setVisibility(View.VISIBLE);
            textView12.setVisibility(View.VISIBLE);
            textView13.setVisibility(View.VISIBLE);
            textView14.setVisibility(View.VISIBLE);
            textView15.setVisibility(View.VISIBLE);
            textView16.setVisibility(View.VISIBLE);
            textView17.setVisibility(View.VISIBLE);
            textView18.setVisibility(View.VISIBLE);
            textView19.setVisibility(View.VISIBLE);
            textView20.setVisibility(GONE);
            textView21.setVisibility(GONE);
            textView22.setVisibility(GONE);
            textView23.setVisibility(GONE);
            textView24.setVisibility(GONE);
            textView25.setVisibility(GONE);
            textView26.setVisibility(GONE);


            webView1.setVisibility(View.VISIBLE);
            webView2.setVisibility(View.VISIBLE);
            webView3.setVisibility(View.VISIBLE);
            webView4.setVisibility(View.VISIBLE);
            webView5.setVisibility(View.VISIBLE);
            webView6.setVisibility(View.VISIBLE);
            webView7.setVisibility(View.VISIBLE);
            webView8.setVisibility(View.VISIBLE);
            webView9.setVisibility(View.VISIBLE);
            webView10.setVisibility(GONE);
            webView11.setVisibility(GONE);
            webView12.setVisibility(GONE);
            webView13.setVisibility(GONE);
            webView14.setVisibility(GONE);
            webView15.setVisibility(GONE);
            webView16.setVisibility(GONE);


            textView11.setText(R.string.zjawisko_fotoelektryczne_zewn_trzne);
            textView12.setText(R.string.model_atomu_bohra);
            textView13.setText(R.string.energia_jonizacji);
            textView14.setText(R.string.widmo);
            textView15.setText(R.string.deficity_masy);
            textView16.setText(R.string.energia_wi_zania_i_trwa_o);
            textView17.setText(R.string.promieniowanie);
            textView18.setText(R.string.okres);
            textView19.setText(R.string.heisenberg);
            String path = "file:///android_asset/";
            String fotoelektrycznezewnetrzne = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$E_f=W_0+E_k_{max}$ <br> $E_f$ energia fotonu, $W_e$ praca wyjścia, $E_k_{max}$ maksymalna energia kinetyczna <br> $E_f=hν={hc}/λ$, $W_0=hν_{gra.}={hc}/λ_{gra.}$, $E_k_{max}={mv^2}/2=eU_h$ <br> $ν$ częstotliwość fali $[Hz]$, $ν_{gra.}$ częstotliwość graniczna, $c$ prędkość światła, $e$ ładunek, $U_h$ napięie hamowania, $h$ stała planca $λ$ długość fali $[m]$ $λ_{gra.}$ graniczna długość fali <br> Zjawisko fotoelektryczne zewnętrzne nie zachodzi gdy $W_0>E_f$.';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


            String modelbohra = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$mV_nr_n=n{h}/{2π}$ <br> $m$ masa elektronu, $n$ numer orbity, $V_n$ prędkość na danej orobicie, $r_n$ promień danej orbity <br> $r_1=5,3*10^{-11}[m]$ <br> Stosunek prędkości elektronów na kolejnych orbitach dozwolonych można wyrazić zależnością: $v_1:v_2:v_3...v_n=1:1/2:1/3....1/n$ <br> Energia na danej orbicie dozwolonej wynosi $E_n={-13,6}/n^2[eV]$ <br> Stosunek energi elektronów na kolejnych orbitach dozwolonych można wyrazić zależnościa: <br> $E_1:{E_2}...{E_n}=1:1/{2^2}....1/{n^2}$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String energiajonizacji = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Energia potrzebna do przeniesienia elektronu z orbity pierwszej do nieskoczoności nosi nazwę energii jonizacji. <br> $E_j=E_∞-E_1=13,6[eV]$ <br> $E_j$ energia jonizacji, $E_∞$ energia w nieskonczoności, $E_1$ energia na pierwszej orbicie';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String widmo = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$ν=cR(1/n^2-1/k^2)$ <br> $ν$ częstotliwość, $c$ prędkość swiatła, $R$ stała Rydberga $(1,097*10^7 [1/m])$, $n$ numer orbity, na którą przechodzi elektron, $k$ numer orbity, z której elektron jest przenoszony';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String deficit = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '$Δm=m_{sk}-m_{j}=Zm_p+(A-Z)m_n-m_j$ <br> $Δm$ deficity masy, $Z$ liczba atomowa, $m_p$ masa protonu, $A$ liczba masowa, $m_n$ masa neutronu';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String energiawiazania = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Energia wiązania to energia jaką trzeba dostarczyć do jądra atomu aby rozbić je na poszczególne nukleony $E=Δmc^2$ <br>';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String rozpadalfa = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Promieniowanie alfa/powstają jądra Helu <br> $^A_ZX->_{Z-2}^{A-4}Y+_2^4{He}$ <br> Promieniowanie beta minus/powstają elektrony <br> $^A_ZX->_{Z+1}^{A}Y+_{-1}^0β^{-}$ <br> Promieniowanie beta plus/powstają pozytony <br> $^A_ZX->_{Z+1}^{A}Y+_{1}^0β^{+}$ <br> $A$ liczba masowa, $Z$ liczba atomowa, $X$ dany pierwiastek, $Y$ powstały pierwiastek, ${He}=α$ jądro helu, cząstka alfa $β$ cząstka beta';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            String rozpad = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Czas połowicznego rozpadu to okres po którym pozostaje połowa masy początkowej danej substancji. Podczas jednego okresu rozpada się połowa masy początkowej. Zależność ilości substancji od czasu opisuje rówanie: <br> $N(t)=N_0-(1/2)^{t/T_{1/2}}$ <br> $N$ ilość substancji, $t$ czas, $T_{1/2}$ okres połowicznego rozpadu';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            String zasada = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Nie można dokonać jednoczesnego pomiaru dwóch wielkości charakteryzujących rozpatrywane ciało z tą samą dokładnością <br> $ΔxΔp≥h/{4π}$ <br> $ΔEΔt≥h/{4π}$ <br> $x$ przemieszczenie, $p$ pęd, $h$ stała Planca, $E$ energia, $t$ czas';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";


            webView1.loadDataWithBaseURL("file:///android_asset/", fotoelektrycznezewnetrzne, "text/html", "UTF-8", null);
            webView2.loadDataWithBaseURL("file:///android_asset/", modelbohra, "text/html", "UTF-8", null);
            webView3.loadDataWithBaseURL("file:///android_asset/", energiajonizacji, "text/html", "UTF-8", null);
            webView4.loadDataWithBaseURL("file:///android_asset/", widmo, "text/html", "UTF-8", null);
            webView5.loadDataWithBaseURL("file:///android_asset/", deficit, "text/html", "UTF-8", null);
            webView6.loadDataWithBaseURL("file:///android_asset/", energiawiazania, "text/html", "UTF-8", null);
            webView7.loadDataWithBaseURL("file:///android_asset/", rozpadalfa, "text/html", "UTF-8", null);
            webView8.loadDataWithBaseURL("file:///android_asset/", rozpad, "text/html", "UTF-8", null);
            webView9.loadDataWithBaseURL("file:///android_asset/", zasada, "text/html", "UTF-8", null);


            materialDesignFAM.setVisibility(View.VISIBLE);
            menu.setTitle(R.string.fizyka_wsp_czesna);

        } else if (id == R.id.stale) {

            scrollView.fullScroll(ScrollView.FOCUS_UP);

            sprawdzenie = 16;


            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.VISIBLE);
            card3.setVisibility(View.VISIBLE);
            card4.setVisibility(View.VISIBLE);
            card5.setVisibility(View.GONE);
            card6.setVisibility(View.GONE);
            card7.setVisibility(View.GONE);
            card8.setVisibility(View.GONE);
            card9.setVisibility(View.GONE);
            card10.setVisibility(View.GONE);
            card11.setVisibility(View.GONE);
            card12.setVisibility(View.GONE);
            card13.setVisibility(View.GONE);
            card14.setVisibility(View.GONE);
            card15.setVisibility(View.GONE);
            card16.setVisibility(View.GONE);

            textView11.setVisibility(View.VISIBLE);
            textView12.setVisibility(View.GONE);
            textView13.setVisibility(View.GONE);
            textView14.setVisibility(View.GONE);
            textView15.setVisibility(GONE);
            textView16.setVisibility(GONE);
            textView17.setVisibility(GONE);
            textView18.setVisibility(GONE);
            textView19.setVisibility(GONE);
            textView20.setVisibility(GONE);
            textView21.setVisibility(GONE);
            textView22.setVisibility(GONE);
            textView23.setVisibility(GONE);
            textView24.setVisibility(GONE);
            textView25.setVisibility(GONE);
            textView26.setVisibility(GONE);


            webView1.setVisibility(View.VISIBLE);
            webView2.setVisibility(View.VISIBLE);
            webView3.setVisibility(View.VISIBLE);
            webView4.setVisibility(View.VISIBLE);
            webView5.setVisibility(GONE);
            webView6.setVisibility(GONE);
            webView7.setVisibility(GONE);
            webView8.setVisibility(GONE);
            webView9.setVisibility(GONE);
            webView10.setVisibility(GONE);
            webView11.setVisibility(GONE);
            webView12.setVisibility(GONE);
            webView13.setVisibility(GONE);
            webView14.setVisibility(GONE);
            webView15.setVisibility(GONE);
            webView16.setVisibility(GONE);


            textView11.setText(R.string.wybrane_sta_e_fizyczne);


            String path = "file:///android_asset/";
            String przyspieszenie = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '1. Przyśpieszenie ziemskie $g=9,81$ $[m/s^2]$ <br><br>2. Masa Ziemi $M_z=5,98·10^24$ $[kg]$ <br><br>3. Średni promień $R_z=6370$$[km]$ <br><br>';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"left\";document.write(s);</script></body>";

            String przyspieszenieczetery = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '4. Liczba Avogadra $N_A=6,02·10^23$$[1/{mol}]$ <br><br>5. Stała grawitacji $G=6,67·10^-11$$[{Nm^2}/kg^2]$ <br><br>6. Objętość mola dla $t=0C$ oraz $p=1013,25{hPa}$, $V=22,41 [{dm}^3/mol]$<br><br> 7. Uniwersalna stała Gazowa $R=8,31$$[J/{mol·K}]$ <br><br>8. Stała Boltzmana $k_B=1,38·10^{-23}$$[J/K]$ <br><br>';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"left\";document.write(s);</script></body>";


            String przyspieszenietrzys = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '9. Stała elektryczna $k=1/{4π·ε_0}=8,99·10^9$$[{N·m^2}/C^2]$ <br><br>10. Przenikalność magnetyczna próżni $μ_0=4π·10^{-7}$$N/A^2$ <br><br> 11. Prędkość światła $c=3,000·10^8$$[m/s]$ <br><br>12. Stała Planca $h=6,63·10^{-34}$$[J·s]$ <br><br>13. Ładunek elektryczny $e=1,60·10^{-19}$$[C]$ <br><br>14. Masa elektronu $m=9,110·10^{-31}$$[kg]$<br><br>';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"left\";document.write(s);</script></body>";


            String przyspieszeniedwa = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = '15. Masa protonu $m=1,673·10^{-27}$$[kg]$ <br><br>16. Masa neutronu $m=1,675·10^{-27}$$[kg]$ <br><br>17. Jednostka masy atomowej $1u=1,661·10^{-27}$$[kg]$ <br><br>18. Elektronvolt $1eV=1,60·10^{-19}$$[J]$ <br><br>19. Stała Hubblea $H≈75$$[km/{s·{Mpc}}]$ <br><br>20. Parsek $1pc=3,09·10^16$$[m]$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.color = \"black\";document.body.style.backgroundColor = \"white\";document.body.style.textAlign = \"left\";document.write(s);</script></body>";


            webView1.loadDataWithBaseURL("file:///android_asset/", przyspieszenie, "text/html", "UTF-8", null);
            webView2.loadDataWithBaseURL("file:///android_asset/", przyspieszenieczetery, "text/html", "UTF-8", null);
            webView3.loadDataWithBaseURL("file:///android_asset/", przyspieszenietrzys, "text/html", "UTF-8", null);
            webView4.loadDataWithBaseURL("file:///android_asset/", przyspieszeniedwa, "text/html", "UTF-8", null);


            menu.setTitle(R.string.sta_e_fizyczne);
            materialDesignFAM.close(true);
            materialDesignFAM.setVisibility(GONE);

        } else if (id == R.id.przedrostki) {

            scrollView.fullScroll(ScrollView.FOCUS_UP);

            sprawdzenie = 17;

            card1.setVisibility(View.VISIBLE);
            card2.setVisibility(View.GONE);
            card3.setVisibility(View.GONE);
            card4.setVisibility(View.GONE);
            card5.setVisibility(View.GONE);
            card6.setVisibility(View.GONE);
            card7.setVisibility(View.GONE);
            card8.setVisibility(View.GONE);
            card9.setVisibility(View.GONE);
            card10.setVisibility(View.GONE);
            card11.setVisibility(View.GONE);
            card12.setVisibility(View.GONE);
            card13.setVisibility(View.GONE);
            card14.setVisibility(View.GONE);
            card15.setVisibility(View.GONE);
            card16.setVisibility(View.GONE);


            textView11.setVisibility(View.VISIBLE);
            textView12.setVisibility(GONE);
            textView13.setVisibility(GONE);
            textView14.setVisibility(GONE);
            textView15.setVisibility(GONE);
            textView16.setVisibility(GONE);
            textView17.setVisibility(GONE);
            textView18.setVisibility(GONE);
            textView19.setVisibility(GONE);
            textView20.setVisibility(GONE);
            textView21.setVisibility(GONE);
            textView22.setVisibility(GONE);
            textView23.setVisibility(GONE);
            textView24.setVisibility(GONE);
            textView25.setVisibility(GONE);
            textView26.setVisibility(GONE);


            webView1.setVisibility(View.VISIBLE);
            webView2.setVisibility(GONE);
            webView3.setVisibility(GONE);
            webView4.setVisibility(GONE);
            webView5.setVisibility(GONE);
            webView6.setVisibility(GONE);
            webView7.setVisibility(GONE);
            webView8.setVisibility(GONE);
            webView9.setVisibility(GONE);
            webView10.setVisibility(GONE);
            webView11.setVisibility(GONE);
            webView12.setVisibility(GONE);
            webView13.setVisibility(GONE);
            webView14.setVisibility(GONE);
            webView15.setVisibility(GONE);
            webView16.setVisibility(GONE);

            textView11.setText(R.string.przedrostek_mno_nik_oznaczenie);

            String path = "file:///android_asset/";
            String tera = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = 'Tera $10^{12}$$[T]$ <br> Giga $10^{9}$$[G]$ <br> Mega $10^{6}$$[M]$ <br> Kilo $10^{3}$$[k]$ <br> Hekto $10^{2}$$[h]$ <br> Deka $10^{1}$$[{da}]$ <br> Decy $10^1$$[d]$ <br> Centy $10^{-2}$$[c]$ <br> Mili $10^{-3}$$[m]$ <br> Mikro $10^{-6}$$[μ]$ <br> Nano $10^{-9}$$[n]$ <br> Piko $10^{-12}$$[p]$';M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

            webView1.loadDataWithBaseURL("file:///android_asset/", tera, "text/html", "UTF-8", null);


            menu.setTitle(R.string.przedrostki);

            materialDesignFAM.close(true);
            materialDesignFAM.setVisibility(GONE);

        } else if (id == R.id.onas) {
            Info();
        }
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


        return true;
    }


    private void fillWebViews(ArrayList<String> equations) {
        for (int i = 0; i < equations.size(); i++) {
            webViews[i].loadDataWithBaseURL("file:///android_asset/", equations.get(i), "text/html", "UTF-8", null);
        }
    }

    private void fillTextViews(int[] titles) {
        for (int i = 0; i < titles.length; i++) {
            textViews[i].setText(titles[i]);
        }
    }


    private void setViewsVisibility(int max) {
        for (int i = 0; i < 16; i++) {
            if (i < max) {
                textViews[i].setVisibility(View.VISIBLE);
                cardViews[i].setVisibility(View.VISIBLE);
                webViews[i].setVisibility(View.VISIBLE);
            } else {
                textViews[i].setVisibility(View.GONE);
                cardViews[i].setVisibility(View.GONE);
                webViews[i].setVisibility(View.GONE);

            }
        }
    }

    private ArrayList<String> generateEquationsInHtmlStrings(ArrayList<String> rawEquations) {
        ArrayList<String> htmlEquations = new ArrayList<>();
        String path = "file:///android_asset/";
        for (String rawEquation : rawEquations) {

            String htmlEquation = "<html><head>"
                    + "<link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>"
                    + "<script src='" + path + "jquery-1.4.3.min.js'></script>"
                    + "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>"
                    + "</head><body>"
                    + "<script>var s = " + rawEquation + ";M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";
            htmlEquations.add(htmlEquation);
        }
        return htmlEquations;
    }

    @Override
    protected void onPostResume() {

        android.support.v7.app.ActionBar menu = getSupportActionBar();


        if (sprawdzenie == 101) {
            menu.setTitle(R.string.kinematyka);
        }
        if (sprawdzenie == 102) {
            menu.setTitle(R.string.dynamika);
        }
        if (sprawdzenie == 103) {
            menu.setTitle(R.string.praca_moc_energia);
        }
        if (sprawdzenie == 104) {
            menu.setTitle(R.string.bry_a_sztywna);
        }
        if (sprawdzenie == 105) {
            menu.setTitle(R.string.termodynamika);
        }
        if (sprawdzenie == 106) {
            menu.setTitle(R.string.grawitacja_i_kosmos);
        }
        if (sprawdzenie == 107) {
            menu.setTitle(R.string.ruch_drgaj_cy);
        }
        if (sprawdzenie == 108) {
            menu.setTitle(R.string.fale_mechaniczne);
        }
        if (sprawdzenie == 109) {
            menu.setTitle(R.string.elektrostatyka);
        }
        if (sprawdzenie == 110) {
            menu.setTitle(R.string.pr_d_sta_y);
        }
        if (sprawdzenie == 111) {
            menu.setTitle(R.string.magnetyzm);
        }
        if (sprawdzenie == 112) {
            menu.setTitle(R.string.indukcja_elektromagnetyczna);
        }
        if (sprawdzenie == 113) {
            menu.setTitle(R.string.pr_d_przemienny_i_obwody);
        }
        if (sprawdzenie == 114) {
            menu.setTitle(R.string.optyka);
        }
        if (sprawdzenie == 115) {
            menu.setTitle(R.string.fizyka_wsp_czesna);
        }
        if (sprawdzenie == 116) {
            menu.setTitle(R.string.sta_e_fizyczne);
        }
        if (sprawdzenie == 117) {
            menu.setTitle(R.string.przedrostki);
        }

        super.onPostResume();
    }
}
