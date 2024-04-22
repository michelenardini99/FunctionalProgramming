package ex2

import ex2.Direction.{East, North}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RobotCanFailSpec extends AnyFlatSpec with Matchers:
  "A robot can fail" should " act correctly" in {
    val robot = RobotCanFail(SimpleRobot((0, 0), Direction.North))

    robot.turn(North)
    robot.act(0.05)

    robot.position should be ((0, 1))

    robot.turn(East)
    robot.act(0.9)

    robot.position should be ((0, 1))
  }
