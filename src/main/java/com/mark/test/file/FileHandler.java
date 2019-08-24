package com.mark.test.file;

import java.util.function.Consumer;

public interface FileHandler {
    void processFile(Consumer<String> consumer) throws Exception;
}
