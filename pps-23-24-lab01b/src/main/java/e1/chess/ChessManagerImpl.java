package e1.chess;

import e1.Pair;
import e1.utils.Randomizer;

public class ChessManagerImpl implements ChessManager{

    private ChessPieceFactory chessPieceFactory = new ChessPieceFactoryImpl();
    private ChessPiece knight;
    private ChessPiece pawn;

    @Override
    public void generatePieces(int size) {
        this.pawn = chessPieceFactory.createPawnPiece(randomEmptyPosition(size));
        this.knight = chessPieceFactory.createKnightPiece(randomEmptyPosition(size));
    }

    private final Pair<Integer,Integer> randomEmptyPosition(int size){
    	Pair<Integer,Integer> pos = Randomizer.randomizePosition(size);
    	// the recursive call below prevents clash with an existing pawn
    	return isPositionFree(size, pos);
    }

    private Pair<Integer, Integer> isPositionFree(int size, Pair<Integer, Integer> pos) {
        return pawn!=null && pawn.isInTheSamePosition(pos) ? randomEmptyPosition(size) : pos;
    }

    @Override
    public ChessPiece getKnight() {
        return this.knight;
    }

    @Override
    public ChessPiece getPawn() {
        return this.pawn;
    }

    @Override
    public boolean hasKnight(Pair<Integer, Integer> position) {
        return this.knight.isInTheSamePosition(position);
    }

    @Override
    public boolean hasPawn(Pair<Integer, Integer> position) {
        return this.pawn.isInTheSamePosition(position);
    }

    @Override
    public void setKnightPosition(Pair<Integer, Integer> position) {
        this.knight.setPosition(position);
    }

    @Override
    public boolean haveYouWin() {
        return this.knight.isInTheSamePosition(this.pawn.getPosition());
    }


}
