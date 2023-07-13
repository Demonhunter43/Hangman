package Hangman;

import java.util.Scanner;

public class Game {
    private final String hiddenWord;
    private int mistakesCounter;
    private final int mistakesMax = 6;
    private final Illustration illustration;

    public Game(String word) {
        this.hiddenWord = word;
        this.illustration = new Illustration();
    }

    public int getMistakesCounter() {
        return mistakesCounter;
    }

    public void setMistakesCounter(int mistakesCounter) {
        this.mistakesCounter = mistakesCounter;
    }
    public String getHiddenWord() {
        return hiddenWord;
    }

    public void start() {
        int i;
        char[] outputWord = {};
        String buffer = "";
        StringBuilder outputLetters = new StringBuilder();
        setMistakesCounter(0);
        char[] hiddenWordChar = getHiddenWord().toCharArray();

        System.out.println("We have a new hidden word:");

        for (i = 0; i < getHiddenWord().length(); i++) {
            buffer = buffer + " _";
        }
        outputWord = buffer.toCharArray();
        System.out.println(new String(outputWord));

        Scanner scanner = new Scanner(System.in);
        String letter = "";

        while (getMistakesCounter() < mistakesMax) {
            if (! (new String(outputWord).contains("_")) ) {
                System.out.println("You won!");
                System.out.printf("The word was: %s", getHiddenWord());
                break;
            }
            letter = scanner.nextLine();
            if ((Character.UnicodeBlock.of(letter.charAt(0)).equals(Character.UnicodeBlock.CYRILLIC)) && (Character.isLowerCase(letter.charAt(0))) && (letter.length() == 1)){
                if(outputLetters.toString().contains(letter)){
                    System.out.println("You already used this letter");
                    continue;
                }
                outputLetters.append(letter);
                if(getHiddenWord().contains(letter)){
                    for (i=0 ; i<getHiddenWord().length(); i++){
                        if (letter.charAt(0) == hiddenWordChar[i]){
                            outputWord[2*i+1] = letter.charAt(0);
                        }
                    }
                }
                else{
                    System.out.printf("There is no letter %s \n", letter);
                    setMistakesCounter(getMistakesCounter()+1);
                }
            }
            else{
                System.out.println("Please use russian low regesite");
                continue;
            }
            System.out.println(new String(outputWord));
            System.out.printf("Number of mistakes: %d, used letters: %s \n", getMistakesCounter(), outputLetters.toString());
            Illustration.drawNext(getMistakesCounter());
        }
        if(getMistakesCounter() == mistakesMax){
            System.out.println("You lost");
            System.out.printf("The word was: %s \n", getHiddenWord());
        }
    }
}