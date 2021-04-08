enum class Direction(val char: String) {
    NORTH("n"),
    EAST("e"),
    SOUTH("s"),
    WEST("w");

    companion object {
        fun fromChar(char: String): Direction {
            return values().first { it.char == char }
        }
    }
}
