package e1;

public class LogicsImplProxy implements Logics{

    private Logics logics;

    public LogicsImplProxy(int size){
        logics = new LogicsImpl(size);
    }

    public LogicsImplProxy(){
        logics = new LogicsImpl();
    }

    @Override
    public boolean hit(int row, int col) {
        return logics.hit(row, col);
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return logics.hasKnight(row, col);
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return logics.hasPawn(row, col);
    }
    
}
