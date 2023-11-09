import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    implicit val fileName: String = "data_small.txt" // Replace with your file's name or path

    // Open the file for reading
    val source = Source.fromFile(fileName)

    //Test opening the doc and reading the rows
    println(getRowAtIndex(0).get.mkString(" "))
    println(getRowAtIndex(1).get.mkString(" "))
    println(getRowAtIndex(2).get.mkString(" "))
    println(getRowAtIndex(3).get.mkString(" "))

    // Close the file
    source.close
  }

  /*
    Opens the file and creates an iterator with row indexes, so that we don't read the whole text doc at once
    Returns and reads only the row for the given index
  */
  def getRowAtIndex(index: Int)(implicit fileName: String): Option[Array[Int]] = {
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

}
