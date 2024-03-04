package e1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChessManagerTest {

    private ChessManager chessManager;

    @BeforeEach
    void init(){
        int size = 5;
        chessManager = new ChessManagerImpl();
        chessManager.generatePieces(size);
    }

    @Test
    void testKnightCreated(){
      Pair<Integer, Integer> pos = new Pair<Integer,Integer>(4,4);
      assertEquals(pos, chessManager.getKnight().getPosition());  
    }

    @Test
    void testPawnCreated(){
      Pair<Integer, Integer> pos = new Pair<Integer,Integer>(2,0);
      assertEquals(pos, chessManager.getPawn().getPosition());  
    }

    @Test
    void testHasKnight(){
        Pair<Integer, Integer> pos = new Pair<Integer,Integer>(4,4);
        assertTrue(chessManager.hasKnight(pos));
    }

    @Test
    void testHasPawn(){
        Pair<Integer, Integer> pos = new Pair<Integer,Integer>(2,0);
        assertTrue(chessManager.hasPawn(pos));
    }

    @Test
    void testWin(){
        Pair<Integer, Integer> pos = new Pair<Integer,Integer>(2,0);
        chessManager.setKnightPosition(pos);
        assertTrue(chessManager.haveYouWin());
    }
    
}
