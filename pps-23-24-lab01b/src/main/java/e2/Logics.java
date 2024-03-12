package e2;

import java.util.List;
import java.util.function.BooleanSupplier;

public interface Logics {

    List<Cell> getMines();

    List<Cell> getCells();

    boolean hit(Pair<Integer, Integer> position);

    Integer getNumberMinesAround(Pair<Integer, Integer> position);

    void flagCell(Pair<Integer, Integer> position);
    
}
