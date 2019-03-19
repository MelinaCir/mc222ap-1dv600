package mc222ap_TheHangmanGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuessHandlerTest {


    @Test
    void shouldCreateRightNumberOfUnderscores()
    {
        GuessHandler sut = new GuessHandler("LEGO");
        sut.createUnderscores();

        int expected = 4;
        int actual = sut.getLetterList().size();

        assertEquals(expected, actual);
    }

    @Test
    void shouldCreateTypeUnderscore()
    {
        GuessHandler sut = new GuessHandler("LEGO");
        sut.createUnderscores();

        String expected = "_ ";
        String actual = sut.getGuessList().get(0);

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindCorrectGuess()
    {
        GuessHandler sut = new GuessHandler("LEGO");
        sut.createUnderscores();

        String guess = "L";
        sut.evaluateGuess(guess, true);

        String expected = "L _  _  _ ";
        String actual = sut.prettyPrintedList(sut.getGuessList());

        assertEquals(expected, actual);

    }

    @Test
    void shouldNotFindIncorrectGuess()
    {
        GuessHandler sut = new GuessHandler("LEGO");
        sut.createUnderscores();

        String guess = "A";
        sut.evaluateGuess(guess, true);

        String expected = "_  _  _  _ ";
        String actual = sut.prettyPrintedList(sut.getGuessList());

        assertEquals(expected, actual);
    }
}