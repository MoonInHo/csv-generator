package csv.generator.generator;

import java.util.Random;

public class RandomDataGenerator {

    private static final double MIN_VALUE = 0.0;
    private static final double MAX_VALUE = 99999.99999;

    private static final Random random = new Random();

    public static int generateInt(int range) {
        return random.nextInt(range);
    }

    public static double generateDouble() {
        return MIN_VALUE + (MAX_VALUE - MIN_VALUE) * random.nextDouble();
    }

    public static boolean generateBoolean() {
        return random.nextBoolean();
    }
}
