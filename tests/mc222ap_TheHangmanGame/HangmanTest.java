package mc222ap_TheHangmanGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HangmanTest {

    @Test
    void shouldDrawFirstPart()
    {
        Hangman sut = new Hangman(1);

        String expected = "  ______________________[]_____";
        String actual = sut.drawPart();

        assertEquals(expected, actual);
    }

    @Test
    void shouldDrawSecondPartOnSecondWrongGuess()
    {
        GuessHandler guessHandler = new GuessHandler("LEGO");
        guessHandler.createUnderscores();

        String guess = "A";
        guessHandler.evaluateGuess(guess, true);
        String guess2 = "B";
        guessHandler.evaluateGuess(guess2, true);

        Hangman sut = new Hangman(guessHandler.getWrongGuesses());
        final String stakePart = "\t\t\t            []\n";

        String expected = stakePart + stakePart + stakePart + stakePart + stakePart + stakePart + stakePart +
                stakePart + stakePart + stakePart + stakePart + stakePart + stakePart + stakePart +
                "  ______________________[]_____";

        String actual = sut.drawPart();

        assertEquals(expected, actual);
    }

    @Test
    void shouldDrawHangman()
    {
        Hangman sut = new Hangman(10);

        String expected = "\t\t   _____________\t\n" +
                "\t\t  |        \\\t[]\n" +
                "\t\t  |   \t    \\ \t[]\n" +
                "          |   \t     \\\t[]\n" +
                "         _[]_   \t  \\ []\n" +
                "        |x  x|  \t   \\[]\n" +
                "        |____|  \t    []\n" +
                "        _|==|_          []\n" +
                "       //    \\\\         []\n" +
                "      //|    |\\\\        []\n" +
                "        |____|\t        []\n" +
                "        | || |\t\t    []\n" +
                "        | || |          []\n" +
                "       [__][__]         []\n" +
                "\t\t\t            []\n" +
                "  ______________________[]_____";

        String actual = sut.drawPart();

        assertEquals(expected, actual);
    }
}