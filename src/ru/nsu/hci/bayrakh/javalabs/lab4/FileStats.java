package ru.nsu.hci.bayrakh.javalabs.lab4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FileStats {
    public int lines;
    public int words;
    public int letters;
    public HashMap<Character, Integer> letterCounts;
    FileStats(String filename) throws FileNotFoundException {
        lines = 0;
        words = 0;
        letters = 0;
        letterCounts = new HashMap<>();
        Scanner file = new Scanner(new FileInputStream(filename));
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
}