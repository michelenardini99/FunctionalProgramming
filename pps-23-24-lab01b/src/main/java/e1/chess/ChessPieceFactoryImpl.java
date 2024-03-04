package e1.chess;

import e1.Pair;

public class ChessPieceFactoryImpl implements ChessPieceFactory{

    @Override
    public ChessPiece createPawnPiece(Pair<Integer, Integer> position) {
        return new Pawn(position);
    }

    @Override
    public ChessPiece createKnightPiece(Pair<Integer, Integer> position) {
        return new Knight(position);
    }
    
}
