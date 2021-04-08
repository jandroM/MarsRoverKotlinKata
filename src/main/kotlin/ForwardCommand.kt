import Direction.EAST
import Direction.NORTH
import Direction.SOUTH
import Direction.WEST

class ForwardCommand : Command {
    override fun execute(rover: Rover) = when (rover.direction) {
        NORTH -> rover.copy(position = Position(rover.position.x, rover.position.y + 1))
        WEST  -> rover.copy(position = Position(rover.position.x - 1, rover.position.y))
        SOUTH -> rover.copy(position = Position(rover.position.x, rover.position.y - 1))
        EAST  -> rover.copy(position = Position(rover.position.x + 1, rover.position.y))
    }
}
