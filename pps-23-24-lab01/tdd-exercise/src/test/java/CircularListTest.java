import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImplementation;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int N_ITERATIONS = 3;
    private CircularList circularList;

    @Disabled
    @Test public void testTodo(){
        Assertions.fail();
    }

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
    void testNextListValue(){
        assertEquals(0, circularList.next().get());
    }

    @Test
    void testIteratorNotResetAfterAdd(){
        circularList.next();
        circularList.add(4);
        circularList.next();
        assertEquals(2, circularList.next().get());
    }

    @Test
    void testSecondNextListValue(){
        circularList.next();
        assertEquals(1, circularList.next().get());
    }

    @Test
    void testListNextIsCircular(){
        doNext(3);
        assertEquals(0, circularList.next().get());
    }

    @Test
    void testPrevious(){
        doNext(N_ITERATIONS);
        assertEquals(2, circularList.previous().get());
    }

    @Test
    void testSecondPreviousListValue(){
        doNext(N_ITERATIONS);
        circularList.previous();
        assertEquals(1, circularList.previous().get());
    }

    @Test
    void testListPreviousIsCircular(){
        assertEquals(2, circularList.previous().get());
    }

    @Test
    void testMultipleNextAndPrevious(){
        doNext(7);
        doPrevious(3);
        assertEquals(0, circularList.previous().get());
    }

    @Test
    void testReset(){
        doNext(N_ITERATIONS);
        circularList.reset();
        assertEquals(0, circularList.next().get());
    }


    private void fillList(){
        for(int i = 0; i < N_ITERATIONS; i++){
            circularList.add(i);
        }
    }

    private void doNext(int n_times){
        for(int i=0; i<n_times;i++){
            circularList.next();
        }
    }

    private void doPrevious(int n_times){
        for(int i=0; i<n_times;i++){
            circularList.previous();
        }
    }

}
