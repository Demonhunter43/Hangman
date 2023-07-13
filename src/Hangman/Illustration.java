package Hangman;

public class Illustration {
    public static final String[] stages = {
     "    +---+\n" +
             "    |   |\n" +
             "    |\n" +
             "    |\n" +
             "    |\n" +
             "    |\n" +
             "    =========",

             "    +---+\n" +
             "    |   |\n" +
             "    |   O\n" +
             "    |\n" +
             "    |\n" +
             "    |\n" +
             "    =========",

             "    +---+\n" +
             "    |   |\n" +
             "    |   O\n" +
             "    |   |\n" +
             "    |\n" +
             "    |\n" +
             "    =========",

             "    +---+\n" +
             "    |   |\n" +
             "    |   O\n" +
             "    |  /|\n" +
             "    |\n" +
             "    |\n" +
             "    =========",

             "    +---+\n" +
             "    |   |\n" +
             "    |   O\n" +
             "    |  /|\\\n" +
             "    |\n" +
             "    |\n" +
             "    =========",

             "    +---+\n" +
             "    |   |\n" +
             "    |   O\n" +
             "    |  /|\\\n" +
             "    |  /\n" +
             "    |\n" +
             "    =========",

             "    +---+\n" +
             "    |   |\n" +
             "    |   O\n" +
             "    |  /|\\\n" +
             "    |  / \\\n" +
             "    |\n" +
             "    =========" };



    public static void drawNext(int mistakesCounter) {
        System.out.println(stages[mistakesCounter]);
    }
}
