import Direction.EAST
import Direction.NORTH
import Direction.SOUTH
import Direction.WEST
import java.util.Scanner

object MarsRover {

    @JvmStatic
    fun main(args: Array<String>) {
        val reader = Scanner(System.`in`)
        println("Insert horizontal map size:")
        val sizex = reader.nextInt()
        println("Insert vertical map size:")
        val sizey = reader.nextInt()
        println("Insert horizontal initial rover position:")
        var roverx = reader.nextInt()
        println("Insert vertical initial rover position:")
        var rovery = reader.nextInt()
        var position = Position(roverx, rovery)
        println("Insert initial rover direction:")
        var direction = reader.next() //n = north, e = east, w = west, s = south
        var d = Direction.fromChar(direction)
        do {
            println("Insert command (f = forward, b = backward, l = turn left, r = turn right):")
            val command = reader.next()
            if (command == "f") {
                position = moveForward(d, position)
            }
            if (command == "b") {
                position = moveBackward(d, position)
            }
            if (command == "l") {
                d = moveLeft(d)
            }
            if (command == "r") {
                d = moveRight(d)
            }
            println(String.format("Rover is at x:%d y:%d facing:%s", position.x, position.y, d.char))
        } while (true)
    }

    private fun moveRight(direction: Direction): Direction {
        var roverz1 = direction
        if (roverz1 == NORTH) {
            roverz1 = EAST
        } else if (roverz1 == EAST) {
            roverz1 = SOUTH
        } else if (roverz1 == SOUTH) {
            roverz1 = WEST
        } else if (roverz1 == WEST) {
            roverz1 = NORTH
        }
        return roverz1
    }

    private fun moveLeft(direction: Direction): Direction {
        var roverz1 = direction
        if (roverz1 == NORTH) {
            roverz1 = WEST
        } else if (roverz1 == WEST) {
            roverz1 = SOUTH
        } else if (roverz1 == SOUTH) {
            roverz1 = EAST
        } else if (roverz1 == EAST) {
            roverz1 = NORTH
        }
        return roverz1
    }

    private fun moveBackward(
            direction: Direction,
            position: Position
                            ): Position {
        var rovery1 = position.y
        var roverx1 = position.x
        if (direction == NORTH) {
            rovery1 -= 1
        }
        if (direction == WEST) {
            roverx1 += 1
        }
        if (direction == SOUTH) {
            rovery1 += 1
        }
        if (direction == EAST) {
            roverx1 -= 1
        }
        return Position(roverx1, rovery1)
    }

    private fun moveForward(
            direction: Direction,
            position: Position
                           ): Position {
        var rovery1 = position.y
        var roverx1 = position.x
        if (direction == NORTH) {
            rovery1 += 1
        }
        if (direction == WEST) {
            roverx1 -= 1
        }
        if (direction == SOUTH) {
            rovery1 -= 1
        }
        if (direction == EAST) {
            roverx1 += 1
        }
        return Position(roverx1, rovery1)
    }
}
