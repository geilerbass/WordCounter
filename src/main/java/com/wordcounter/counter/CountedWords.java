package com.wordcounter.counter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CountedWords {

    private Map<String, Integer> countedWords = new HashMap<>();

    public void checkWordAgainstCountedWords(String word) {
        if (countedWords.size() < 1) {
            countedWords.put(word, 1);
            return;
        }

        Iterator<Map.Entry<String, Integer>> it = countedWords.entrySet().iterator();
        if (!incrementWordIfAlreadyFoundOrIgnoreIfASubstring(word, it)) {
            countedWords.put(word, 1);
        }
    }

    private boolean incrementWordIfAlreadyFoundOrIgnoreIfASubstring(String word,
                                                                    Iterator<Map.Entry<String, Integer>> iterator) {
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            String currentWord = entry.getKey();
            if (word.equals(currentWord)) {
                // Identically matched to previously counted word so incrementing this word's count and marking as found
                entry.setValue(entry.getValue() + 1);
                return true;
            } else if (currentWord.length() > word.length()) {
                if (currentWord.contains(word)) {
                    // This word is a substring of a previously-counted, longer word, so do not increment but
                    // mark as found
                    return true;
                }
            } else {
                if (word.contains(currentWord)) {
                    // A previously counted word is a substring of this word, so remove previously counted word and
                    // continue iterating
                    iterator.remove();
                }
            }
        }
        // Iterated through all words and have not found an existing match
        return false;
    }

    public Map<String, Integer> getCountedWords() {
        return countedWords;
    }
}
