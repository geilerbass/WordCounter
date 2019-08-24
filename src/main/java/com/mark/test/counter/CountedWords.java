package com.mark.test.counter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CountedWords {

    private Map<String, Integer> results = new HashMap<>();

    public void validateWord(String word) {
        if (results.size() < 1) {
            results.put(word, 1);
            return;
        }

        Iterator<Map.Entry<String, Integer>> it = results.entrySet().iterator();
        if (!contains(word, it)) {
            results.put(word, 1);
        }
    }

    private boolean contains(String word, Iterator<Map.Entry<String, Integer>> it) {
        while (it.hasNext()){
            Map.Entry<String, Integer> entry = it.next();
            String currentWord = entry.getKey();
            if (word.equals(currentWord)) {
                entry.setValue(entry.getValue() + 1);
                return true;
            } else if (currentWord.length() > word.length()) {
                if (currentWord.contains(word)) {
                    return true;
                }
            } else {
                if (word.contains(currentWord)) {
                    it.remove();
                    return false;
                }
            }
        }
        return false;
    }

    public Map<String, Integer> getCountedWords() {
        return results;
    }
}
