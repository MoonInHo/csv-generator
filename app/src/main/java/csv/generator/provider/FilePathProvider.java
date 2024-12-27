package csv.generator.provider;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePathProvider {

    private static final String FILE_PATH = "files";
    private static final String SUFFIX = ".csv";

    public static Path getFilePath(String fileName) {
        createFileDir();
        return Paths.get(FILE_PATH, fileName + SUFFIX);
    }

    private static void createFileDir() {
        File file = new File(FILE_PATH);
        file.mkdirs();
    }
}
