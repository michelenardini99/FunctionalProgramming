import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd3.*;

public class CircularList3Test {

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
    void testFilteredNextValue(){
        assertEquals(2, circularList.nextFilteredValue(i -> i == 2).get());
    }

    @Test
    void testFilteredNextValueNotExist(){
        assertEquals(Optional.empty(), circularList.nextFilteredValue(i -> i > 10));
    }

    @Test
    void testFilteredNextValueAfterMovingOnIterator(){
        circularList.next();
        circularList.next();
        circularList.next();
        assertEquals(0, circularList.nextFilteredValue(i -> i % 2 == 0).get());

    }

    private void fillList(){
        for(int i = 0; i < N_ITERATIONS; i++){
            circularList.add(i);
        }
    }
    
}
