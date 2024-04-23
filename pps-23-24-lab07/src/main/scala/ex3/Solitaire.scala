package ex3

object Solitaire extends App:
  type Mark = (Int, Int)
  type Solution = Iterable[Mark]
  type IterableFactory = Solution => Iterable[Solution]
  given IterableFactory = List(_)

  def render(solution: Solution, width: Int, height: Int): String =
    val reversed = solution.toSeq.reverse
    val rows =
      for y <- 0 until height
          row = for x <- 0 until width
          number = solution.toSeq.indexOf((x, y)) + 1
          yield if number > 0 then "%-2d ".format(number) else "X  "
      yield row.mkString
    rows.mkString("\n")

  private def placeMarks(step: Int)(width: Int, height: Int)(using factory: IterableFactory): Iterable[Solution] = step match
    case 1 => factory(Set((width/2, height/2)))
    case _ =>
      for
        marks <- placeMarks(step - 1)(width, height)
        x <- 0 until width
        y <- 0 until height
        mark = (x, y)
        if !marks.toSeq.contains(mark) && isMoveAllowed(marks.toSeq)(mark)
      yield
        marks.toSeq :+ mark


  private def isMoveAllowed(marks: Seq[(Int, Int)])(newMark: (Int, Int)): Boolean =
    val dx = Math.abs(newMark._1 - marks.last._1)
    val dy = Math.abs(newMark._2 - marks.last._2)
    (dx == 3 && dy == 0) || (dx == 0 && dy == 3) || (dx == 2 && dy == 2)


  placeMarks(25)(5,5).zipWithIndex.foreach((m, i) => {
    println(render(m, 5, 5))
    println("-------------------------------\n")
  })

