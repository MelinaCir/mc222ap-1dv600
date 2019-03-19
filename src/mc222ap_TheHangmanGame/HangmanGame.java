package mc222ap_TheHangmanGame;

import java.util.Scanner;

/**
 * Class HangmanGame creates a representation of a hangman game.
 *
 * @author Melina Cirverius
 * @version 1.0
 */
public class HangmanGame {

    private Player theGamer;
    private GuessHandler guessHandler;
    private Hangman hangman = new Hangman(0);

    //Game menu
    private final String quitGame = "QUIT";
    private final String backToMenu = "MENU";
    private final String yes = "Y";
    private final String no = "N";

    boolean playing = false;
    private Scanner scanner;


    public HangmanGame()
    {
    }

    void startMenu()
    {
        System.out.println("\nWelcome to Hangman v1.0");
        final GameMenu menu = new GameMenu();

        final Scanner scanner = new Scanner(System.in);
        final String choice = scanner.next();

        if (choice.equals(menu.getStartOption()))
        {
            System.out.println("(Type 'Quit' to quit, 'Menu' to return to menu)");

            System.out.print("\nType in a user name: ");

            final Scanner scanner1 = new Scanner(System.in);
            final String username = scanner1.next();

            if (username.toUpperCase().equals(quitGame))
            {
                endGame();
            } else if (username.toUpperCase().equals(backToMenu))
            {
                startMenu();
            } else
            {
                theGamer = new Player(username);
                System.out.println("\nHello " + theGamer.getUsername());
            }
            setUpGame();
            scanner1.close();
        } else if (choice.equals(menu.getQuitOption()))
        {
            endGame();
        } else
        {
            System.out.println("\nInvalid menu choice.");
            startMenu();
        }
        scanner.close();
    }

    // TODO Complete options for username and difficulty-level
    private void setUpGame()
    {
        DifficultyMenu diffMenu = new DifficultyMenu();
        guessHandler = new GuessHandler(diffMenu.readOption());

        guessHandler.createUnderscores();
        askQuestion();
    }

    private void askQuestion()
    {
        playing = true;
        System.out.println("\nWord to guess:");
        String prettyGuess = guessHandler.getPrettyGuess();
        System.out.println(prettyGuess);
        System.out.println("\nNumber of guesses left: " + guessHandler.getGuesses());
        System.out.print("Guess letter: ");

        boolean success = guessHandler.evaluateGuess(scanUserInput(), playing);

        while (!success)
        {
            success = guessHandler.evaluateGuess(scanUserInput(), playing);
        }
        System.out.println("Guessed letters: " + guessHandler.getPrettyGuessedLetter());
        result();
        scanner.close();

    }

    private String scanUserInput()
    {
        scanner = new Scanner(System.in);
        String input = scanner.next().toUpperCase();

        if (input.equals(quitGame))
        {
            playing = false;
            endGame();
        } else if (input.equals(backToMenu))
        {
            guessHandler.reset();
            startMenu();
        } else
        {
            if (input.length() > 1)
            {
                System.out.println("Too long, please type only one letter.");
                input = scanUserInput();
            }
        }
        return input;
    }


    /**
     *
     */
    private void result()
    {
        int guesses = guessHandler.getGuesses();

        if (guesses >= 0)
        {
            if (guessHandler.getCorrectLetters() == guessHandler.getLetterList().size())
            {
                roundWon();
            } else
            {
                if (guesses > 0)
                {
                    askQuestion();
                } else
                {
                    gameOver();
                }
            }
        }
    }

    /**
     *
     */
    private void newGame()
    {
        System.out.println("\nStart new game? (Y/N)");

        final Scanner scanner2 = new Scanner(System.in);
        final String answer = scanner2.next().toUpperCase();

        if (answer.equals(yes))
        {
            setUpGame();
        } else if (answer.equals(no))
        {
            System.out.println("Thanks for playing Hangman! Goodbye.");
            playing = false;
        } else
        {
            System.out.println("Invalid option, please pick Y or N");
            newGame();
        }
        scanner2.close();
    }


    /**
     * Displays result of round if player has guessed the whole word correctly.
     * Also gives the option to start new round, or end game.
     */
    private void roundWon()
    {
        System.out.println(guessHandler.getPrettyLetterList());
        System.out.println("Correct! You Won!\nYou used " + (10 - guessHandler.getGuesses()) + " guesses.");

        guessHandler.reset();
        newGame();
    }

    /**
     * Displays game over if the player has failed to guess the word, as well as the correct word.
     * Gives the option to start a new game.
     */
    private void gameOver()
    {
        hangman.drawEnd();
        System.out.println("No more guesses! Game over");
        System.out.println("Correct word was: " + guessHandler.getPrettyLetterList());
        playing = false;
        resetGame();
        newGame();
    }

    private void resetGame()
    {
        guessHandler.reset();
    }

    private void endGame()
    {
        System.out.println("\nAre you sure you want to quit? (Y/N)");

        final Scanner scanner3 = new Scanner(System.in);
        final String answer = scanner3.next().toUpperCase();

        if (answer.equals(no))
        {
            if (playing)
            {
                askQuestion();
            } else
            {
                startMenu();
            }
        } else if (answer.equals(yes))
        {
            playing = false;
            resetGame();
            System.out.println("Thank you for playing Hangman! Goodbye.");
            return;
        } else
        {
            System.out.println("Invalid option, please pick Y or N");
            endGame();
        }
        scanner3.close();
    }

}
