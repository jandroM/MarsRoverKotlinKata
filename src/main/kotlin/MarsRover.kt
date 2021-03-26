import java.util.*
import kotlin.jvm.JvmStatic

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
        println("Insert initial rover direction:")
        var roverz = reader.next() //n = north, e = east, w = west, s = south
        do {
            println("Insert command (f = forward, b = backward, l = turn left, r = turn right):")
            val command = reader.next()
            if (command == "f") {
                val pair = moveForward(roverz, rovery, roverx)
                roverx = pair.first
                rovery = pair.second
            }
            if (command == "b") {
                val pair = moveBackward(roverz, rovery, roverx)
                roverx = pair.first
                rovery = pair.second
            }
            if (command == "l") {
                roverz = moveLeft(roverz)
            }
            if (command == "r") {
                roverz = moveRight(roverz)
            }
            println(String.format("Rover is at x:%d y:%d facing:%s", roverx, rovery, roverz))
        } while (true)
    }

    private fun moveRight(roverz: String?): String? {
        var roverz1 = roverz
        if (roverz1 == "n") {
            roverz1 = "e"
        } else if (roverz1 == "e") {
            roverz1 = "s"
        } else if (roverz1 == "s") {
            roverz1 = "w"
        } else if (roverz1 == "w") {
            roverz1 = "n"
        }
        return roverz1
    }

    private fun moveLeft(roverz: String?): String? {
        var roverz1 = roverz
        if (roverz1 == "n") {
            roverz1 = "w"
        } else if (roverz1 == "w") {
            roverz1 = "s"
        } else if (roverz1 == "s") {
            roverz1 = "e"
        } else if (roverz1 == "e") {
            roverz1 = "n"
        }
        return roverz1
    }

    private fun moveBackward(
        roverz: String?,
        rovery: Int,
        roverx: Int
    ): Pair<Int, Int> {
        var rovery1 = rovery
        var roverx1 = roverx
        if (roverz == "n") {
            rovery1 -= 1
        }
        if (roverz == "w") {
            roverx1 += 1
        }
        if (roverz == "s") {
            rovery1 += 1
        }
        if (roverz == "e") {
            roverx1 -= 1
        }
        return Pair(roverx1, rovery1)
    }

    private fun moveForward(
        roverz: String?,
        rovery: Int,
        roverx: Int
    ): Pair<Int, Int> {
        var rovery1 = rovery
        var roverx1 = roverx
        if (roverz == "n") {
            rovery1 += 1
        }
        if (roverz == "w") {
            roverx1 -= 1
        }
        if (roverz == "s") {
            rovery1 -= 1
        }
        if (roverz == "e") {
            roverx1 += 1
        }
        return Pair(roverx1, rovery1)
    }
}