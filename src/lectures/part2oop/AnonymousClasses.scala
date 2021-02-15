package lectures.part2oop

object AnonymousClasses extends App {
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

  // create generic train MyPredicate[T]

  // generic trait called mytransformer [A, B]

  /*
  * mylist:
  *   map(transformer) -> mylist
  *   filter(predicat -> mylist
  *   flatmap -> takes transformer from A to Mylist[B] -> Mylist[B]
  * */

}
