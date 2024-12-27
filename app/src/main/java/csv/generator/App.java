package csv.generator;

import java.io.IOException;

import csv.generator.handler.InputHandler;
import csv.generator.strategy.CsvGenerateStrategy;
import csv.generator.strategy.factory.CsvGenerateStrategyFactory;
import csv.generator.util.MessagePrinter;
import csv.generator.writer.CsvFileWriter;

public class App {

    private final CsvGenerateStrategyFactory csvGenerateStrategyFactory;

    public App(CsvGenerateStrategyFactory csvGenerateStrategyFactory) {
        this.csvGenerateStrategyFactory = csvGenerateStrategyFactory;
    }

    public static void main(String[] args) throws Exception {
        App app = new App(new CsvGenerateStrategyFactory());
        app.run();
    }

    private void run() throws IOException {
        String fileName = InputHandler.inputFileName();

        CsvGenerateStrategy dataGenerateStrategy = getGenerateStrategy();
        String generatedData = dataGenerateStrategy.generate();

        CsvFileWriter.write(fileName, generatedData);

        MessagePrinter.printGenerationSuccessMessage();
    }

    private CsvGenerateStrategy getGenerateStrategy() {
        while (true) {
            MessagePrinter.printSelectMethodMessage();
            CsvGenerateStrategy strategy = csvGenerateStrategyFactory.getStrategy(InputHandler.inputLine());
            if (strategy != null) {
                return strategy;
            }
        }
    }
}
