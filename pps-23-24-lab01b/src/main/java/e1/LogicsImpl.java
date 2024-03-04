package e1;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private static final int DEFAULT_SIZE = 5;
	private Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
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
		this.pawn = new Pair<Integer,Integer>(0, 0);
        this.knight = new Pair<Integer,Integer>(this.size-1, this.size-1);
	}	

	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		// Below a compact way to express allowed moves for the knight
		int x = row-this.knight.getX();
		int y = col-this.knight.getY();
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
			this.knight = new Pair<>(row,col);
			return this.pawn.equals(this.knight);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}
}
