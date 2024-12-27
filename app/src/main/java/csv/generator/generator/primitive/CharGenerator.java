package csv.generator.generator.primitive;

import csv.generator.generator.DataGenerator;
import csv.generator.generator.RandomDataGenerator;

public class CharGenerator implements DataGenerator {

    private static final int CHAR_RANGE = 52;

    @Override
    public String generate() {
        int range = RandomDataGenerator.generateInt(CHAR_RANGE);
        if (range < 26) {
            return String.valueOf((char) ('a' + range));
        }
        return String.valueOf((char) ('A' + (range - 26)));
    }
}
