package mc222ap_TheHangmanGame;

import java.util.ArrayList;

/**
 * Class GuessHandler handles everything guessrelated in the hangman game.
 *
 * @author Melina Cirverius
 * @version 1.1
 */
public class GuessHandler {

    private final ArrayList<String> guessList = new ArrayList<>();
    private final ArrayList<String> guessedLetters = new ArrayList<>();
    private ArrayList<String> letterList = new ArrayList<>();
    private Hangman hangman;

    private int guesses = 10;
    private int correctLetters = 0;
    private int wrongGuesses = 0;
    boolean wrongLetter = true;
    private String wordToGuess;

    public GuessHandler(final String wordToGuess)
    {
        this.wordToGuess = wordToGuess;
    }

    /**
     * Checks if the letter guessed by the player is present in the current word.
     * Also checks if the letter has already been guessed.
     */
    boolean evaluateGuess(String guess, boolean playing)
    {
        if (playing)
        {
            System.out.println("---------------------------------------");
            wrongLetter = true;
            if (!guessedLetters.contains(guess))
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
                    System.out.println("\nIncorrect letter.");
                    wrongGuesses++;
                    if (guesses > 1)
                    {
                        hangman = new Hangman(wrongGuesses);
                        System.out.println(hangman.drawPart());
                    }
                }
                guesses--;
                return true;
            } else
            {
                System.out.println("\nYou've already guessed " + guess + ". Guess again!");
                return false;
            }
        } else
        {
            return false;
        }
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

    public void reset()
    {
        letterList.clear();
        guessList.clear();
        guesses = 10;
        correctLetters = 0;
        wrongGuesses = 0;
        guessedLetters.clear();
    }

    public int getGuesses()
    {
        return guesses;
    }

    public int getCorrectLetters()
    {
        return correctLetters;
    }

    public int getWrongGuesses()
    {
        return wrongGuesses;
    }

    public ArrayList<String> getLetterList()
    {
        return letterList;
    }

    public ArrayList<String> getGuessList()
    {
        return guessList;
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


}
