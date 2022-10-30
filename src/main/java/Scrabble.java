import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
public class Scrabble {
    private String letter;

    private HashMap<Character, Integer> pointSystem = new HashMap<>();
    private ArrayList<Character> lettersWithDoubleWord = new ArrayList<>();
    private boolean doubleWordScore;

    //Constructor
    public Scrabble(String letter)
    {
        this.letter = letter;
        setPointSystem();
    }

    public Scrabble(String letter, Character[] lettersWithDoubleWord, boolean doubleWordScore)
    {
        this.letter = letter;
        this.lettersWithDoubleWord.addAll(Arrays.asList(lettersWithDoubleWord));
        this.doubleWordScore = doubleWordScore;
        setPointSystem();
    }
        public int score () {
            checkLetter();
            int score = setScoreLetters(this.letter);
            score = setScoreForDoubleWord(lettersWithDoubleWord, score);
            score = doubleWord(score);
            return score;
        }

        public void checkLetter () {
            if (this.letter == null) {
                this.letter = "";
            } else {
                this.letter = letter.toUpperCase();
            }
        }

        private int setScoreLetters (String str){
            int score = 0;
            for (int i = 0, n = str.length(); i < n; i++) {
                score += getScoreForLetter(str.charAt(i));
            }
            return score;
        }


        private int getScoreForLetter (Character letter)
        {
            return pointSystem.get((new Character(letter)));
        }
        private int doubleWord (int score)
        {
            if (this.doubleWordScore == true)
            {
                score *= 2;
            }
            return score;
        }

    private int setScoreForDoubleWord(ArrayList<Character> letters, int score)
    {
        for (Character letter : letters) {
            score += getScoreForLetter(letter);
        }
        return score;
    }



        private void setPointSystem () {
            //Empty words
            for (char c : new char[]{}) {
                this.pointSystem.put(c, 0);
            }
            for (char c : new char[]{'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'}) {
                this.pointSystem.put(c, 1);
            }
            for (char c1 : new char[]{'D', 'G'}) {
                this.pointSystem.put(c1, 2);
            }
            for (char c : new char[]{'B', 'C', 'M', 'P'}) {
                this.pointSystem.put(c, 3);
            }
            for (char c : new char[]{'F', 'H', 'V', 'W', 'Y'}) {
                this.pointSystem.put(c, 4);
            }
            for (char c : new char[]{'K'}) {
                this.pointSystem.put(c, 5);
            }
            for (char c : new char[]{'J', 'X'}) {
                this.pointSystem.put(c, 8);
            }
            for (char c : new char[]{'Q', 'Z'}) {
                this.pointSystem.put(c, 10);
            }
        }
    }
