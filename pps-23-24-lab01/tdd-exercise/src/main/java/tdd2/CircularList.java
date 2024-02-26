package tdd2;

import java.util.Iterator;

public interface CircularList {

    void add(int element);

    int size();

    boolean isEmpty();

    Iterator<Integer> forwardIterator();

    Iterator<Integer> backwardIterator();

}
