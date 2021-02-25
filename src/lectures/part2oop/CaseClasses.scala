package lectures.part2oop

object CaseClasses extends App {
  /*
  * equals, hasCode, toString - re-implement
  * case classes ideal solution to this problem
  * perfect for lightweight data holding class*/
  case class Person(name: String, age: Int)

  // class parameters are fields
  val jim = new Person ("Jim", 34)
  println(jim.name)

  // sensible toString
  println(jim.toString)
  // sytactic sugar - adds toString
//  println(jim) = println(jim.toString)
  println(jim)

  // equals and hasCode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) // would be false if not case class because they are two different references/implementations of
                       // the same class

  // handy copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // case classes have companion objects
  val thePerson = Person
  val mary = Person("mary", 23)

  // case classes are serializable - great for distributed systems
  // akka sends serializable messages through the network


  // case classes have extractor patterns - case classes can be used in pattern matching - super powerful

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
    // same attributes but no companion object because it already is an object...
  }
}
