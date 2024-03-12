package e2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogicsImpl implements Logics {

    private List<Cell> cells = new ArrayList<>();
    private int size;
    private Random random = new Random();

    public LogicsImpl(int size, int numMines) {
        this.size = size;
        generateCell();
        addMines(numMines);
    }

    private void generateCell() {
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                cells.add(new CellImpl(new Pair<Integer,Integer>(i, j)));
            }
        }
    }

    private void addMines(int numMines) {
        for(int i=0; i<numMines; i++){
            //this.cells.add(randomizeMinePosition());
            //this.cells.add(new CellImpl(new Pair<Integer,Integer>(i, i)));
            Pair<Integer, Integer> pos = new Pair<Integer,Integer>(i, i);
            cells.stream().filter((cell) -> cell.getPosition().equals(pos)).findFirst().ifPresent(cell -> cell.setMine());
        }
    }

    private Pair<Integer, Integer> randomizeMinePosition() {
        Pair<Integer, Integer> minePosition = new Pair<Integer,Integer>(random.nextInt(size), random.nextInt(size));

        return isItAMine(minePosition) ? randomizeMinePosition() : minePosition;
    }

    public List<Cell> getMines() {
        return this.cells.stream().filter(cell -> cell.isAMine()).toList();
    }

    public List<Cell> getCells(){
        return cells;
    }

    @Override
    public boolean hit(Pair<Integer, Integer> position) {
        if(isItAMine(position)){
            return true;
        }else{
            getCells().stream().filter(cell -> cell.getPosition().equals(position)).findFirst().get().setCounter();
            return false;
        }
    }

    private boolean isItAMine(Pair<Integer, Integer> position) {
        return getMines().stream().filter(cell -> cell.getPosition().equals(position)).findFirst().isPresent();
    }

    @Override
    public Integer getNumberMinesAround(Pair<Integer, Integer> position) {
        int x = position.getX();
        int y = position.getY();
        int numMines=0;
        for(int i = x - 1; i<=x+1;i++){
            for(int j = y - 1; j<=y+1;j++){
                if (isItAMine(new Pair<Integer,Integer>(i, j))) {
                    numMines+=1;
                }
            }
        }
        return numMines;
    }

    @Override
    public void flagCell(Pair<Integer, Integer> position) {
        cells.stream().filter((cell) -> cell.getPosition().equals(position)).findFirst().ifPresent(cell -> cell.setFlag());
    }

    

}
