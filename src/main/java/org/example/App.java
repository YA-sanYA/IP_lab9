package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите длину строки");
            int lineSize = scanner.nextInt();

            String text = FileUtils.readFromFile("input.txt");

            ArrayList<String> result = TextEditor.editor(text, lineSize);

            FileUtils.writeToFile("output.txt", result);
        } catch (Exception e) {
            System.out.println("Ошибка во время чтения файла");
        }

    }
}
