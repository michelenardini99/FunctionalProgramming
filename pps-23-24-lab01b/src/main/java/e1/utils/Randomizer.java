package e1.utils;

import java.util.Random;

import e1.Pair;

public class Randomizer {

    private final static Random random = new Random();

    public static Pair<Integer, Integer> randomizePosition(int size) {
        return new Pair<>(random.nextInt(size),random.nextInt(size));
    }

}
