package e2;

public interface Cell {

    Pair<Integer, Integer> getPosition();

    void setFlag();

    void setMine();

    boolean haveFlag();

    boolean isAMine();

    boolean isCountered();

    void setCounter();

}
