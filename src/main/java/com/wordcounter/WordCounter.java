package com.wordcounter;

import com.wordcounter.counter.CountedWords;
import com.wordcounter.file.FileHandlerImpl;
import com.wordcounter.output.SystemOutOutputHandler;

import java.util.Map;

public class WordCounter {

    public static void main(String[] args) {
        String filePath = args[0];
        Map<String, Integer> countedWords = new WordCounter().countWordsInFile(filePath);
        new SystemOutOutputHandler().outputResults(countedWords);
    }

    public Map<String, Integer> countWordsInFile(String filePath) {
        CountedWords countedWords = new CountedWords();
        new FileHandlerImpl(filePath).processFile(countedWords::checkWordAgainstCountedWords);
        return countedWords.getCountedWords();
    }

}
