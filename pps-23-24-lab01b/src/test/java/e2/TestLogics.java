package e2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLogics {

    Logics logics;

    @BeforeEach
    void init(){
        logics = new LogicsImpl(7, 3);
    }

    @Test
    void testMineIsPlaced(){
        assertEquals(3, logics.getMines().size());
    }

    @Test
    void testMineHitted(){
        assertTrue(logics.hit(new Pair<>(1, 1)));
    }

    @Test
    void testMineNotHitted(){
        assertFalse(logics.hit(new Pair<>(3, 1)));
    }

    @Test
    void testNumberMineAroundIsCorrect(){
        assertEquals(1, logics.getNumberMinesAround(new Pair<>(0, 2)));
    }

    @Test
    void testCellIsFlagged(){
        logics.flagCell(new Pair<>(3,3));
        Cell cellSelected = logics.getCells().stream().filter(cell -> cell.getPosition().equals(new Pair<>(3,3))).findFirst().get();
        assertTrue(cellSelected.haveFlag());
    }

    @Test
    void testCellIsNotFlagged(){
        Cell cellSelected = logics.getCells().stream().filter(cell -> cell.getPosition().equals(new Pair<>(3,3))).findFirst().get();
        assertFalse(cellSelected.haveFlag());
    }
    
}
