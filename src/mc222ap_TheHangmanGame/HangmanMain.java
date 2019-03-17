package mc222ap_TheHangmanGame;

/**
 * Starts a new game and allows the player to play it.
 *
 * @author Melina Cirverius
 * @version 1.0
 */

public class HangmanMain {

    public static void main(String[] args)
    {

        Word word = new Word();
        GuessHandler guessHandler = new GuessHandler(word.getWordToGuess());
        System.out.println("list atm " + guessHandler.getPrettyGuessedLetter());
        HangmanGame game = new HangmanGame(guessHandler);
        game.startMenu();


    }
}
