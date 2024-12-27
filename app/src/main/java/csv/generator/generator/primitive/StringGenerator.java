package csv.generator.generator.primitive;

import com.github.javafaker.Faker;

import csv.generator.generator.DataGenerator;

public class StringGenerator implements DataGenerator {

    @Override
    public String generate() {
        Faker faker = new Faker();
        return faker.commerce().productName();
    }
}
