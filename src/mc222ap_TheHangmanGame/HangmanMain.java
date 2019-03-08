package mc222ap_TheHangmanGame;

/**
 * Starts a new game and allows the player to play it.
 *
 * @author Melina Cirverius
 * @version 1.0
 */

public class HangmanMain {

    public static void main(String[] args) {

        Word word = new Word();
        Hangman game = new Hangman(word.getWordToGuess());
        game.startMenu();
    }
}
