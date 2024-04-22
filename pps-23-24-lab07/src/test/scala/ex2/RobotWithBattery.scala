package ex2

import ex2.Direction.{East, North, South, West}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RobotWithBatterySpec extends AnyFlatSpec with Matchers:
  "A robot with battery" should " act correctly" in {
    val robot = RobotWithBattery(SimpleRobot((0, 0), Direction.North))

    robot.turn(North)
    robot.act(25)

    robot.position should be ((0, 1))

    robot.turn(East)
    robot.act(25)

    robot.position should be ((1, 1))

    robot.turn(South)
    robot.act(75)

    robot.position should be ((1, 1))
  }