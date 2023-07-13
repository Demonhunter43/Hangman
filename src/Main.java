import Hangman.Dictionary;
import Hangman.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dictionary Dictionary = new Dictionary("./russian_nouns.txt");

        System.out.println("Hi");
        while(true){                                                
            System.out.println("Type 'start' or 'exit'");
            String command = "";
            command = scanner.nextLine();

            switch(command) {
                case ("start"):
                    System.out.println("Ok, let's go");
                    Game currentGame = new Game(Dictionary.getRandomWord());
                    currentGame.start();
                    break;
                case ("exit"):
                    System.out.println("Bye(");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Don't know this command");
                    System.out.println("Type 'start' or 'exit'");
            }
        }
    }
}