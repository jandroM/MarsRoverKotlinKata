import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.lang.Exception

class Test {

    @Test
    fun `test`(){
        println("this is a test")
        val inputString = arrayOf("10", "20", "0", "0", "n", "f").joinToString("\n")
        val inputStream = ByteArrayInputStream(inputString.toByteArray())

        System.setIn(inputStream)

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        try {

            MarsRover.main(emptyArray())
        } catch (e: Exception){

        }

        val output = outputStream.toString().split("\n")

        assertEquals("Rover is at x:0 y:1 facing:n", output[output.size-3])

    }

}