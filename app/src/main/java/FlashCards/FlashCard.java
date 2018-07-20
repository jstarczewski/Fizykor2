package FlashCards;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Objects;

public class FlashCard {

    private String name;
    private String answer;

    public FlashCard(String name, String answer) {
        this.answer = answer;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public String getAnswer() {
        return this.answer;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    @Override
    public String toString() {
        return "Nazwa " + name + " Odpowiedź " + answer;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlashCard flashCard = (FlashCard) o;
        return Objects.equals(name, flashCard.name) &&
                Objects.equals(answer, flashCard.answer);
    }
}
