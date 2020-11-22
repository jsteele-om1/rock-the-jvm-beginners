package lectures.part1basics

object Functions extends App {

  def aFunction (a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFuncton(): Int = 42
  println(aParameterlessFuncton())
  println(aParameterlessFuncton) // this weirdly works?

  // functions is how we iterate
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  // when you need loops use recursion
  // this is a fundamental idea of functional programming, don't use imperative code

  def aFunctionWithSideEffects(aString: String): Unit = {
    println(aString)
    def aBigFunction(n: Int): Int = {
      def aSmallFunction(a: Int, b: Int) = a + b
      aSmallFunction(n, n - 1)
    }
  }


  //Exercises
  // 1. a greeting function (name, age) returns "Hi, my name is $name and I am $age years old
  def greetingFunction(name: String, age: Int): String = {
    "Hi my name is " + name + " and I am " + age + " years old."
  }
  println(greetingFunction("James", 25))

  // 2. Factorial function 1 * 2 * 3 * 4, will comput product up to n
  def factorialFunction(factorial: Int): Int = {
    if (factorial <= 0) 1
    else factorial * factorialFunction(factorial-1)
  }
  println(factorialFunction(3))


  // 3. Fibonacci function
  //    f(1) = 1
  //    f(2) = 1
  //    f(n) = f(n - 1) + f(n - 2)
  def fibonnacciFunction(n: Int): Int = {
    if (n <= 2) 1
    else fibonnacciFunction(n-1) + fibonnacciFunction(n-2)
  }
  println(fibonnacciFunction(4))

  // 4. test if number is prime
  def isPrime(n: Int): Boolean = {
//    if(n > 1 && n / 2)
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }
  println(isPrime(37))
  println(isPrime(44))
}
