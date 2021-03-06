package ru.nsu.hci.bayrakh.javalabs.lab4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FileWorker {
    public static void main(String[] args) {
        System.out.print("Введите имя файла: ");
        Scanner input = new Scanner(System.in);
        String filename = input.nextLine();
        try {
            FileStats stats = new FileStats(new FileInputStream(filename));
            System.out.printf("Строк: %d%n", stats.getLines());
            System.out.printf("Слов: %d%n", stats.getWords());
            System.out.printf("Букв: %d%n", stats.getLetters());
            for (HashMap.Entry<Character, Integer> entry : stats.getLetterCounts().entrySet()) {
                System.out.printf("Букв %s: %d%n", entry.getKey(), entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.out.printf("Файл %s не сущестует.", filename);
        }

    }
}
