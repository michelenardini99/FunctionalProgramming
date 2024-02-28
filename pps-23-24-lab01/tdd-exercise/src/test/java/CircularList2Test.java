import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd2.CircularList;
import tdd2.CircularListImplementation;

public class CircularList2Test {

    private static final int N_ITERATIONS = 3;
    private CircularList circularList;
    Iterator<Integer> circularIterator;
    
    @BeforeEach
    void testCircularListCreatedCorrectly(){
        circularList = new CircularListImplementation();
        fillList();
    }

    @Test
    void testAdd(){
        assertFalse(circularList.isEmpty());
    }

    @Test
    void testSize(){
        assertEquals(3, circularList.size());
    }

    @Test 
    void testForwardIterator(){
        circularIterator = circularList.forwardIterator();
        doNext(3);
        assertEquals(0, circularIterator.next());
    }

    @Test 
    void testBackwardIterator(){
        circularIterator = circularList.backwardIterator();
        assertEquals(2, circularIterator.next());
    }


    private void fillList(){
        for(int i = 0; i < N_ITERATIONS; i++){
            circularList.add(i);
        }
    }

    private void doNext(int n_times){
        for(int i=0; i<n_times;i++){
            circularIterator.next();
        }
    }
}
