package FlashCards;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FlashCardsReader {

    public static FlashCardsFormatter readPlainFlashCards(String path, Activity activity) {
        ArrayList<String> rawFlashCards = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(activity.getAssets().open(path)));
            String rawFishCard;
            while ((rawFishCard = bufferedReader.readLine()) != null) {
                rawFlashCards.add(rawFishCard);
            }
        } catch (IOException e) {
            System.err.println("Unable to read File");
        }
        return new FlashCardsFormatter(rawFlashCards);
    }


}
