package command

import Direction.EAST
import Direction.NORTH
import Direction.SOUTH
import Direction.WEST
import Rover

class TurnRightCommand : Command {
    override fun execute(rover: Rover) = when (rover.direction) {
        NORTH -> rover.copy(direction = EAST)
        WEST  -> rover.copy(direction = NORTH)
        SOUTH -> rover.copy(direction = WEST)
        EAST  -> rover.copy(direction = SOUTH)
    }
}
