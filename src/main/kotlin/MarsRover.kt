import command.Command
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
        var direction = Direction.fromChar(reader.next())
        var rover = Rover(position, direction)
        do {
            println("Insert command (f = forward, b = backward, l = turn left, r = turn right):")
            rover = Command.fromChar(reader.next()).execute(rover)
            println(String.format("Rover is at x:%d y:%d facing:%s",
                                  rover.position.x,
                                  rover.position.y,
                                  rover.direction.char))
        } while (true)
    }

}
