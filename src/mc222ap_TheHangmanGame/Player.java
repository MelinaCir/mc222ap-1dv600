package mc222ap_TheHangmanGame;

/**
 * Class Player creates an instance representing a player.
 *
 * @author Melina Cirverius
 * @version 1.0
 */
public class Player {

    // The name of the player.
    private String username;

    // The number of correct guesses the player has in current round.
    private int correctGuesses = 0;

    // The number of correct words guessed/rounds completed.
    private int rounds = 0;

    public Player(String name)
    {
        username = name;
    }

    public String getUsername()
    {
        return username;
    }

    public int getCorrectGuesses()
    {
        return correctGuesses;
    }

    public void addCorrectGuess()
    {
        correctGuesses++;
    }

    public int getRounds()
    {
        return rounds;
    }
}
