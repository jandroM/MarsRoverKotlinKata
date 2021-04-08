enum class Command(val char: String) {
    FORWARD("f"),
    BACKWARD("b"),
    LEFT("l"),
    RIGHT("r");

    companion object {
        fun fromChar(char: String): Command {
            return values().first { it.char == char }
        }
    }
}
