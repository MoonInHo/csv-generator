package csv.generator.generator.primitive;

import csv.generator.generator.DataGenerator;
import csv.generator.generator.RandomDataGenerator;

public class IntegerGenerator implements DataGenerator {

    private static final int INT_RANGE = 1000000;

    @Override
    public String generate() {
        return String.valueOf(RandomDataGenerator.generateInt(INT_RANGE));
    }
}
