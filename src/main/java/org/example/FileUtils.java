package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {

    public static String readFromFile(String fileName) throws IOException {
        return Files.readString(Path.of(fileName));
    }

    public static void writeToFile(String fileName, String text) throws IOException {
        Files.writeString(Path.of(fileName), text);
    }
}
