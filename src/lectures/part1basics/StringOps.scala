package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning scala."
// all java functions that are also available in scala
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length())

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // scala-specific: string interpolators
  // s-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val greeting2 = s"Hello, my name is $name and I will be turning ${age + 1} years old"

  // f-interpolators - act as s interpolators but can also receive printf like formats
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw interpolater
  println(raw"this is a \n newline")
  val escaped = "this is a \n newline"
  println(raw"$escaped")

}
