package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  // Seq
  val aSequence = Seq(1, 3, 2, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5, 6, 7))
  println(aSequence.sorted)

  // ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 to 10).foreach(_ => println("Hello"))

  // lists
  val aList = List(1, 2, 3)
  val prepended = 42 :: aList // could also +: for prepending
  println(prepended)
  val appended = aList :+ 98
  println(appended)

  val apples5 = List.fill(5)("apple")
  println(apples5)

  println(aList.mkString("-"))

  // arrays - mutable
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Int](3)
  threeElements.foreach(println) // has default values depending on type - so 0 for Ints and null for strings for example

  // mutation
  numbers(2) = 0 // syntactic sugar for numbers.update(2, 0)
  println(numbers.mkString(" "))

  // arrays and seqs
  val numbersSeq: Seq[Int] = numbers // WrappedArray via implicit conversion
  println(numbersSeq)

  // vectors - default implementation for immutable sequences
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  // vectors vs lists
  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersRange = 1 to maxCapacity
  val numbersList = numbersRange.toList
  val numbersVector = numbersRange.toVector

  // saves reference to the tail
  // updating an element in middle takes much longer
  println(s"List: ${getWriteTime(numbersList)}")

  // depth of the tree is small
  // needs to replace an entire 32-element chunk
  println(s"Vector: ${getWriteTime(numbersVector)}")

}
