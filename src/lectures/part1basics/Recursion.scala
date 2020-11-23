package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need a factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)

      result
    }

  println(factorial(3))
  // output:
  /*
  Computing factorial of 3 - I first need a factorial of 2
  Computing factorial of 2 - I first need a factorial of 1
  Computed factorial of 2
  Computed factorial of 3
  6

  stack overflow errors can occur here if stack frame is too big
   */
  // each call of recursive function uses stack frame

  def anotherFactorial(n: Int): BigInt = {
    @tailrec // indicates this should be tail recursive
    def factorialHelper(x: Int, accumulator: BigInt): BigInt =
      if (x < 1) accumulator
      else factorialHelper(x - 1, x * accumulator)

    factorialHelper(n, 1)
  } // this doesn't force scala to reserve the same recursive stack frame
    // this is called tail recursion
   //  use recursive call as the last expression

  /*
  anotherFactorial(10) = factorialHelper(10, 1)
  = factorialHelper(9, 10 * 1)
  = factorialHelper(8, 9 * 10 * 1)
  = factorialHelper(7, 8 * 9 * 10 * 1)
  = ...
  = factorialHelper(2, 3 * 4 * ... * 10 * 1)
  = factorialHelper(1, 2 * 3 * ... * 10 * 1)
  = 1 * 2 * 3 * 4 ...
   */

  println(anotherFactorial(5000)) // returns 0 so blasts

  // when you need loops, use tail recursion!!!!!!

  // exercises
  // 1. Concatenate a string n times
  @tailrec
  def conc(s: String, n: Int, accumulator: String): String = {
//    @tailrec
    if (n <= 0) accumulator
    else conc(s, n-1, s+accumulator)

  }
  println(conc("hello ", 5, ""))


  // 2. Prime function that is tail recursive
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeAux(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t<=1) true
      else isPrimeAux(t-1, n % t != 0 && isStillPrime)
    }

    isPrimeAux(n/2, true)
  }
  println(isPrime(7))
  println(isPrime(100))

  // 3. Fibonacci function
}
