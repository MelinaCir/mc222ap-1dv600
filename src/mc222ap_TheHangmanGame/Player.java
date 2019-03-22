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

    public Player(String name)
    {
        username = name;
    }

    public String getUsername()
    {
        return username;
    }

}
