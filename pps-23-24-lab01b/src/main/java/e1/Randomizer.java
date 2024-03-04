package e1;

import java.util.Random;

public class Randomizer {

    private final static Random random = new Random();

    public static Pair<Integer, Integer> randomizePosition(int size) {
        return new Pair<>(random.nextInt(size),random.nextInt(size));
    }

}
