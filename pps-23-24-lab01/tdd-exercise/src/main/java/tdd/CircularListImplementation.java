package tdd;

import java.util.ArrayList;

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
        updateIterator(iterator.nextIndex());
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
            updateIterator(circularList.size());
        }
        return Optional.of(iterator.previous());
    }

    private void updateIterator(int actualIteratorIndex) {
        iterator = circularList.listIterator(actualIteratorIndex);
    }

    @Override
    public void reset() {
        updateIterator(0);
    }

}
