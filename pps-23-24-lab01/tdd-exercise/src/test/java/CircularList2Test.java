import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd2.CircularList;
import tdd2.CircularListImplementation;

public class CircularList2Test {

    private static final int N_ITERATIONS = 3;
    CircularList circularList;
    
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
        Iterator<Integer> circularIterator = circularList.forwardIterator();
        circularIterator.next();
        circularIterator.next();
        circularIterator.next();
        assertEquals(0, circularIterator.next());
    }

    @Test 
    void testBackwardIterator(){
        Iterator<Integer> circularIterator = circularList.backwardIterator();
        assertEquals(2, circularIterator.next());
    }


    private void fillList(){
        for(int i = 0; i < N_ITERATIONS; i++){
            circularList.add(i);
        }
    }
}
