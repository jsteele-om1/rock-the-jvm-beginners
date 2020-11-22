package lectures.part1basics

object Expressions extends App{

  val x = 1 + 2 // expression
  println(x)

  // + = * / & | ^ << >> >>> (right shift with 0 extension)

  println(1 == x)
  // == != > >=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= -- these are all side effects
  println(aVariable)

  // instructions vs expressions
  // instruction is something you tell computer to do (imperative)
  // expressions have value and or type - everything will compute a value

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // called an if expression not and if instruction
  println(aConditionedValue) // important to know, this is something that evaluates to something else

  // discourage using loops, don't return anything meaningful
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  // PLEASE NEVER WRITE THIS AGAIN
  // EVERYTHING IN SCALA IS AN EXPRESSION!!!!!!

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue) // side effects are units basically, and the value is ()

  // side effects: println(), whiles, reassigning

  // Code Blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  } // code block is an expression

}
