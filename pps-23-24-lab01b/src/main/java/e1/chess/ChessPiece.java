package e1.chess;

import e1.Pair;

public interface ChessPiece {

    Pair<Integer, Integer> getPosition();

    boolean isInTheSamePosition(Pair<Integer, Integer> position);

    void setPosition(Pair<Integer, Integer> position);
}
