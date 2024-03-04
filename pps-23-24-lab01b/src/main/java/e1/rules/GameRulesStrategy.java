package e1.rules;

import java.util.function.Predicate;

import e1.Pair;

import java.util.Map;

public interface GameRulesStrategy {

    Predicate<Pair<Integer, Integer>> isMoveAllowed();

    Predicate<Pair<Integer, Integer>> checkCoordinatesIsValid(int size);

}
