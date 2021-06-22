package command

import Direction.EAST
import Direction.NORTH
import Direction.SOUTH
import Direction.WEST
import Position
import Rover

class BackwardCommand : Command {
    override fun execute(rover: Rover) = when (rover.direction) {
        NORTH -> rover.copy(position = Position(rover.position.x, rover.position.y - 1)) //rover.moveNorth()
        WEST  -> rover.copy(position = Position(rover.position.x + 1, rover.position.y)) //rover.moveWest()
        SOUTH -> rover.copy(position = Position(rover.position.x, rover.position.y + 1)) //rover.moveSouth()
        EAST  -> rover.copy(position = Position(rover.position.x - 1, rover.position.y)) //rover.moveEast()
    }
}
