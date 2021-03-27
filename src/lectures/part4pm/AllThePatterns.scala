package lectures.part4pm

import exercises._

object AllThePatterns extends App {

  // 1 constants
  val x: Any = "Scala"
  val constancts = x match {
    case 1 => "a number"
    case "Scala" => "the scala"
    case true => "the truth"
    case AllThePatterns => "a singleton object"
  }

  // 2 - match anything - i.e. wildcard
  val matchAnything = x match {
    case _ => "whatever" // wildcard
  }

  // 2.2 variable
  val matchAVariable = x match {
    case something => s"I've found $something"
  }

  // 3 - tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1) => "1 1"
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) => s"can then do something with ${v}" // pattern matches can be nested
  }

  // 4 - case classes - constructor pattern
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty => ""
    case Cons(head, Cons(subhead, subtail)) => "thing"
  }

  val aStandardList = List(1, 2, 3, 4)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => "extractor -- advanced"
    case List(1, _*) => "List of arbitrary length"
    case 1 :: List(_) => "infix pattern"
    case List(1, 2, 3) :+ 42 => "also infix pattern"
  }

  // type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => // explicit type specifier
    case _ => "wildcard"
  }

  // name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) => "binds name to the Cons pattern"
    case Cons(1, rest @ Cons(2, _)) => "name binding inside nested patterns"
  }

  // multi-patterns
  val multipattern = aList match {
    case Empty | Cons(0, _) => ""// compound pattern (multi-pattern)
  }

  // if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 => ""
  }

  val numbers = List(1, 2, 3)
  val numbersMatch = numbers match {
    case listOfString: List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of numbers" // type params erased here
    case _ => ""
  }

  println(numbersMatch)
}
