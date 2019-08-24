package com.wordcounter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WordCounterTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void wordCounterReadsFromExampleFileAndCountsWords() throws IOException {
        // Given
        File testFile = temporaryFolder.newFile("testFile");
        Files.write(testFile.toPath(), "a mate material may maybe right maybe".getBytes());

        WordCounter wordCounter = new WordCounter();

        // When
        Map<String, Integer> countedWords = wordCounter.countWordsInFile(testFile.getAbsolutePath());

        // Then
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("material", 1);
        expected.put("maybe", 2);
        expected.put("right", 1);
        assertThat(countedWords, is(expected));
    }
}