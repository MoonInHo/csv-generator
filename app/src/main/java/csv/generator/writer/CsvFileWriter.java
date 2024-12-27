package csv.generator.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import csv.generator.provider.FilePathProvider;

public class CsvFileWriter {

    public static void write(String fileName, String data) throws IOException {
        Path filePath = FilePathProvider.getFilePath(fileName);
        Files.write(filePath, data.getBytes(), StandardOpenOption.CREATE);
    }
}
