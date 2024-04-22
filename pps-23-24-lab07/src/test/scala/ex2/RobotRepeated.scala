package ex2

import ex2.Direction.North
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RobotRepeatedSpec extends AnyFlatSpec with Matchers:
  "A robot repeated" should " act correctly" in {
    val robot = RobotRepeated(SimpleRobot((0, 0), Direction.North))

    robot.turn(North)
    robot.act(5)

    robot.position should be ((0, 5))
  }


