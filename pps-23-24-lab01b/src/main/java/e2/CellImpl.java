package e2;

public class CellImpl implements Cell{

    private Pair<Integer, Integer> position;
    private boolean flag;
    private boolean isAMine;
    private boolean counter;

    public CellImpl(Pair<Integer, Integer> position) {
        this.position = position;
        this.flag = false;
        this.isAMine = false;
        this.counter = false;
    }

    public Pair<Integer, Integer> getPosition(){
        return this.position;
    }

    public void setFlag(){
        flag = !flag;
    }

    public boolean haveFlag(){
        return flag;
    }

    @Override
    public boolean isAMine() {
        return isAMine;
    }

    @Override
    public void setMine() {
        isAMine = true;
    }

    @Override
    public boolean isCountered() {
        return counter;
    }

    @Override
    public void setCounter() {
        counter = !counter;
    }


    
}
