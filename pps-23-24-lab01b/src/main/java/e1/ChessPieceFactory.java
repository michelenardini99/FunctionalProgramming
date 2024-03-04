package e1;

public interface ChessPieceFactory {
    
    ChessPiece createPawnPiece(Pair<Integer, Integer> position);

    ChessPiece createKnightPiece(Pair<Integer, Integer> position);

}
