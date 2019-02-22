package mc222ap_TheHangmanGame;

public class GameMenu {

    private String startOption = "1";
    private String quitOption = "2";

    public GameMenu() {
        showMenu();
    }

    public void showMenu() {
        System.out.println("---------MENU---------" + "\n"
                + startOption + ". Start a new game\n"
                + quitOption + ". Quit game.\n"
                + "Pick a number option: ");
    }

    public String getStartOption() {
        return startOption;
    }

    public String getQuitOption() {
        return quitOption;
    }

}
