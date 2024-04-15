package polyglot.a01a

import polyglot.a01a.Logics
import polyglot.a01a.Logics.Result
import polyglot.Pair
import scala.util.Random
import util.Sequences.Sequence
import util.Sequences.Sequence.Nil
import util.Sequences.Sequence.Cons

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01a/sol2/ */
class LogicsImpl(private val _size: Int, private val _boat: Int) extends Logics:

  private val FAILURES: Int = 5
  private var failures: Int = 0
  private val boatRow: Int = Random.nextInt(_size)
  private val boatLeftCol: Int = Random.nextInt(_size-_boat+1)
  private val boatSize: Int = _boat
  private var hit: Sequence[Pair[Int, Int]]= Nil()
  private var hitSize: Int = 0

  println(s"x = $boatLeftCol y = $boatRow")

  def hit(row: Int, col: Int) = {
    if (row == boatRow && col == boatLeftCol && col < boatLeftCol - boatSize) {
      hit.concat(Cons(new Pair(row, col), Nil()))
      hitSize = hitSize + 1
      if(hitSize == boatSize) then Result.WON else Result.HIT
    }
    failures = failures + 1
    if(failures == FAILURES) then Result.LOST else Result.MISS
  }
