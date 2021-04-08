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

    private fun moveRight(direction: Direction) = when (direction) {
        NORTH -> EAST
        EAST  -> SOUTH
        SOUTH -> WEST
        WEST  -> NORTH
    }

    private fun moveLeft(direction: Direction) = when (direction) {
        NORTH -> WEST
        WEST  -> SOUTH
        SOUTH -> EAST
        EAST  -> NORTH
    }

    private fun moveBackward(direction: Direction, position: Position) = when (direction) {
        NORTH -> Position(position.x, position.y - 1)
        WEST  -> Position(position.x + 1, position.y)
        SOUTH -> Position(position.x, position.y + 1)
        EAST  -> Position(position.x - 1, position.y)
    }

    private fun moveForward(direction: Direction, position: Position) = when (direction) {
        NORTH -> Position(position.x, position.y + 1)
        WEST  -> Position(position.x - 1, position.y)
        SOUTH -> Position(position.x, position.y - 1)
        EAST  -> Position(position.x + 1, position.y)
    }
}
