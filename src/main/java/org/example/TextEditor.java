package org.example;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextEditor {

    private static ArrayList<String> tokenizer(String text, int maxTokenSize) {
        ArrayList<String> tokens = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\S+");
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()) {
            String token = matcher.group();
            while(token.length() > maxTokenSize) {
                tokens.add(token.substring(0, maxTokenSize));
                token = token.substring(maxTokenSize);
            }
            tokens.add(token);
        }

        return  tokens;
    }

    private static String spaceMultiplier(int num) {
        StringBuilder space = new StringBuilder();
        while(num-- > 0) {
            space.append(" ");
        }

        return space.toString();
    }

    private static String concatenation(ArrayList<String> tokens, int spaceCount) {
        StringBuilder result = new StringBuilder(tokens.get(0));

        if(tokens.size() == 1) {
            return result.toString();
        }

        int tokenCount = tokens.size();

        String token;
        int spacesNeeded;
        for(int i = 1; i < tokens.size(); i++) {
            token = tokens.get(i);
            spacesNeeded = spaceCount / (tokenCount - 1);

            result.append(spaceMultiplier(spacesNeeded));
            result.append(token);

            tokenCount--;
            spaceCount -= spacesNeeded;
        }

        return result.toString();
    }

    public static ArrayList<String> editor(String text, int lineSize) {
        if (lineSize <= 0) throw new IllegalArgumentException("длина строки должна быть натуральным числом");

        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> tokens =  tokenizer(text, lineSize);

        ArrayList<String> currentLine = new ArrayList<>();
        int currentLineSize = 0;
        for(String token : tokens) {
            if(currentLineSize + currentLine.size() + token.length() > lineSize) {
                result.add(concatenation(currentLine, lineSize - currentLineSize));
                currentLine.clear();
                currentLineSize = 0;
            }

            currentLine.add(token);
            currentLineSize += token.length();
        }

        if(!currentLine.isEmpty()) {
            result.add(String.join(" ", currentLine));
        }

        return result;
    }
}
