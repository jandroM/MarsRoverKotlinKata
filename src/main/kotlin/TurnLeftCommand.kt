import Direction.EAST
import Direction.NORTH
import Direction.SOUTH
import Direction.WEST

class TurnLeftCommand : Command {
    override fun execute(rover: Rover) = when (rover.direction) {
        NORTH -> rover.copy(direction = WEST)
        WEST  -> rover.copy(direction = SOUTH)
        SOUTH -> rover.copy(direction = EAST)
        EAST  -> rover.copy(direction = NORTH)
    }
}
