interface MoveCommand {
    fun execute(direction: Direction, position: Position): Position
}
