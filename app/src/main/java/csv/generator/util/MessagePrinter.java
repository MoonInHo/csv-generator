package csv.generator.util;

public class MessagePrinter {

    public static void printFileNameInputMessage() {
        System.out.println("Please enter the file name to save.");
    }
    
    public static void printSelectMethodMessage() {
        System.out.println("Select a creation method. (Auto = 'A' / MANUAL = 'M')");
    }

    public static void printSelectMethodFailedMessage() {
        System.err.println("Please choose between 'A' or 'M'.");
    }

    public static void printColumnNameInputMessage() {
        System.out.println("Enter the column name and press '!Y' to proceed to the next step.");
        System.out.println("Press '!R' to delete the previous column and try again.");
    }
    
    public static void printInvalidColumnFormatMessage() {
        System.out.println("The column name format is invalid.");
    }

    public static void printNextStepFailureMessage() {
        System.out.println("You must enter at least one column name to proceed to the next step");
    }

    public static void printRemoveColumnNameMessage() {
        System.out.println("The most recently entered column name has been deleted.");
    }

    public static void printColumnTypePrefixMessage(String columnName) {
        System.out.print(columnName + " Type: ");
    }

    public static void printColumnTypeFailureMessage() {
        System.err.println("The type is invalid. Please enter it again");
    }

    public static void printLoopCountInputMessage() {
        System.out.println("Please enter the number of loops.");
    }
    
    public static void printLoopCountFailureMessgae() {
        System.err.println("Invalid input. Only positive integers are allowed");
    }
    
    public static void printGenerationSuccessMessage() {
        System.out.println("The generation is complete.");
    }

}
