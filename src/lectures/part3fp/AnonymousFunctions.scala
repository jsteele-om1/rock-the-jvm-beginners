package lectures.part3fp

object AnonymousFunctions extends App {

  // anonymous function (LAMBDA)
  val doubler = (x: Int) => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething = () => 3 // no value lambda

  println(justDoSomething) // prints the function itself
  println(justDoSomething()) // the actual call - must use parentheses with lambda

  // curly braces with lambda
  val stringToInt = {(str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to (x: Int) => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b

  /*
  * Exercises
  * 1. replace all FunctionX calls with lambda
  * 2. Rewrite "spcial" adder as an anonymous function
  * */

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))

}
