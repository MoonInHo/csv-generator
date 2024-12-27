package csv.generator.validator;

public class InputValidator {

    public static void validateFileName(String inputFileName) {
        if (inputFileName.isBlank()) {
            throw new IllegalArgumentException("Please enter the file name.");
        }
    }
}
