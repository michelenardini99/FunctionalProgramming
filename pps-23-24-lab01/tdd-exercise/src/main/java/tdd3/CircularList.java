package tdd3;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Predicate;

public interface CircularList {

    void add(int element);

    int size();

    boolean isEmpty();

    Optional<Integer> next();

    Optional<Integer> nextFilteredValue(Predicate<Integer> condition);
    
}
