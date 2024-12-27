package csv.generator.enums;

import java.util.Arrays;

import csv.generator.generator.DataGenerator;
import csv.generator.generator.primitive.*;

public enum ColumnType {

    // Primitive Type
    SEQUANCE(new SequanceGenerator()),
    INTEGER(new IntegerGenerator()),
    DOUBLE(new DoubleGenerator()),
    CHAR(new CharGenerator()),
    STRING(new StringGenerator()),
    BOOLEAN(new BooleanGenerator());

    // Domain Type
    // NAME(),
    // EMAIL(),
    // PHONE(),
    // CONTACT(),
    // ADDRESS(),
    // DATE(),


    private final DataGenerator dataGenerator;

    ColumnType(DataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }

    public static ColumnType getName(String inputColumnType) {
        return Arrays.stream(ColumnType.values())
                .filter(type -> checkValueEquals(type, inputColumnType))
                .findFirst()
                .orElse(null);
    }

    public static boolean isInvalidColumnType(String inputColumnType) {
        return Arrays.stream(ColumnType.values())
                .noneMatch(e -> e.name().equals(inputColumnType));
    }

    public String generatedData() {
        return dataGenerator.generate();
    }

    private static boolean checkValueEquals(ColumnType type, String inputColumnType) {
        return type.name().equals(inputColumnType) || type.name().equals(inputColumnType);
    }
}
