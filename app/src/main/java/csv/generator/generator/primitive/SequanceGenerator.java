package csv.generator.generator.primitive;

import csv.generator.generator.DataGenerator;

public class SequanceGenerator implements DataGenerator {

    private int sequance;

    public SequanceGenerator() {
        this.sequance = 1;
    }

    @Override
    public String generate() {
        return String.valueOf(sequance++);
    }
}
