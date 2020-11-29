package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  // this is how scala incorporates it
  object Person { // type + its only instance
    // static/class -level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person(name: String) {
    // instance level functionality
  }
  // COMPANIONS - object and class in the same scope and have same name -- will reside in class or in a singleton object

  println(Person.N_EYES)
  println(Person.canFly)

  // scala object = SINGLETON INSTANCE
  val mary = new Person("Mary") // this is instance of Person type
  val john = new Person("John")
  println(mary == john)

  val person1 = Person
  val person2 = Person
  println(person1 == person2)// point to the same object, no other code is needed

  val bobbie = Person(mary, john)

  // scala applications = scala object with
  // def main(args: Array([String]): Unit
}
