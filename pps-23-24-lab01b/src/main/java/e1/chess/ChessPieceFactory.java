package e1.chess;

import e1.Pair;

public interface ChessPieceFactory {
    
    ChessPiece createPawnPiece(Pair<Integer, Integer> position);

    ChessPiece createKnightPiece(Pair<Integer, Integer> position);

}
