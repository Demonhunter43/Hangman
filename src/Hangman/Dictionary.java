package Hangman;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class Dictionary {
    private final int minSize = 5;
    private final int maxSize = 10;

    private static ArrayList<String> wordsList;

    public Dictionary(String pathDictionary) {
        this.wordsList = downloadWordsList(pathDictionary);
    }

    public static ArrayList<String> downloadWordsList(String pathDictionary) {
        wordsList = null;
        try {
            Charset charset = StandardCharsets.UTF_8;
            ArrayList<String> wordsList;
            wordsList = new ArrayList<>(Files.readAllLines(Paths.get(pathDictionary), charset));
            return wordsList;
        }
        catch (IOException e) {
            System.out.println("Wrong path for dictionary");
        }
        return wordsList;
    }

    public String getRandomWord() {
        String word = "";
        Random random = new Random();
        while ((word.length() < minSize)||(word.length() > maxSize)||(word.contains("-"))){
            word = wordsList.get(random.nextInt(wordsList.size()));
        }
        return word;
    }
}