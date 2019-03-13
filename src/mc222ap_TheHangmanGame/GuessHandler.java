package mc222ap_TheHangmanGame;

import java.util.ArrayList;

public class GuessHandler {

    private final ArrayList<String> guessList = new ArrayList<>();
    private final ArrayList<String> guessedLetters = new ArrayList<>();
    private ArrayList<String> letterList = new ArrayList<>();

    // The number of guesses the player gets
    private int guesses = 10;
    private int correctLetters = 0;
    boolean wrongLetter = true;
    private String wordToGuess;

    public GuessHandler(final String wordToGuess)
    {
        this.wordToGuess = wordToGuess;
    }

    public String getWordToGuess()
    {
        return wordToGuess;
    }

    public ArrayList<String> getGuessList()
    {
        return guessList;
    }

    public ArrayList<String> getGuessedLetters()
    {
        return guessedLetters;
    }

    public int getGuesses()
    {
        return guesses;
    }

    public int getCorrectLetters()
    {
        return correctLetters;
    }

    public boolean isWrongLetter()
    {
        return wrongLetter;
    }

    public ArrayList<String> getLetterList()
    {
        return letterList;
    }

    // TODO implement check if the player types more than one letter.

    /**
     * Checks if the letter guessed by the player is present in the current word.
     * Also checks if the letter has already been guessed.
     */
    boolean evaluateGuess(String guess, boolean playing)
    {
        if (playing)
        {
            if (!wordToGuess.contains(guess))
            {
                guessedLetters.add(guess);
                for (int i = 0; i < letterList.size(); i++)
                {
                    if (letterList.get(i).equals(guess))
                    {
                        guessList.set(i, guess);
                        wrongLetter = false;
                        correctLetters++;
                    }
                }
                if (wrongLetter)
                {
                    System.out.println("Incorrect letter.");
                }
                guesses--;
                return true;
            } else
            {
                System.out.println("You've already guessed " + guess + ". Guess again!");
                return false;
            }
        }
        return true;
    }


    /**
     * Takes each letter in the word to guess and adds it to a list.
     * Also adds an underscore per letter to the guess list.
     *
     * @return ArrayList with each letter.
     */

    ArrayList<String> createUnderscores()
    {
        for (int i = 0; i < wordToGuess.length(); i++)
        {
            letterList.add(String.valueOf(wordToGuess.charAt(i)));
            guessList.add("_ ");
        }
        return letterList;
    }

    String prettyPrintedList(final ArrayList<String> list)
    {
        return list.toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");
    }

    public String getPrettyLetterList()
    {
        return prettyPrintedList(letterList);
    }

    public String getPrettyGuess()
    {
        return prettyPrintedList(guessList);
    }

    public String getPrettyGuessedLetter()
    {
        return prettyPrintedList(guessedLetters);
    }

    public void reset()
    {
        letterList.clear();
        guessList.clear();
        guesses = 10;
        correctLetters = 0;
        guessedLetters.clear();
    }
}
