package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

class TextEditorTest {

    @Test
    void tokenizerSplitsWordsCorrectly() throws Exception {
        String text = "Привет, мир! Это тест.";
        int maxTokenSize = 100;

        ArrayList<String> tokens = TextEditor.editor(text, maxTokenSize);

        assertNotNull(tokens);
        assertFalse(tokens.isEmpty());

        String firstLine = tokens.get(0);
        assertTrue(firstLine.contains("Привет") || firstLine.contains("мир"));
    }

    @Test
    void editorProducesCorrectLineLength() {
        String text = "Привет мир это тест для выравнивания";
        int lineSize = 10;

        ArrayList<String> lines = TextEditor.editor(text, lineSize);

        for (String line : lines) {
            assertTrue(line.length() <= lineSize, "Строка превышает допустимую длину");
        }
    }

    @Test
    void editorThrowsForNonPositiveLineSize() {
        String text = "Пример текста";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TextEditor.editor(text, 0);
        });

        assertEquals("длина строки должна быть натуральным числом", exception.getMessage());
    }

    @Test
    void concatenationDistributesSpacesCorrectly() throws Exception {
        ArrayList<String> tokens = new ArrayList<>(Arrays.asList("Привет", "мир"));
        int spaces = 5;

        String line = TextEditor.concatenation(tokens, spaces);

        assertEquals(14, line.length());
        assertTrue(line.startsWith("Привет"));
        assertTrue(line.endsWith("мир"));
    }
}
