package csv.generator.generator.primitive;

import csv.generator.generator.DataGenerator;
import csv.generator.generator.RandomDataGenerator;

public class BooleanGenerator implements DataGenerator {

    @Override
    public String generate() {
        return String.valueOf(RandomDataGenerator.generateBoolean());
    }
}
