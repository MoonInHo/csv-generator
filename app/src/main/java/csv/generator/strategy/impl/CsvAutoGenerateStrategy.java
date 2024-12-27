package csv.generator.strategy.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import csv.generator.enums.ColumnType;
import csv.generator.handler.InputHandler;
import csv.generator.strategy.CsvGenerateStrategy;
import csv.generator.util.MessagePrinter;

import static csv.generator.util.Command.NEXT_STEP_COMMAND;
import static csv.generator.util.Command.REMOVE_PREVIOUS_COMMAND;
import static csv.generator.util.Symbol.COMMA;
import static csv.generator.util.Symbol.NEW_LINE;
import static csv.generator.util.Index.*;

public class CsvAutoGenerateStrategy implements CsvGenerateStrategy {
    
    private static final Deque<String> columnNames = new ArrayDeque<>();
    private static final List<ColumnType> columnTypes = new ArrayList<>();

    @Override
    public String generate() {
        processColumnNameInput();
        addColumnType();

        StringBuilder content = generateContent(InputHandler.inputLoopCount());

        return content.toString();
    }

    private void processColumnNameInput() {
        MessagePrinter.printColumnNameInputMessage();

        String inputColumnName;
        boolean isFinished = false;
        while (!isFinished) {
            inputColumnName = InputHandler.inputLine();
            isFinished = updateColumnName(inputColumnName);
        }
    }

    private boolean updateColumnName(String inputColumnName) {
        switch (inputColumnName) {
            case NEXT_STEP_COMMAND -> {
                return checkColumnNameExists();
            }
            case REMOVE_PREVIOUS_COMMAND -> removeColumnName();
            default -> columnNames.offer(inputColumnName.toUpperCase());
        }
        return false;
    }

    private boolean checkColumnNameExists() {
        if (columnNames.isEmpty()) {
            MessagePrinter.printNextStepFailureMessage();
            return false;
        }
        return true;
    }

    private void removeColumnName() {
        MessagePrinter.printRemoveColumnNameMessage();
        columnNames.pollLast();
    }
    
    private void addColumnType() {
        for (String columnName : columnNames) {
            columnTypes.add(checkColumnType(columnName));
        }
    }

    private ColumnType checkColumnType(String columnName) {
        String inputColmnType;

        while (true) {
            MessagePrinter.printColumnTypePrefixMessage(columnName);

            inputColmnType = InputHandler.inputLine().toUpperCase();
            if (!ColumnType.isInvalidColumnType(inputColmnType)) {
                return ColumnType.getName(inputColmnType);
            }
            MessagePrinter.printColumnTypeFailureMessage();
        }
    }

    private StringBuilder generateContent(int loopCount) {
        StringBuilder stringBuilder = new StringBuilder();

        appendHeader(stringBuilder);
        
        for (int i = ZERO; i < loopCount; i++) {
            appendRow(stringBuilder, i);
        }
        return stringBuilder;
    }

    private void appendHeader(StringBuilder stringBuilder) {
        for (String columnName : columnNames) {
            stringBuilder.append(columnName).append(COMMA);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - ONE);
        stringBuilder.append(NEW_LINE);
    }

    private void appendRow(StringBuilder stringBuilder, int index) {
        for (ColumnType type : columnTypes) {
            stringBuilder.append(type.generatedData()).append(COMMA);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - ONE);
        stringBuilder.append(NEW_LINE);
    }
}
