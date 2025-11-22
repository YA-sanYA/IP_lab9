package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileUtils {

    public static String readFromFile(String fileName) throws IOException {
        return Files.readString(Path.of(fileName));
    }

    public static void writeToFile(String fileName, ArrayList<String> text) throws IOException {
        String result = String.join("\n", text);
        Files.writeString(Path.of(fileName), result);
    }
}
