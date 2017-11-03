package ru.nsu.hci.bayrakh.javalabs.lab4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public class FileStats {
    private int lines;
    private int words;
    private int letters;
    private HashMap<Character, Integer> letterCounts;

    FileStats(InputStream input) throws FileNotFoundException {
        lines = 0;
        words = 0;
        letters = 0;
        letterCounts = new HashMap<>();
        Scanner file = new Scanner(input);
        while (file.hasNextLine()) {
            lines++;
            Scanner line = new Scanner(file.nextLine());
            while (line.hasNext()) {
                words++;
                String word = line.next();
                for (char letter : word.toCharArray()) {
                    if (Character.isLetter(letter)) {
                        letters++;
                        letter = Character.toUpperCase(letter);
                        int count = 0;
                        if (letterCounts.containsKey(letter)) {
                            count = letterCounts.get(letter);
                        }
                        letterCounts.put(letter, count + 1);
                    }
                }
            }
        }
    }

    public int getLines() {
        return lines;
    }

    public int getLetters() {
        return letters;
    }

    public int getWords() {
        return words;
    }

    public HashMap<Character, Integer> getLetterCounts() {
        return letterCounts;
    }
}
