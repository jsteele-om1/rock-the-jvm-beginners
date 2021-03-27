package lectures.part4pm

object PatternsEverywhere extends App {

  // big idea 1
  try {
    // code
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }
  // that's like try code catch something return e match

  val list = List(1, 2, 3)
  val even = for {
    x <- list if x % 2 == 0
  } yield 10 * x

  // generators are also based on pattern matching
  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second

  // case classes, :: operators, ...

  // big idea
  val tuple = (1, 2, 3)
  val (a, b, c) = tuple

  // multiple value definition based on pattern matching
  val head :: tail = list
  println(head)
  println(tail)

  // big idea 4 - new - partial function
  val mappedList = list.map{
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something else"
  } // partial function literal

  println(mappedList)

}
