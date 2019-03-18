package mc222ap_TheHangmanGame;

public class Hangman {

    private final String stakePart = "\t\t\t            []\n";
    private final String topPole = "\t\t   _____________\t\n";
    private final String ground = "  ______________________[]_____";

    private final String stake = stakePart + stakePart + stakePart + stakePart + stakePart + stakePart + stakePart +
            stakePart + stakePart + stakePart + stakePart + stakePart + stakePart + stakePart +
            "  ______________________[]_____";

    private final String pole = topPole +
            stakePart + stakePart + stakePart + stakePart + stakePart + stakePart + stakePart +
            stakePart + stakePart + stakePart + stakePart + stakePart + stakePart + stakePart +
            ground;

    private final String support = topPole +
            "\t\t           \\\t[]\n" +
            "\t\t      \t    \\ \t[]\n" +
            "             \t     \\ \t[]\n" +
            "               \t      \\ []\n" +
            "                \t   \\[]\n" +
            stakePart + stakePart + stakePart + stakePart + stakePart +
            stakePart + stakePart + stakePart + stakePart +
            ground;

    private final String rope = topPole +
            "\t\t  |        \\\t[]\n" +
            "\t\t  |   \t    \\ \t[]\n" +
            "\t\t  |   \t     \\\t[]\n" +
            "              \t      \\ []\n" +
            "              \t       \\[]\n" +
            stakePart + stakePart + stakePart + stakePart + stakePart + stakePart +
            stakePart + stakePart + stakePart + stakePart + stakePart +
            ground;

    private final String noose = topPole +
            "\t\t  |        \\\t[]\n" +
            "\t\t  |   \t    \\ \t[]\n" +
            "       ___|__\t     \\ \t[]\n" +
            "      /      \\ \t      \\ []\n" +
            "     |        |\t       \\[]\n" +
            "     |        |\t        []\n" +
            "      \\______/\t        []\n" +
            stakePart + stakePart + stakePart + stakePart +
            stakePart + stakePart + stakePart + stakePart + stakePart +
            ground;

    private final String head = topPole +
            "\t\t  |        \\\t[]\n" +
            "\t\t  |   \t    \\ \t[]\n" +
            "        __|___\t     \\\t[]\n" +
            "       / _[]_ \\ \t  \\ []\n" +
            "      | |x  x| |\t   \\[]\n" +
            "      | |____| |\t    []\n" +
            "       \\__[]__/\t        []\n" +
            stakePart + stakePart + stakePart + stakePart +
            stakePart + stakePart + stakePart +
            ground;

    private final String body = topPole +
            "\t\t  |        \\\t[]\n" +
            "\t\t  |   \t    \\ \t[]\n" +
            "        __|___\t     \\\t[]\n" +
            "       / _[]_ \\ \t  \\ []\n" +
            "      | |x  x| |\t   \\[]\n" +
            "      | |____| |\t    []\n" +
            "       \\__[]__/\t        []\n" +
            "        /    \\          []\n" +
            "        |    |          []\n" +
            "        |____|\t        []\n" +
            stakePart + stakePart + stakePart + stakePart +
            ground;

    private final String arms = topPole +
            "\t\t  |        \\\t[]\n" +
            "\t\t  |   \t    \\ \t[]\n" +
            "        __|___\t     \\\t[]\n" +
            "       / _[]_ \\ \t  \\ []\n" +
            "      | |x  x| |\t   \\[]\n" +
            "      | |____| |\t    []\n" +
            "       \\__[]__/\t        []\n" +
            "       //    \\\\         []\n" +
            "      //|    |\\\\        []\n" +
            "        |____|\t        []\n" +
            stakePart + stakePart + stakePart + stakePart +
            ground;

    private final String hangman = topPole +
            "\t\t  |        \\\t[]\n" +
            "\t\t  |   \t    \\ \t[]\n" +
            "        __|___\t     \\\t[]\n" +
            "       / _[]_ \\ \t  \\ []\n" +
            "      | |x  x| |\t   \\[]\n" +
            "      | |____| |\t    []\n" +
            "       \\__[]__/\t        []\n" +
            "       //    \\\\         []\n" +
            "      //|    |\\\\        []\n" +
            "        |____|\t        []\n" +
            "        | || |\t\t    []\n" +
            "        | || |          []\n" +
            "       [__][__]         []\n" +
            stakePart + ground;

    private int line = 0;
    private String print;

    public Hangman(int wrongGuess)
    {
        line = wrongGuess;
    }

    public String drawPart()
    {
        if (line == 1)
        {
            return ground;
        } else if (line == 2)
        {
            return stake;
        } else if (line == 3)
        {
            return pole;
        } else if (line == 4)
        {
            return support;
        } else if (line == 5)
        {
            return rope;
        } else if (line == 6)
        {
            return noose;
        } else if (line == 7)
        {
            return head;
        } else if (line == 8)
        {
            return body;
        } else if (line == 9)
        {
            return arms;
        } else
        {
            return hangman;
        }
    }

    public String drawEnd()
    {
        return hangman;
    }
}
