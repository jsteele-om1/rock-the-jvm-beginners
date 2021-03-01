package lectures.part2oop

object Exceptions extends App {

  val x: String = null
//  println(x.length)
  // this will crash with null pointer exception ^^
  // throwing and catching exceptions
 // how to throw exceptions
//  val aWeirdValue = throw new NullPointerException // valid but returns nothing, nothing is a valid substitute for any other type
  // NullPointerException is a valid class - so this is a new instance of that class

  // throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtypes
  // both will crash jvm
  // exceptions denote something that when wrong with the program (nullPointerException)
  // errors denote something that went wrong with the system - jvm - stackOverFlowError

  // how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42

  val potentialFail = try {
    // code that might throw
    getInt(true)
  } catch {
//    case e: RuntimeException => println("Caught a Runtime exception")
    case e: RuntimeException => 43
  } finally {
    // finally does not influence return type of this expressions - use finally only for side effects
    // code that will get executed no matter what
    println("finally")
  }

  println(potentialFail)

  // how to define your own exceptions
  class MyException extends Exception
//  val exception = new MyException
//  throw exception

  // exercises
  // crash program with an OutOfMemoryError
//  val array = Array.ofDim(Int.MaxValue)

  // Crash with stackoverflow error
  def stackOverflowCrasher(n: Int): Int = {
    n * stackOverflowCrasher(n)
  }

//  val stackOverflowCrash = stackOverflowCrasher(6)

  // PocketCalculator
  //  add(x,y)
  //  subtract(x,y)
  //  multiply(x,y)
  //  divide(x,y)
  // Throw
  //    - overflowexception if add(x,y) exceeds Int.MAX_VALUE
  //    - underflowexception if subtract or add exceeds Int.Min_Value
  //    - mathcalculationexception for division by 0
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
//      result
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }
    def subtract(x: Int, y: Int) = {
      val result = x - y
      result
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }
    def multiply(x: Int, y: Int) = {
      val result = x * y
      result
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new UnderflowException
      else result
      // more to add here for conditions but I get it...
    }
//    def subtract: Int = x - y
//    def multiply: Int = x * y
//    def divide: Int = x / y
  }
  println("working")
//  println(PocketCalculator.add(Int.MaxValue, 10))
//  println(PocketCalculator.subtract(Int.MinValue, -10))
}
