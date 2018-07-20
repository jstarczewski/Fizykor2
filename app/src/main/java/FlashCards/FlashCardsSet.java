package FlashCards;

import java.util.HashMap;
import java.util.Random;

public class FlashCardsSet {

    private HashMap<Integer, FlashCard> flashCardHashMap = new HashMap<>();
    private int maxKey;
    private Random random;

    FlashCardsSet(int maxKey) {
            this.maxKey = maxKey;
            random = new Random();
    }

    public void add(int key ,String name, String answer) {
        FlashCard flashCard = new FlashCard(name, answer);
        flashCardHashMap.put(key, flashCard);
    }
    public FlashCard get(int key) {
        return flashCardHashMap.get(key);
    }
    public FlashCard getRandomFlashCard() {
        return flashCardHashMap.get(random.nextInt(maxKey));
    }

}
