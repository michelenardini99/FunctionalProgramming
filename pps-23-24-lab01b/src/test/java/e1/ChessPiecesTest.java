package e1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChessPiecesTest {

    private ChessPiece pawn;
    private ChessPiece knight;
    private ChessPieceFactory chessPieceFactory;

    @Test
    void testCreatePawnPiece(){
        pawn = chessPieceFactory.createPawnPiece(new Pair<Integer,Integer>(0, 2));
        assertEquals(new Pair<>(0, 2), pawn.getPosition());
    }

    @Test
    void testCreateKnightPiece(){
        chessPieceFactory.createKnightPiece(new Pair<Integer,Integer>(0, 0));
        assertEquals(new Pair<>(0, 0), knight.getPosition());
    }

    @BeforeEach
    void init(){
        chessPieceFactory = new ChessPieceFactoryImpl();
        pawn = chessPieceFactory.createPawnPiece(new Pair<Integer,Integer>(0, 2));
        knight = chessPieceFactory.createKnightPiece(new Pair<Integer,Integer>(0, 0));
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
