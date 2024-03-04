package e1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class LogicTest {

  private static final int DEFAULT_SIZE = 5;
  private Logics logics;

  
  @Test
  void testLogicsImplCreatedCorrectly(){
      assertNotNull(logics);
  }

  @Test
  void testLogicsImplCreatedCorrectlyWithoutSizeParam(){
      logics = new LogicsImpl();
      assertNotNull(logics);
  }

  @Test
  void testLogicsImplCreatedCorrectlyNegativeSize(){
      int size = -5;
      logics = new LogicsImpl(size);
      assertNotNull(logics);
  }

  @BeforeEach
  void init(){
      logics = new LogicsImpl(DEFAULT_SIZE);
  }

  @Test
  void testKnightGenerated(){
      int colKnight = DEFAULT_SIZE - 1;
      int rowKnight = DEFAULT_SIZE - 1;
      assertTrue(logics.hasKnight(rowKnight, colKnight));
  }

  @Test
  void testPawnGenerated(){
      int colPawn = 0;
      int rowPawn = 2;
      assertTrue(logics.hasPawn(rowPawn, colPawn));
  }

  @Test
  void testHitWithNotCorrectCoordinate(){
    int row=-1;
    int col= -1;
    assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(row, col) );
  }

  @Test
  void testKnightNotHitPawn(){
    int row = 3;
    int col = 3;
    assertFalse(logics.hit(row, col));
  }

  @Test
  void testKnightHitPawn(){
    int row = 3;
    int col = 2;
    logics.hit(row, col);
    row = 2;
    col = 0;
    assertTrue(logics.hit(row, col));
  }


}
