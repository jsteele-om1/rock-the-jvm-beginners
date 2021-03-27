package lectures.part3fp

object WhatsAFunction extends App {

  // DREAM: use functions as first class elements
  // problem: oop
  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types = Function{1, 2, ... 22}
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }
  // function types - Function2[A, B, R] === (A,B) => R
  // ALL SCALA FUNCTIONS ARE OBJECTS OR INSTANCES OF CLASSES DERIVING FROM FUNCTION1, FUNCTION2 ...

  /*
  * Exercises
  * 1. a function which takes 2 strings and concatenates them
  * 2. transform the MyPredicate and MyTransformer into function types
  * 3. define a function which which takes an int and returns another function which takes an int and returns and int
  *     - define the type of the function
  *     - how to do it
  * */
  
  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }
  println(concatenator("hello ", "scala"))

  // Function1[Int, Function1 [Int, Int]]
  val superAdder: Function1[Int, Function1 [Int, Int]] = new Function1[Int, Function1 [Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3) // this val is a new function
  println(adder3(4)) // implementation is the nested override
  println(superAdder(3)(4)) // returns the same thing as above - called a curried function

  //use functions as first class elements - work with functions just like any other values
  // all scala functions are objects!


}

trait MyFunction[A, B] {
  def apply(element: A): B = ???
}