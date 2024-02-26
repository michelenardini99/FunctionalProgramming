package tdd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class CircularListImplementation implements CircularList {

    private ArrayList<Integer> circularList;
    private ListIterator<Integer> iterator;



    public CircularListImplementation() {
        this.circularList = new ArrayList<>();
        reset();
    }

    @Override
    public void add(int element) {
        this.circularList.add(element);
        reset();
    }

    @Override
    public int size() {
        return this.circularList.size();       
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if (!iterator.hasNext()) {
            reset();
        }
        return Optional.of(iterator.next());
    }

    @Override
    public Optional<Integer> previous() {
        if(!iterator.hasPrevious()){
            iterator = this.circularList.listIterator(circularList.size());
        }
        return Optional.of(iterator.previous());
    }

    @Override
    public void reset() {
        iterator = this.circularList.listIterator();
    }

}
