package e1.chess;

import e1.Pair;

public class Pawn implements ChessPiece{

    private Pair<Integer, Integer> position;

    public Pawn(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    @Override
    public boolean isInTheSamePosition(Pair<Integer, Integer> position) {
        return getPosition().equals(position);
    }

    @Override
    public void setPosition(Pair<Integer, Integer> position) {
        this.position = position;
    }

}
