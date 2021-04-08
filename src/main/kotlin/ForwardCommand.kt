import Direction.EAST
import Direction.NORTH
import Direction.SOUTH
import Direction.WEST

class ForwardCommand : MoveCommand {
    override fun execute(direction: Direction, position: Position) = when (direction) {
        NORTH -> Position(position.x, position.y + 1)
        WEST  -> Position(position.x - 1, position.y)
        SOUTH -> Position(position.x, position.y - 1)
        EAST  -> Position(position.x + 1, position.y)
    }
}
