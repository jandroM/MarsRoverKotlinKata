interface Command {
    fun execute(rover: Rover): Rover

    companion object {
        fun fromChar(char: String): Command {
            return when (char) {
                "f"  -> ForwardCommand()
                "b"  -> BackwardCommand()
                "l"  -> TurnLeftCommand()
                "r"  -> TurnRightCommand()
                else -> throw Exception("Comando no valido")
            }
        }
    }
}
