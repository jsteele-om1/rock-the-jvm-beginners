package lectures.part2oop

object AnonymousClasses extends App{
  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahahahahahaha")
  }

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi(): Unit = println(s"Hi my name is $name")
  }

  val jim = new Person("Jim") {
    override def sayHi(): Unit = println("Hi my name is Jim")
  }

}
