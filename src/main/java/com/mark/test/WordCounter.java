package com.mark.test;

import com.mark.test.counter.CountedWords;
import com.mark.test.file.FileHandlerImpl;
import com.mark.test.output.SystemOutOutputHandler;

import java.util.Map;

public class WordCounter {

    public static void main(String[] args) {
        String filePath = args[0];
        Map<String, Integer> countedWords = new WordCounter().countWordsInFile(filePath);
        new SystemOutOutputHandler().outputResults(countedWords);
    }

    public Map<String, Integer> countWordsInFile(String filePath) {
        CountedWords countedWords = new CountedWords();
        new FileHandlerImpl(filePath).processFile(countedWords::validateWord);
        return countedWords.getCountedWords();
    }

}
