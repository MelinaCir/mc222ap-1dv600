package mc222ap_TheHangmanGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Words {

    private ArrayList<String> wordList = new ArrayList<>();
    private Scanner wordScanner;


    private void getWord() {
        try {
            wordScanner = new Scanner(new File("/Users/amandacirverius/Documents/Melinas/minaord.txt"));

        } catch (
                FileNotFoundException e) {
            System.out.println("File could not be read!");
        }


        while (wordScanner.hasNext()) {
            String word = wordScanner.nextLine();

            wordList.add(word);
        }
        wordScanner.close();

        String selectedWord = wordList.get((int) (Math.random() * wordList.size()));

//        for (int i = 0; i < selectedWord.length(); i++) {
//            letterList.add(String.valueOf(selectedWord.charAt(i)));
//            underscores.add("_ ");
//        }
    }

//        private String getUnderscores(final ArrayList<String> list) {
//            return list.toString()
//                    .replace(",", "")
//                    .replace("[", "")
//                    .replace("]", "");
//        }


}
