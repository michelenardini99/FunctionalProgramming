package e1;

import java.util.function.Predicate;

import java.util.Map;

public interface GameRulesStrategy {

    Predicate<Pair<Integer, Integer>> isMoveAllowed();

    Predicate<Pair<Integer, Integer>> checkCoordinatesIsValid(int size);

}
