package com.wordcounter.output;

import java.util.Map;

public interface OutputHandler {
    void outputResults(Map<String, Integer> results);
}
