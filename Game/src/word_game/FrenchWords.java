package word_game;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public  class FrenchWords {
    FrenchWords() {
        try {
            listOfWords();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public List<String> listOfWords() throws URISyntaxException {
        List<String> allFrenchWords = new ArrayList<>();
        //change path before compiling
        BufferedReader bufferedReader;
        //FileReader fileReader;
        String line;

        {
            try {
                //correct way to run the file
                //fileReader = new FileReader(file);
                InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/dictionary.txt");
                bufferedReader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                line = bufferedReader.readLine();
                while(line != null) {
                    line = bufferedReader.readLine();
                    allFrenchWords.add(line);
                }
                //fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //return allFrenchWords.stream().filter(x->x!= null && x.length()==5).collect(Collectors.toList());
        return allFrenchWords;
    }



}