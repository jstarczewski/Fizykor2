package com.clakestudio.pc.fizykor;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.IdRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.widget.Space;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static android.R.color.white;
import static java.lang.Math.abs;


/**
 * Created by pc on 2016-10-08.
 */


public class ActivityTest extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {


    FiszkiFragment myFragment = new FiszkiFragment();
    FiszkiFragmentDynamo FiszkiDynamo = new FiszkiFragmentDynamo();
    FiszkiFragmentPraca FiszkiPraca = new FiszkiFragmentPraca();
    FiszkiBrylaFragment FiszkiBryla = new FiszkiBrylaFragment();
    FiszkiFragmentTermo FiszkiTermo = new FiszkiFragmentTermo();
    FiszkiGrawiFragment FiszkiGrawi = new FiszkiGrawiFragment();
    FiszkiDrgajacyFragment FiszkiDrgania = new FiszkiDrgajacyFragment();
    FiszkiMechaniczneFragment FiszkiMechaniczne = new FiszkiMechaniczneFragment();
    FiszkiElektrostatykaFragment FiszkiElektro = new FiszkiElektrostatykaFragment();
    FiszkiStalyFragment FiszkiStaly = new FiszkiStalyFragment();
    FiszkiFragmentMagne FiszkiMagne = new FiszkiFragmentMagne();
    FiszkiIndukcjaFragment FiszkiIndu = new FiszkiIndukcjaFragment();
    FiszkiFragmentPrzem FiszkiPrzem = new FiszkiFragmentPrzem();
    FiszkiFragmentWspol FiszkiWspl = new FiszkiFragmentWspol();
    FiszkiFragmentOptyka FiszkiOptyka = new FiszkiFragmentOptyka();

    // maturalne

    FiszkiKinMatFragment KinMatFragment = new FiszkiKinMatFragment();
    FiszkiDynMatFragment DynMatFragment = new FiszkiDynMatFragment();
    FiszkiMatPracaFragment PracaMatFragment = new FiszkiMatPracaFragment();
    FiszkiMatBrylaFragment BrylaMatFragment = new FiszkiMatBrylaFragment();
    FiszkiMatTermoFragment TermoMatFragment = new FiszkiMatTermoFragment();
    FiszkiMatGrawiFragment GrawiMatFragment = new FiszkiMatGrawiFragment();
    FiszkiMatDrgajacyFragment DrgMatFramgnet = new FiszkiMatDrgajacyFragment();
    FiszkiMatMechaniczneFragment MechMatFragment = new FiszkiMatMechaniczneFragment();
    FiszkiMatElektrostatykaFragment ElektroMatFragment = new FiszkiMatElektrostatykaFragment();
    FiszkiMatStalyFragment StalyMatFramgnet = new FiszkiMatStalyFragment();
    FiszkiMatMagFragment MagneMatFragment = new FiszkiMatMagFragment();
    FiszkiMatInduFragment InduMatFragment = new FiszkiMatInduFragment();
    FiszkiMatPrzemFragment PrzemMatFragment = new FiszkiMatPrzemFragment();
    FiszkiMatWspolFragment WspMatFragemnt = new FiszkiMatWspolFragment();
    FiszkiMatOptykaFragment OptykaMatFragment = new FiszkiMatOptykaFragment();


    static final int MIN_DISTANCE = 150;
    static final int MIN_DISTANCE_MINUS = -150;
    static final String STATE_LEVEL = "sprawdzenie";

    int liczba2;
    private GestureDetectorCompat gestureDetector;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_przyklad);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-8124828420072466/9435660038");
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle("Fiszki Kinematyka");
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // gesty



        this.gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);

                sharedPreferences.edit().remove("liczba2").apply();
                sharedPreferences.edit().remove("liczba").apply();
                sharedPreferences.edit().remove("back").apply();
                sharedPreferences.edit().remove("current").apply();
                sharedPreferences.edit().remove("currentLiczba").apply();
                onBackPressed();
            }
        });


        // toast ktory pokazuje sie tylko raz //

        SharedPreferences prefs = this.getSharedPreferences(
                "com.clakestudio.pc.fizykor", Context.MODE_PRIVATE);
        boolean hasVisited = prefs.getBoolean("HAS_VISISTED_BEFORE", false);
        if (!hasVisited) {
            Toast.makeText(getApplicationContext(), "Przeciągnij palcem od lewej do prawej by zmienić fiszkę, prawej do lewej by cofnąć, przytrzymaj by wyświetlić odpowiedź",
                    Toast.LENGTH_LONG).show();
            prefs.edit().putBoolean("HAS_VISISTED_BEFORE", true).commit();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorAccentBackground));
        }
    }

    public void onStart() {
        super.onStart();
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Intent Kinema = getIntent();
        int liczba2 = Kinema.getIntExtra("liczba", 0);
        if (liczba2 == 0) {

            fragmentTransaction.add(R.id.fragment, myFragment);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Kinematyka");
        }
        if (liczba2 == 1) {


            fragmentTransaction.add(R.id.fragment, FiszkiDynamo);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Dynamika");
        }
        if (liczba2 == 2) {


            fragmentTransaction.add(R.id.fragment, FiszkiPraca);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki Praca,moc,energia");

        }

        if (liczba2 == 3) {


            fragmentTransaction.add(R.id.fragment, FiszkiBryla);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Bryła Sztywna");
        }
        if (liczba2 == 4) {


            fragmentTransaction.add(R.id.fragment, FiszkiTermo);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Termodynamika");
        }
        if (liczba2 == 5) {


            fragmentTransaction.add(R.id.fragment, FiszkiGrawi);
            myToolbar.setTitle("Fiszki | Grawitacja i kosmos");
            fragmentTransaction.commit();
        }
        if (liczba2 == 6) {

            fragmentTransaction.add(R.id.fragment, FiszkiDrgania);
            myToolbar.setTitle("Fiszki | Ruch Drgający");
            fragmentTransaction.commit();
        }
        if (liczba2 == 7) {

            fragmentTransaction.add(R.id.fragment, FiszkiMechaniczne);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Fale mechaniczne");
        }
        if (liczba2 == 8) {

            fragmentTransaction.add(R.id.fragment, FiszkiElektro);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Elektrostatyka");
        }
        if (liczba2 == 9) {

            fragmentTransaction.add(R.id.fragment, FiszkiStaly);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Prąd stały");
        }
        if (liczba2 == 10) {

            fragmentTransaction.add(R.id.fragment, FiszkiMagne);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Magnetyzm");
        }
        if (liczba2 == 11) {

            fragmentTransaction.add(R.id.fragment, FiszkiIndu);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Indukcja elektromagnetyczna");
        }
        if (liczba2 == 12) {

            fragmentTransaction.add(R.id.fragment, FiszkiPrzem);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Prąd przemienny");
        }
        if (liczba2 == 13) {

            fragmentTransaction.add(R.id.fragment, FiszkiOptyka);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Optyka");
        }
        if (liczba2 == 14) {

            fragmentTransaction.add(R.id.fragment, FiszkiWspl);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Fiszyka współczesna");
        }
        if (liczba2 == 20) {

            fragmentTransaction.add(R.id.fragment, KinMatFragment);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Kinematyka | Matura");
        }
        if (liczba2 == 21) {

            fragmentTransaction.add(R.id.fragment, DynMatFragment);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Dynamika | Matura");

        }
        if (liczba2 == 22) {

            fragmentTransaction.add(R.id.fragment, PracaMatFragment);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Praca,moc,energia | Matura");

        }
        if (liczba2 == 23) {

            fragmentTransaction.add(R.id.fragment, BrylaMatFragment);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Bryła sztywna | Matura");
        }
        if (liczba2 == 24) {

            fragmentTransaction.add(R.id.fragment, TermoMatFragment);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Termodynamika | Matura");

        }
        if (liczba2 == 25) {

            fragmentTransaction.add(R.id.fragment, GrawiMatFragment);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Grawitacja i kosmos | Matura");

        }
        if (liczba2 == 26) {

            fragmentTransaction.add(R.id.fragment, DrgMatFramgnet);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Ruch Drgający | Matura");
        }
        if (liczba2 == 27) {

            fragmentTransaction.add(R.id.fragment, MechMatFragment);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Fale mechaniczne | Matura");
        }
        if (liczba2 == 28) {

            fragmentTransaction.add(R.id.fragment, ElektroMatFragment);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Elektrostatyka | Matura");
        }
        if (liczba2 == 29) {

            fragmentTransaction.add(R.id.fragment, StalyMatFramgnet);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Prąd stały | Matura");
        }
        if (liczba2 == 30) {

            fragmentTransaction.add(R.id.fragment, MagneMatFragment);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Magnetyzm | Matura");
        }
        if (liczba2 == 31) {

            fragmentTransaction.add(R.id.fragment, InduMatFragment);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Indukcja elektromagnetyczna | Matura");
        }
        if (liczba2 == 32) {

            fragmentTransaction.add(R.id.fragment, PrzemMatFragment);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Prąd przemienny | Matura");
        }
        if (liczba2 == 33) {

            fragmentTransaction.add(R.id.fragment, OptykaMatFragment);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Optyka | Matura");
        }

        if (liczba2 == 34) {

            fragmentTransaction.add(R.id.fragment, FiszkiWspl);
            fragmentTransaction.commit();
            myToolbar.setTitle("Fiszki | Fizyka współczesna | Matura");
        }


    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Toast.makeText(getApplicationContext(), "Przeciągnij palcem z lewej do prawej by zmienić fiszkę, z prawej do lewej by cofnąć, przytrzymaj by wyświetlić odpowiedź",
                Toast.LENGTH_LONG).show();


        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {

        return false;
    }


    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {


        Intent Kinema = getIntent();
        int liczba2 = Kinema.getIntExtra("liczba", 0);

        if (liczba2 == 0) {
            myFragment.widzialnosc();
        } else if (liczba2 == 1) {
            FiszkiDynamo.widzialnosc();
        } else if (liczba2 == 2) {
            FiszkiPraca.widzialnosc();
        } else if (liczba2 == 3) {
            FiszkiBryla.widzialnosc();
        } else if (liczba2 == 4) {
            FiszkiTermo.widzialnosc();
        } else if (liczba2 == 5) {
            FiszkiGrawi.widzialnosc();
        } else if (liczba2 == 6) {
            FiszkiDrgania.widzialnosc();
        } else if (liczba2 == 7) {
            FiszkiMechaniczne.widzialnosc();
        } else if (liczba2 == 8) {
            FiszkiElektro.widzialnosc();
        } else if (liczba2 == 9) {
            FiszkiStaly.widzialnosc();
        } else if (liczba2 == 10) {
            FiszkiMagne.widzialnosc();
        } else if (liczba2 == 11) {
            FiszkiIndu.widzialnosc();
        } else if (liczba2 == 12) {
            FiszkiPrzem.widzialnosc();
        } else if (liczba2 == 13) {
            FiszkiOptyka.widzialnosc();
        } else if (liczba2 == 14) {
            FiszkiWspl.widzialnosc();
        } else if (liczba2 == 20) {
            KinMatFragment.widzialnosc();
        } else if (liczba2 == 21) {
            DynMatFragment.widzialnosc();
        } else if (liczba2 == 22) {
            PracaMatFragment.widzialnosc();
        } else if (liczba2 == 23) {
            BrylaMatFragment.widzialnosc();
        } else if (liczba2 == 24) {
            TermoMatFragment.widzialnosc();
        } else if (liczba2 == 25) {
            GrawiMatFragment.widzialnosc();
        } else if (liczba2 == 26) {
            DrgMatFramgnet.widzialnosc();
        } else if (liczba2 == 27) {
            MechMatFragment.widzialnosc();
        } else if (liczba2 == 28) {
            ElektroMatFragment.widzialnosc();
        } else if (liczba2 == 29) {
            StalyMatFramgnet.widzialnosc();
        } else if (liczba2 == 30) {
            MagneMatFragment.widzialnosc();
        } else if (liczba2 == 31) {
            InduMatFragment.widzialnosc();
        } else if (liczba2 == 32) {
            PrzemMatFragment.widzialnosc();
        } else if (liczba2 == 33) {
            OptykaMatFragment.widzialnosc();
        } else if (liczba2 == 34) {
            WspMatFragemnt.widzialnosc();
        }

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

        Intent Kinema = getIntent();

        SharedPreferences sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        float delta = motionEvent1.getX() - motionEvent.getX();
        if (motionEvent.getX() < motionEvent1.getX() && delta > MIN_DISTANCE) {

            sharedPreferences.edit().putInt("liczba", 0).apply();
            liczba2 = Kinema.getIntExtra("liczba", 0);
            sharedPreferences.edit().putInt("liczba2", liczba2).apply();
            sharedPreferences.edit().putBoolean("back", false).apply();
            fragmentTransaction.setCustomAnimations(R.animator.slide_in_up, R.animator.slide_out_up);
        } else if (motionEvent.getX() > motionEvent1.getX() && abs(delta) > MIN_DISTANCE) {
            sharedPreferences.edit().putBoolean("back", true).apply();
            fragmentTransaction.setCustomAnimations(R.animator.slide_out_up_reverse, R.animator.slide_in_up_reverse);

        }


        if (liczba2 == 0) {
            fragmentTransaction.detach(myFragment);
            fragmentTransaction.attach(myFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 1) {

            fragmentTransaction.detach(FiszkiDynamo);
            fragmentTransaction.attach(FiszkiDynamo);
            fragmentTransaction.commit();
        }
        if (liczba2 == 2) {

            fragmentTransaction.detach(FiszkiPraca);
            fragmentTransaction.attach(FiszkiPraca);
            fragmentTransaction.commit();
        }
        if (liczba2 == 3) {

            fragmentTransaction.detach(FiszkiBryla);
            fragmentTransaction.attach(FiszkiBryla);
            fragmentTransaction.commit();
        }
        if (liczba2 == 4) {

            fragmentTransaction.detach(FiszkiTermo);
            fragmentTransaction.attach(FiszkiTermo);
            fragmentTransaction.commit();
        }
        if (liczba2 == 5) {

            fragmentTransaction.detach(FiszkiGrawi);
            fragmentTransaction.attach(FiszkiGrawi);
            fragmentTransaction.commit();

        }
        if (liczba2 == 6) {

            fragmentTransaction.detach(FiszkiDrgania);
            fragmentTransaction.attach(FiszkiDrgania);
            fragmentTransaction.commit();
        }
        if (liczba2 == 7) {

            fragmentTransaction.detach(FiszkiMechaniczne);
            fragmentTransaction.attach(FiszkiMechaniczne);
            fragmentTransaction.commit();
        }
        if (liczba2 == 8) {

            fragmentTransaction.detach(FiszkiElektro);
            fragmentTransaction.attach(FiszkiElektro);
            fragmentTransaction.commit();
        }
        if (liczba2 == 9) {

            fragmentTransaction.detach(FiszkiStaly);
            fragmentTransaction.attach(FiszkiStaly);
            fragmentTransaction.commit();
        }
        if (liczba2 == 10) {

            fragmentTransaction.detach(FiszkiMagne);
            fragmentTransaction.attach(FiszkiMagne);
            fragmentTransaction.commit();
        }
        if (liczba2 == 11) {

            fragmentTransaction.detach(FiszkiIndu);
            fragmentTransaction.attach(FiszkiIndu);
            fragmentTransaction.commit();
        }
        if (liczba2 == 12) {

            fragmentTransaction.detach(FiszkiPrzem);
            fragmentTransaction.attach(FiszkiPrzem);
            fragmentTransaction.commit();
        }
        if (liczba2 == 13) {

            fragmentTransaction.detach(FiszkiOptyka);
            fragmentTransaction.attach(FiszkiOptyka);
            fragmentTransaction.commit();
        }
        if (liczba2 == 14) {

            fragmentTransaction.detach(FiszkiWspl);
            fragmentTransaction.attach(FiszkiWspl);
            fragmentTransaction.commit();
        }
        if (liczba2 == 20) {

            fragmentTransaction.detach(KinMatFragment);
            fragmentTransaction.attach(KinMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 21) {

            fragmentTransaction.detach(DynMatFragment);
            fragmentTransaction.attach(DynMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 22) {

            fragmentTransaction.detach(PracaMatFragment);
            fragmentTransaction.attach(PracaMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 23) {

            fragmentTransaction.detach(BrylaMatFragment);
            fragmentTransaction.attach(BrylaMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 24) {

            fragmentTransaction.detach(TermoMatFragment);
            fragmentTransaction.attach(TermoMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 25) {

            fragmentTransaction.detach(GrawiMatFragment);
            fragmentTransaction.attach(GrawiMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 26) {

            fragmentTransaction.detach(DrgMatFramgnet);
            fragmentTransaction.attach(DrgMatFramgnet);
            fragmentTransaction.commit();
        }
        if (liczba2 == 27) {

            fragmentTransaction.detach(MechMatFragment);
            fragmentTransaction.attach(MechMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 28) {

            fragmentTransaction.detach(ElektroMatFragment);
            fragmentTransaction.attach(ElektroMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 29) {

            fragmentTransaction.detach(StalyMatFramgnet);
            fragmentTransaction.attach(StalyMatFramgnet);
            fragmentTransaction.commit();
        }
        if (liczba2 == 30) {

            fragmentTransaction.detach(MagneMatFragment);
            fragmentTransaction.attach(MagneMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 31) {

            fragmentTransaction.detach(InduMatFragment);
            fragmentTransaction.attach(InduMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 32) {

            fragmentTransaction.detach(PrzemMatFragment);
            fragmentTransaction.attach(PrzemMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 33) {

            fragmentTransaction.detach(OptykaMatFragment);
            fragmentTransaction.attach(OptykaMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 34) {

            fragmentTransaction.detach(WspMatFragemnt);
            fragmentTransaction.attach(WspMatFragemnt);
            fragmentTransaction.commit();
        }


        return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Intent Kinema = getIntent();
        int liczba2 = Kinema.getIntExtra("liczba", 0);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.slide_in_up, R.animator.slide_out_up);

        if (liczba2 == 0) {

            fragmentTransaction.detach(myFragment);

            fragmentTransaction.commit();
        }
        if (liczba2 == 1) {

            fragmentTransaction.detach(FiszkiDynamo);

            fragmentTransaction.commit();
        }
        if (liczba2 == 2) {

            fragmentTransaction.detach(FiszkiPraca);

            fragmentTransaction.commit();
        }
        if (liczba2 == 3) {

            fragmentTransaction.detach(FiszkiBryla);

            fragmentTransaction.commit();
        }
        if (liczba2 == 4) {

            fragmentTransaction.detach(FiszkiTermo);

            fragmentTransaction.commit();
        }
        if (liczba2 == 5) {

            fragmentTransaction.detach(FiszkiGrawi);

            fragmentTransaction.commit();
        }
        if (liczba2 == 6) {

            fragmentTransaction.detach(FiszkiDrgania);

            fragmentTransaction.commit();
        }
        if (liczba2 == 7) {

            fragmentTransaction.detach(FiszkiMechaniczne);

            fragmentTransaction.commit();
        }
        if (liczba2 == 8) {

            fragmentTransaction.detach(FiszkiElektro);

            fragmentTransaction.commit();
        }
        if (liczba2 == 9) {

            fragmentTransaction.detach(FiszkiStaly);

            fragmentTransaction.commit();
        }
        if (liczba2 == 10) {

            fragmentTransaction.detach(FiszkiMagne);

            fragmentTransaction.commit();
        }
        if (liczba2 == 11) {

            fragmentTransaction.detach(FiszkiIndu);

            fragmentTransaction.commit();
        }
        if (liczba2 == 12) {

            fragmentTransaction.detach(FiszkiPrzem);

            fragmentTransaction.commit();
        }
        if (liczba2 == 13) {

            fragmentTransaction.detach(FiszkiOptyka);

            fragmentTransaction.commit();
        }
        if (liczba2 == 14) {

            fragmentTransaction.detach(FiszkiWspl);

            fragmentTransaction.commit();
        }
        if (liczba2 == 20) {

            fragmentTransaction.detach(KinMatFragment);

            fragmentTransaction.commit();
        }
        if (liczba2 == 21) {

            fragmentTransaction.detach(DynMatFragment);

            fragmentTransaction.commit();
        }
        if (liczba2 == 22) {

            fragmentTransaction.detach(PracaMatFragment);

            fragmentTransaction.commit();
        }
        if (liczba2 == 23) {

            fragmentTransaction.detach(BrylaMatFragment);

            fragmentTransaction.commit();
        }
        if (liczba2 == 24) {

            fragmentTransaction.detach(TermoMatFragment);

            fragmentTransaction.commit();
        }
        if (liczba2 == 25) {

            fragmentTransaction.detach(GrawiMatFragment);

            fragmentTransaction.commit();
        }
        if (liczba2 == 26) {

            fragmentTransaction.detach(DrgMatFramgnet);

            fragmentTransaction.commit();
        }
        if (liczba2 == 27) {

            fragmentTransaction.detach(MechMatFragment);

            fragmentTransaction.commit();
        }
        if (liczba2 == 28) {

            fragmentTransaction.detach(ElektroMatFragment);

            fragmentTransaction.commit();
        }
        if (liczba2 == 29) {

            fragmentTransaction.detach(StalyMatFramgnet);

            fragmentTransaction.commit();
        }
        if (liczba2 == 30) {

            fragmentTransaction.detach(MagneMatFragment);

            fragmentTransaction.commit();
        }
        if (liczba2 == 31) {

            fragmentTransaction.detach(InduMatFragment);

            fragmentTransaction.commit();
        }
        if (liczba2 == 32) {

            fragmentTransaction.detach(PrzemMatFragment);

            fragmentTransaction.commit();
        }
        if (liczba2 == 33) {

            fragmentTransaction.detach(OptykaMatFragment);

            fragmentTransaction.commit();
        }
        if (liczba2 == 34) {

            fragmentTransaction.detach(WspMatFragemnt);

            fragmentTransaction.commit();
        }

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Intent Kinema = getIntent();
        int liczba2 = Kinema.getIntExtra("liczba", 0);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.slide_in_up, R.animator.slide_out_up);
        if (liczba2 == 0) {

            fragmentTransaction.attach(myFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 1) {

            fragmentTransaction.attach(FiszkiDynamo);
            fragmentTransaction.commit();
        }
        if (liczba2 == 2) {

            fragmentTransaction.attach(FiszkiPraca);
            fragmentTransaction.commit();
        }
        if (liczba2 == 3) {

            fragmentTransaction.attach(FiszkiBryla);
            fragmentTransaction.commit();
        }
        if (liczba2 == 4) {

            fragmentTransaction.attach(FiszkiTermo);
            fragmentTransaction.commit();
        }
        if (liczba2 == 5) {

            fragmentTransaction.attach(FiszkiGrawi);
            fragmentTransaction.commit();
        }
        if (liczba2 == 6) {

            fragmentTransaction.attach(FiszkiDrgania);
            fragmentTransaction.commit();
        }
        if (liczba2 == 7) {
            fragmentTransaction.attach(FiszkiMechaniczne);
            fragmentTransaction.commit();
        }
        if (liczba2 == 8) {

            fragmentTransaction.attach(FiszkiElektro);
            fragmentTransaction.commit();
        }
        if (liczba2 == 9) {
            fragmentTransaction.attach(FiszkiStaly);
            fragmentTransaction.commit();
        }
        if (liczba2 == 10) {

            fragmentTransaction.attach(FiszkiMagne);
            fragmentTransaction.commit();
        }
        if (liczba2 == 11) {

            fragmentTransaction.attach(FiszkiIndu);
            fragmentTransaction.commit();
        }
        if (liczba2 == 12) {

            fragmentTransaction.attach(FiszkiPrzem);
            fragmentTransaction.commit();
        }
        if (liczba2 == 13) {

            fragmentTransaction.attach(FiszkiOptyka);
            fragmentTransaction.commit();
        }
        if (liczba2 == 14) {
            fragmentTransaction.attach(FiszkiWspl);
            fragmentTransaction.commit();
        }
        if (liczba2 == 20) {

            fragmentTransaction.attach(KinMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 21) {
            fragmentTransaction.attach(DynMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 22) {

            fragmentTransaction.attach(PracaMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 23) {

            fragmentTransaction.attach(BrylaMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 24) {

            fragmentTransaction.attach(TermoMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 25) {

            fragmentTransaction.attach(GrawiMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 26) {

            fragmentTransaction.attach(DrgMatFramgnet);
            fragmentTransaction.commit();
        }
        if (liczba2 == 27) {

            fragmentTransaction.attach(MechMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 28) {

            fragmentTransaction.attach(ElektroMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 29) {

            fragmentTransaction.attach(StalyMatFramgnet);
            fragmentTransaction.commit();
        }
        if (liczba2 == 30) {
            fragmentTransaction.attach(MagneMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 31) {

            fragmentTransaction.attach(InduMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 32) {
            fragmentTransaction.attach(PrzemMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 33) {
            fragmentTransaction.attach(OptykaMatFragment);
            fragmentTransaction.commit();
        }
        if (liczba2 == 34) {
            fragmentTransaction.attach(WspMatFragemnt);
            fragmentTransaction.commit();
        }


    }


}

