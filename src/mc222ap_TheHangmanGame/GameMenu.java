package mc222ap_TheHangmanGame;

public class GameMenu {

    private final String startOption = "1";
    private final String quitOption = "2";
    private final String quitGame = "QUIT";
    private final String backToMenu = "MENU";
    private final String yes = "Y";
    private final String no = "N";

    public GameMenu()
    {
        showMenu();
    }

    public void showMenu()
    {
        System.out.println("---------MENU---------" + "\n"
                + startOption + ". Start a new game\n"
                + quitOption + ". Quit game.\n"
                + "Pick a number option: ");
    }

    public String getStartOption()
    {
        return startOption;
    }

    public String getQuitOption()
    {
        return quitOption;
    }

    public String getQuitGame()
    {
        return quitGame;
    }

    public String getBackToMenu()
    {
        return backToMenu;
    }

    public String getYes()
    {
        return yes;
    }

    public String getNo()
    {
        return no;
    }
}
