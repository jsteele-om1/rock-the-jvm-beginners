package lectures.part3fp

object MapFlatmapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ %2 == 0))

  // flatmap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // print all combinations between two lists
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")

  val allPairs = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(allPairs)

  // foreach
  list.foreach(println)

  // short hand - for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0 // puts in a filter
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  println(forCombinations)

  // syntax overload
  list.map {x =>
    x * 2
  }

  /*
  * MyList supports for comprehensions?
  *  - map(f: A => B) => MyList[B]
  *  - filter(p: A => Boolean) => MyList[A]
  *  - flatMap(f:.....
  * Implement a small collection of at most 1 element - Maybe[+T]
  *  - map, flatMap, filter
  * */
}
