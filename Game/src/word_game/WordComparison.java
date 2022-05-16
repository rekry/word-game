package word_game;

public class WordComparison {
    WordComparison(){
    }
    RandomWord randomWord = new RandomWord();
    String word = randomWord.getWord();
    int wordSize = word.length();
    char[] wordSplited = wordSplit(word);

    public int checkWord(char guessedWord,int index) {
        //color coded
        return  checkChar(guessedWord,wordSplited,index);
    }

    public String results() {
         return (this.word);
    }

    public char[] wordSplit(String c) {
        return c.toCharArray();
    }

    public int checkChar(char c,char[] word,int index){
        for (int i =0;i<wordSize;i++) {
            if (word[i] == c && i == index) {
               return 1;
            }
            if (word[i] == c && i != index && c == word[index]) {
                //green
                return 1;
            }
            if (word[i] == c && i != index ) {
                //green
                return 2;
            }
        }
        return 3;
    }

    public boolean checkWin(char[] c) {
        String str;
        StringBuilder sb = new StringBuilder();
        for (char i:c) {
            sb.append(i);
        }
        str = sb.toString();
        return word.equals(str);
    }
}
