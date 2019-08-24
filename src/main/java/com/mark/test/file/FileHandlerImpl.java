package com.mark.test.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.Consumer;

public class FileHandlerImpl implements FileHandler {

    private String filePath;

    public FileHandlerImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void processFile(Consumer<String> consumer) {
        try (Scanner scanner = new Scanner(new FileInputStream(new File(filePath)))) {
            scanner.useDelimiter("[\\s\r\n]+");
            while (scanner.hasNext()) {
                consumer.accept(scanner.next());
            }
        } catch (FileNotFoundException e){
            //TODO Inform caller/client that file cannot be found
        }
    }
}
