package e1;

import e1.chess.ChessManager;
import e1.chess.ChessManagerImpl;
import e1.rules.GameRulesStrategy;
import e1.rules.GameRulesStrategyImpl;

public class LogicsImpl implements Logics {
	
	private static final int DEFAULT_SIZE = 5;
	private final ChessManager chessManager = new ChessManagerImpl();
	private final GameRulesStrategy gameRulesStrategy = new GameRulesStrategyImpl();
	private final int size;
	 
    public LogicsImpl(int size){
    	this.size = getValidSize(size);
        setPawnAndKnight();	
    }

	private int getValidSize(int size) {
		return size < DEFAULT_SIZE ? DEFAULT_SIZE : size;
	}

	public LogicsImpl() {
		this.size = DEFAULT_SIZE;
		setPawnAndKnight();
	}

	private void setPawnAndKnight() {
		chessManager.generatePieces(size);
	}	
    
	@Override
	public boolean hit(int row, int col) {
		checkCoordinatesValidation(row, col);
		// Below a compact way to express allowed moves for the knight
		int x = row-chessManager.getKnight().getPosition().getX();
		int y = col-chessManager.getKnight().getPosition().getY();
		if (gameRulesStrategy.isMoveAllowed().test(new Pair<Integer,Integer>(x, y))) {
			chessManager.setKnightPosition(new Pair<>(row,col));
			return chessManager.haveYouWin();
		}
		return false;
	}

	private void checkCoordinatesValidation(int row, int col) {
		if (gameRulesStrategy.checkCoordinatesIsValid(size).test(new Pair<Integer,Integer>(row, col))) {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.chessManager.hasKnight(new Pair<Integer,Integer>(row, col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.chessManager.hasPawn(new Pair<Integer,Integer>(row, col));
	}
}
