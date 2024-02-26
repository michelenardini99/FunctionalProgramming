package tdd2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class CircularListImplementation implements CircularList {

    ArrayList<Integer> circularList;
    ListIterator<Integer> iterator;

    public CircularListImplementation(){
        circularList = new ArrayList<>();
        iterator = circularList.listIterator();
    }

    @Override
    public void add(int element) {
        circularList.add(element);
    }

    @Override
    public int size() {
        return circularList.size();
    }

    @Override
    public Iterator forwardIterator() {
        return new CircularIterator(circularList, true);
    }

    @Override
    public Iterator backwardIterator() {
        return new CircularIterator(circularList, false);
    }

    @Override
    public boolean isEmpty() {
        return circularList.isEmpty();
    }

}
