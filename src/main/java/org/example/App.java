package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите длину строки");
            int lineSize = scanner.nextInt();

            String text = null;
            try {
                text = FileUtils.readFromFile("input.txt");
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла: " + e.getMessage());
                return;
            }

            ArrayList<String> result = TextEditor.editor(text, lineSize);

            try {
                FileUtils.writeToFile("output.txt", result);
            } catch (IOException e) {
                System.out.println("Ошибка при записи файла: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        }
    }
}
