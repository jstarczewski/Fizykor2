package com.clakestudio.pc.fizykor;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class FlashCardsActivity extends AppCompatActivity {

    FlashCardsFragment flashCardsFragment = new FlashCardsFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_cards);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment, flashCardsFragment);
        fragmentTransaction.commit();
        myToolbar.setTitle("Fiszki | Dynamika");



    }
}
