package ex

import scala.annotation.targetName


// Express a second degree polynomial
// Structure: secondDegree * X^2 + firstDegree * X + constant
trait SecondDegreePolynomial:
  def constant: Double
  def firstDegree: Double
  def secondDegree: Double
  def +(polynomial: SecondDegreePolynomial): SecondDegreePolynomial
  def -(polynomial: SecondDegreePolynomial): SecondDegreePolynomial

case class SecondDegreePolynomialImpl(private var _secondDegree: Double, 
                                 private var _firstDegree: Double, 
                                 private var _constant: Double) extends SecondDegreePolynomial:
  def constant: Double = _constant
  def firstDegree: Double = _firstDegree
  def secondDegree: Double = _secondDegree
  def +(polynomial: SecondDegreePolynomial): SecondDegreePolynomial = SecondDegreePolynomialImpl(secondDegree + polynomial.secondDegree,
                                                   firstDegree + polynomial.firstDegree,
                                                   constant + polynomial.constant)
  def -(polynomial: SecondDegreePolynomial): SecondDegreePolynomial = SecondDegreePolynomialImpl(secondDegree - polynomial.secondDegree,
                                                   firstDegree - polynomial.firstDegree,
                                                   constant - polynomial.constant)
  override def toString(): String = this match
    case SecondDegreePolynomialImpl(_secondDegree, _firstDegree, _constant) => s"$_secondDegree * X^2 + $_firstDegree * X + $_constant"
  

object SecondDegreePolynomial:
  def apply(secondDegree: Double, firstDegree: Double, constant: Double): SecondDegreePolynomial = SecondDegreePolynomialImpl(secondDegree, firstDegree, constant)


@main def checkComplex(): Unit =
  val simplePolynomial = SecondDegreePolynomial(1.0, 0, 3)
  val anotherPolynomial = SecondDegreePolynomial(0.0, 1, 0.0)
  val fullPolynomial = SecondDegreePolynomial(3.0, 2.0, 5.0)
  val poly1 = SecondDegreePolynomialImpl(1.0, 2.0, 1.0)
  val poly2 = SecondDegreePolynomialImpl(1.0, 2.0, 1.0)

  // Check equality
  println(poly1 == poly2) // Expected: false

  // Check toString
  println(poly1.toString) // Expected: Some default string representation
  val sum = simplePolynomial + anotherPolynomial
  println((sum, sum.secondDegree, sum.firstDegree, sum.constant)) // 1.0 * X^2 + 1.0 * X + 3.0
  val multipleOperations = fullPolynomial - (anotherPolynomial + simplePolynomial)
  println((multipleOperations, multipleOperations.secondDegree, multipleOperations.firstDegree, multipleOperations.constant)) // 2.0 * X^2 + 1.0 * X + 2.0

/** Hints:
  *   - implement SecondDegreePolynomial with a SecondDegreePolynomialImpl class, similar to PersonImpl in slides
  *   - check that equality and toString do not work
  *   - use a case class SecondDegreePolynomialImpl instead
  *   - check equality and toString now
  */
