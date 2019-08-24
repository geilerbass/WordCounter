package com.wordcounter.output;

import java.util.Map;

public class SystemOutOutputHandler implements OutputHandler {
    @Override
    public void outputResults(Map<String, Integer> results) {
        results.entrySet().stream()
                .sorted((x, y) -> compareStringsByLengthTheAlphanumeric(x.getKey(), y.getKey()))
                .forEachOrdered(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }

    private int compareStringsByLengthTheAlphanumeric(String firstString, String secondString) {
        return firstString.length() > secondString.length() ? -1 :
                firstString.length() < secondString.length() ? 1 :
                        firstString.compareTo(secondString);
    }
}
