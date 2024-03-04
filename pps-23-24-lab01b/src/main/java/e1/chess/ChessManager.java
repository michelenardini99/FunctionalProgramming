package e1.chess;

import e1.Pair;

public interface ChessManager {

    void generatePieces(int size);

    ChessPiece getKnight();

    ChessPiece getPawn();

    boolean hasKnight(Pair<Integer, Integer> position);

    boolean hasPawn(Pair<Integer, Integer> position);

    void setKnightPosition(Pair<Integer, Integer> position);

    boolean haveYouWin();


}
