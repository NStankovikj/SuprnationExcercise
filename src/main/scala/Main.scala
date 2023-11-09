import java.io.PrintWriter
import scala.io.Source
import scala.io.StdIn.readLine
import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    val defaultFileName: String = "data_test.txt"
    var continue = true

    while (continue) {

      println("Please select which file to evaluate:")
      println("1. data_big.txt")
      println("2. data_small.txt")
      println("3. data_test.txt")
      println("4. custom size triangle")

      val userInput = readLine("Enter your choice (1/2/3/4): ")

      implicit val fileName: String = userInput match {
        case "1" =>
          "data_big.txt"

        case "2" =>
          "data_small.txt"

        case "3" =>
          "data_test.txt"
        case "4" =>
          var validInput = false
          var fileName = ""

          while (!validInput) {
            val numberInput = readLine("Enter a number between 10 and 5000: ")
            try {
              val number = numberInput.toInt
              if (number >= 10 && number <= 5000) {
                fileName = createRandomDataTriangle(number)
                println(s"You selected Custom Option. Using fileName: $fileName")
                validInput = true
                continue = false
              } else {
                println("Invalid number. Please enter a number between 10 and 5000.")
              }
            } catch {
              case _: NumberFormatException =>
                println("Invalid input. Please enter a valid number.")
            }
          }
          fileName

        case _ =>
          defaultFileName
      }

      // Open the file for reading
      val source = Source.fromFile(fileName)

      //Test opening the doc and reading the rows
      println(getRowAtIndex(0).get.mkString(" "))

      // Close the file
      source.close
    }
  }

  /*
    Opens the file and creates an iterator with row indexes, so that we don't read the whole text doc at once
    Returns and reads only the row for the given index
  */
  private def getRowAtIndex(index: Int)(implicit fileName: String): Option[Array[Int]] = {
    val source = Source.fromFile(fileName)

    try {
      // Open the file for reading and assigning indexes to each row
      val rows = source.getLines().zipWithIndex

      // Finds the first(and only) element which has same index as the provided argument
      val result = rows.collectFirst {
        case (row, rowCount) if rowCount == index => row.split(" ").map(_.toInt)
      }
      result
    }
    finally {
      source.close
    }
  }

  /*
    Takes argument numRows and creates a file with that many rows in the triangle
    Returns name of the file
  */
  private def createRandomDataTriangle(numRows: Integer): String = {
    val filename = s"generatedFile_$numRows.txt"

    val writer = new PrintWriter(filename)

    for (row <- 1 to numRows) {
      val values = Array.fill(row)(Random.nextInt(100)) // Generate random integers (0-99)
      val rowString = values.mkString(" ")
      writer.println(rowString)
    }

    writer.close()
    filename
  }

}
