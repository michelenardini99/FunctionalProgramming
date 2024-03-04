package e1.rules;

import java.util.function.Predicate;

import e1.Pair;

public class GameRulesStrategyImpl implements GameRulesStrategy{

    private static final int MOVE_LIMITS = 3;

    @Override
    public Predicate<Pair<Integer, Integer>> isMoveAllowed() {
        return (position) -> position.getX()!=0 
        && position.getY()!=0 
        && Math.abs(position.getX())+Math.abs(position.getY())==MOVE_LIMITS;
    }

    @Override
    public Predicate<Pair<Integer, Integer>> checkCoordinatesIsValid(int size) {
        return (coordinates) -> coordinates.getX()<0 || coordinates.getY()<0 || coordinates.getX() >= size || coordinates.getY() >= size;
    }

}
