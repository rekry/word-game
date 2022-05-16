package word_game;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;

public class RandomWord {
    RandomWord() {
    }

    Random rand = new Random();
    List<String> s;

    {
        try {
            s = new FrenchWords().listOfWords();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public String getWord() {
        return s.get(rand.nextInt(s.size()));
    }
}
