package tdd2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class CircularIterator implements Iterator<Integer>{

    private ListIterator<Integer> circularIterator;
    private boolean pointToNextOne;
    private ArrayList<Integer> list;

    public CircularIterator(ArrayList<Integer> list, boolean pointToNextOne){
        this.list = list;
        circularIterator = list.listIterator();
        this.pointToNextOne = pointToNextOne;
    }    

    @Override
    public boolean hasNext() {
        return pointToNextOne ? circularIterator.hasNext() : circularIterator.hasPrevious();
    }

    @Override
    public Integer next() {
        return pointToNextOne ? nextValueofList() : previousValueOfList();
    }

    private Integer nextValueofList(){
        updateCircularIterator(0);
        return circularIterator.next();
    }

    private Integer previousValueOfList(){
        updateCircularIterator(list.size());
        return circularIterator.previous();
    }

    private void updateCircularIterator(int index){
        if(!hasNext()){
            circularIterator = list.listIterator(index);
        }
    }

}
