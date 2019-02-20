package mc222ap_TheHangmanGame;

public class GameMenu {

    private String headline = "---------MENU---------";
    private String startOption = "1";
    private String quitOption = "2";
    private String pickNumber = "Pick a number option: ";



    public GameMenu() {
    }

    public String getStartOption() {
        return startOption;
    }

    public String getQuitOption() {
        return quitOption;
    }

    public String showMenu() {
        return headline + "\n"
                + startOption + ". Start a new game\n"
                + quitOption + ". Quit game.\n"
                + pickNumber;
    }
}
