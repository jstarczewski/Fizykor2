package com.clakestudio.pc.fizykor;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import FlashCards.FlashCard;
import FlashCards.FlashCardsFormatter;
import FlashCards.FlashCardsReader;
import FlashCards.FlashCardsSet;

import static com.clakestudio.pc.fizykor.ActivityTest.MIN_DISTANCE;
import static java.lang.Math.abs;

public class FlashCardsActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    FlashCardsFragment flashCardsFragment = new FlashCardsFragment();


    static final int MIN_DISTANCE = 150;
    static final int MIN_DISTANCE_MINUS = -150;
    static final String STATE_LEVEL = "sprawdzenie";

    private GestureDetectorCompat gestureDetector;
    FlashCardsSet flashCardsSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_cards);

        gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);

        String flashCardsTitle = getIntent().getStringExtra("flashCards");
        if (flashCardsTitle==null)
            flashCardsTitle = "dynamika-mat.txt";

        FlashCardsFormatter flashCardsFormatter = FlashCardsReader.readPlainFlashCards(flashCardsTitle, this);
        flashCardsSet = flashCardsFormatter.getFormattedFlashCardsSet("\\s@\\s");


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment, flashCardsFragment);
        fragmentTransaction.commit();
        myToolbar.setTitle("Fiszki | Dynamika");


    }

    public FlashCard getRandomFlashCard() {
        return flashCardsSet.getRandomFlashCard();
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {

        Toast.makeText(getApplicationContext(), "Przeciągnij palcem z lewej do prawej by zmienić fiszkę, z prawej do lewej by cofnąć, przytrzymaj by wyświetlić odpowiedź", Toast.LENGTH_SHORT).show();
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
        return false;
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
        flashCardsFragment.showWebView();
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {


        float delta = motionEvent1.getX() - motionEvent.getX();

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        if (motionEvent.getX() < motionEvent1.getX() && delta > MIN_DISTANCE) {
            fragmentTransaction.setCustomAnimations(R.animator.slide_in_up, R.animator.slide_out_up);

        } else if (motionEvent.getX() > motionEvent1.getX() && abs(delta) > MIN_DISTANCE) {

        }

        fragmentTransaction.detach(flashCardsFragment);
        fragmentTransaction.attach(flashCardsFragment);
        fragmentTransaction.commit();
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
