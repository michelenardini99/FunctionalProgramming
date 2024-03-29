package tdd3;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Optional;
import java.util.function.Predicate;

public class CircularListImplementation implements CircularList {

    ArrayList<Integer> circularList;
    ListIterator<Integer> iterator;

    public CircularListImplementation(){
        circularList = new ArrayList<>();
        reset();
    }

    @Override
    public void add(int element) {
        circularList.add(element);
        reset();
    }

    @Override
    public int size() {
        return circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return circularList.isEmpty();
    }


    @Override
    public Optional<Integer> next() {
        if (!iterator.hasNext()) {
            reset();
        }
        return Optional.of(iterator.next());
    }

    @Override
    public Optional<Integer> nextFilteredValue(Predicate<Integer> condition) {
        for(int i=0;i<circularList.size();i++){
            Optional<Integer> value = next().filter(condition);
            if (value.isPresent()) {
                return value;
            }
        }
        return Optional.empty();
    }

    private void reset() {
        iterator = circularList.listIterator();
    }

}
