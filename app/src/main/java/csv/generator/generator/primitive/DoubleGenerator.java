package csv.generator.generator.primitive;

import java.text.DecimalFormat;

import csv.generator.generator.DataGenerator;
import csv.generator.generator.RandomDataGenerator;

public class DoubleGenerator implements DataGenerator {

    @Override
    public String generate() {
        double value = RandomDataGenerator.generateDouble();

        DecimalFormat df = new DecimalFormat("#.#####");
        return df.format(value);
    }
}
