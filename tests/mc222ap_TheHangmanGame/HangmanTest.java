package mc222ap_TheHangmanGame;

import jdk.nashorn.internal.ir.annotations.Ignore;

@Ignore
class HangmanTest {

//    @Test
//    void shouldCreateRightNumberOfUnderscores() {
//        HangmanGame sut = new HangmanGame("LEGO");
//        sut.createUnderscores();
//
//        int expected = 4;
//        int actual = sut.getGuessList().size();
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void shouldCreateTypeUnderscore() {
//        HangmanGame sut = new HangmanGame("LEGO");
//        sut.createUnderscores();
//
//        String expected = "_ ";
//        String actual = sut.getGuessList().get(0);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void shouldFindCorrectGuess() {
//        HangmanGame sut = new HangmanGame("LEGO");
//        sut.createUnderscores();
//        sut.playing = true;
//        sut.inTesting = true;
//
//        String guess = "L";
//        sut.evaluateGuess(guess);
//
//        String expected = "L _  _  _ ";
//        String actual = sut.prettyPrintedList(sut.getGuessList());
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void shouldNotFindIncorrectGuess() {
//        HangmanGame sut = new HangmanGame("LEGO");
//        sut.createUnderscores();
//        sut.inTesting = true;
//        sut.playing = true;
//
//        String guess = "A";
//        sut.evaluateGuess(guess);
//
//        String expected = "_  _  _  _ ";
//        String actual = sut.prettyPrintedList(sut.getGuessList());
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void shouldDrawFirstPartOfHangman() {
//        HangmanGame sut = new HangmanGame("LEGO");
//        sut.createUnderscores();
//        sut.inTesting = true;
//        sut.playing = true;
//
//        String guess = "A";
//        sut.evaluateGuess(guess);
//
//        String expected = "__________";
//        String actual = sut.drawHangman();
//
//        assertEquals(expected, actual);
//    }
}