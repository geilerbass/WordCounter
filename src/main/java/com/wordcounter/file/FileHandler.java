package com.wordcounter.file;

import java.util.function.Consumer;

public interface FileHandler {
    void processFile(Consumer<String> consumer) throws Exception;
}
