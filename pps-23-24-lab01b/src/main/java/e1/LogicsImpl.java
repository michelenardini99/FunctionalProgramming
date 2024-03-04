package e1;

import java.util.Random;

public class LogicsImpl implements Logics {
	
	private static final int DEFAULT_SIZE = 5;
	private ChessPiece pawn;
	private ChessPiece knight;
	private final Random random = new Random();
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
		this.pawn = new Pawn(new Pair<Integer,Integer>(2, 0));
        this.knight = new Knight(new Pair<Integer,Integer>(DEFAULT_SIZE-1,DEFAULT_SIZE-1));
	}	

	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		checkCoordinatesIsValid(row, col);
		// Below a compact way to express allowed moves for the knight
		int x = row-this.knight.getPosition().getX();
		int y = col-this.knight.getPosition().getY();
		if (isMoveAllowed(x, y)) {
			this.knight.setPosition(new Pair<>(row,col));
			return this.pawn.isInTheSamePosition(this.knight.getPosition());
		}
		return false;
	}

	private boolean isMoveAllowed(int x, int y) {
		return x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3;
	}

	private void checkCoordinatesIsValid(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.isInTheSamePosition(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.isInTheSamePosition(new Pair<>(row,col));
	}
}
