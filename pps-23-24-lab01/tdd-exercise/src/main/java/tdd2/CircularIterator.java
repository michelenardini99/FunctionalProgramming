package tdd2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CircularIterator implements Iterator<Integer>{

    private ListIterator<Integer> circIterator;
    private boolean pointToNextOne;
    private ArrayList<Integer> list;

    public CircularIterator(ArrayList<Integer> list, boolean pointToNextOne){
        this.list = list;
        circIterator = list.listIterator();
        this.pointToNextOne = pointToNextOne;
    }    

    @Override
    public boolean hasNext() {
        return pointToNextOne ? circIterator.hasNext() : circIterator.hasPrevious();
    }

    @Override
    public Integer next() {
        return pointToNextOne ? nextValueofList() : previousValueOfList();
    }

    private Integer nextValueofList(){
        if(!hasNext()){
            circIterator = list.listIterator();
        }
        return circIterator.next();
    }

    private Integer previousValueOfList(){
        if(!hasNext()){
            circIterator = list.listIterator(list.size());
        }
        return circIterator.previous();
    }


    

}
