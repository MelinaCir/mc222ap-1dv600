package mc222ap_TheHangmanGame;

/**
 * Class Hangman creates a representation of a hangman game.
 *
 * @author Melina Cirverius
 * @version 1.0
 */
public class Hangman {

    // The word to be guessed
    private String word;

    // The number of guesses the player gets
    private int guesses = 10;

    /**
     * Returns the number of guesses left in current round.
     *
     * @return int of the number of guesses.
     */
    public int getGuesses(){
        return guesses;
    }

    /**
     * Sets up a new game with a random selected word and presents this to the player as underscores.
     *
     * @param words - the file to read a random word from.
     */
    public void startGame(File words){

    }

    /**
     * Checks if the letter guessed by the player is present in the current word.
     *
     * @return boolean - true if letter is present in word.
     */
    private boolean evaluteGuess(){

    }

    /**
     * Updates word if guess was correct and displays the current state of the word as well as current number of guesses.
     */
    private void updateWord(){

    }

    /**
     * Draws next part of the hangman if the guess was incorrect.
     */
    private void drawHangman(){

    }

    /**
     * Displays game over if the player has failed to guess the word. Gives the option to start a new game.
     */
    private void gameOver(){

    }

    /**
     * Displays result of round if player has guessed the whole word correctly.
     * Also gives the option to start new round, or end game.
     */
    private void roundWon(){

    }

    /**
     * Checks if the player is out of guesses, and in that case calls game over.
     */
    private void guessesLeft() {

    }

    /**
     * Checks how many letters are left to guess in current word, if none calls round won.
     */
    private void lettersLeft() {

    }
}
