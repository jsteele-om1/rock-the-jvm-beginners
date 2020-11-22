package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42 // VALS are immutable, cannot be reassigned a new value
  println(x)
  // VALS are immutable, cannot be reassigned a new value
  // compiler can infer types, don't typpically mention the type

  val aString: String = "hello";
  // semicolons are allowed but typically not used because each expression is written on its own line

  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val anInt: Int = x
  val ashort: Short = 24123 // represented on 2 bits instead of 4
  val along: Long = 31023948710234987L // note L at end
  val aFloat: Float = 2.0f // note f at end
  val aDouble: Double = 3.2342 // no marker at end

  // variables
  var aVariable: Int = 4
  aVariable = 5 // can be reassigned
  // side effects - want to avoid side effects with functional programming but is sometimes necessary


}
