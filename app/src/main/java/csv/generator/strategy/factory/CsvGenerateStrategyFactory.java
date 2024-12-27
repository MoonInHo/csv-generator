package csv.generator.strategy.factory;

import static csv.generator.util.Command.*;

import csv.generator.strategy.CsvGenerateStrategy;
import csv.generator.strategy.impl.CsvAutoGenerateStrategy;
import csv.generator.strategy.impl.CsvManualGenerateStrategy;
import csv.generator.util.MessagePrinter;

public class CsvGenerateStrategyFactory {

    public CsvGenerateStrategy getStrategy(String selectionCommand) {
        return switch(selectionCommand) {
            case AUTO_GENERATE_COMMAND -> new CsvAutoGenerateStrategy();
            case MANUAL_GENERATE_COMMAND -> new CsvManualGenerateStrategy();
            default -> {
                MessagePrinter.printSelectMethodFailedMessage();
                yield null;
            }
        };
    }
}
