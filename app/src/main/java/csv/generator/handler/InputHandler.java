package csv.generator.handler;

import java.util.InputMismatchException;
import java.util.Scanner;

import csv.generator.util.MessagePrinter;
import csv.generator.validator.InputValidator;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputFileName() {
        MessagePrinter.printFileNameInputMessage();

        String fileName = scanner.nextLine();
        InputValidator.validateFileName(fileName);

        return fileName;
    }

    public static int inputLoopCount() {
        while (true) {
            MessagePrinter.printLoopCountInputMessage();
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                MessagePrinter.printLoopCountFailureMessgae();
                scanner.nextLine();
            }
        }
    }

    public static String inputLine() {
        return scanner.nextLine();
    }
}
