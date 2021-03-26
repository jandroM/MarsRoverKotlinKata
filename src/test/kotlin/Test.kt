import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.lang.Exception

class Test {

    @Test
    fun `it should move forward`(){
        val inputString = arrayOf("10", "20", "0", "0", "n", "f").joinToString("\n")
        val inputStream = ByteArrayInputStream(inputString.toByteArray())

        System.setIn(inputStream)

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        try {
            MarsRover.main(emptyArray())
        } catch (e: Exception){}

        val output = outputStream.toString().split("\n")
        assertEquals("Rover is at x:0 y:1 facing:n", output[output.size-3])
    }


    @Test
    fun `it should move backward`(){
        val inputString = arrayOf("10", "20", "0", "1", "n", "b").joinToString("\n")
        val inputStream = ByteArrayInputStream(inputString.toByteArray())

        System.setIn(inputStream)

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        try {
            MarsRover.main(emptyArray())
        } catch (e: Exception){}

        val output = outputStream.toString().split("\n")
        assertEquals("Rover is at x:0 y:0 facing:n", output[output.size-3])
    }

    @Test
    fun `it should turn right`(){
        val inputString = arrayOf("10", "20", "0", "0", "n", "r").joinToString("\n")
        val inputStream = ByteArrayInputStream(inputString.toByteArray())

        System.setIn(inputStream)

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        try {
            MarsRover.main(emptyArray())
        } catch (e: Exception){}

        val output = outputStream.toString().split("\n")
        assertEquals("Rover is at x:0 y:0 facing:e", output[output.size-3])
    }

    @Test
    fun `it should turn left`(){
        val inputString = arrayOf("10", "20", "0", "0", "n", "l").joinToString("\n")
        val inputStream = ByteArrayInputStream(inputString.toByteArray())

        System.setIn(inputStream)

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        try {
            MarsRover.main(emptyArray())
        } catch (e: Exception){}

        val output = outputStream.toString().split("\n")
        assertEquals("Rover is at x:0 y:0 facing:w", output[output.size-3])
    }



}
