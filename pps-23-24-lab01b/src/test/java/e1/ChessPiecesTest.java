package e1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChessPiecesTest {

    private ChessPiece pawn;
    private ChessPiece knight;

    @Test
    void testCreatePawnPiece(){
        pawn = new Pawn(new Pair<Integer,Integer>(0, 2));
        assertEquals(new Pair<>(0, 2), pawn.getPosition());
    }

    @Test
    void testCreateKnightPiece(){
        knight = new Knight(new Pair<Integer,Integer>(0, 0));
        assertEquals(new Pair<>(0, 0), knight.getPosition());
    }

    @BeforeEach
    void init(){
        pawn = new Pawn(new Pair<Integer,Integer>(0, 2));
        knight = new Knight(new Pair<Integer,Integer>(0, 0));
    }

    @Test
    void testPiecesNotSamePosition(){
        assertFalse(pawn.isInTheSamePosition(knight.getPosition()));
    }

    @Test
    void testPiecesInSamePosition(){
        knight.setPosition(new Pair<Integer,Integer>(2, 0));
        assertFalse(pawn.isInTheSamePosition(knight.getPosition()));
    }
    
}
