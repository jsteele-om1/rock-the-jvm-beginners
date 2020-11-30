package lectures.part2oop

object Generics extends App {

  class MyList[A] {
    //use the type A (generic type)
    def add[B >: A](element: B): MyList[B] = ???
  }

  class MyMap[Key, Value] {
    // multiple types
  }

  // traits can also be type parameterized

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int] // returns MyList of Int

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  //    No, animalList.add(new Dog) ???
  //    will turn it into a list of animals and not a list of cats
  // 2.   invariance
  class InvariantList[A] // cannot substitute one for another
//  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]


  // 3. Hell, No!
  //    contravariance
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal] // this is better because can train all of the super??

  // bounded types
  // can use classes for certain types
  class Cage[A <: Animal](animal: A) // only accepts subtypes of animal
  val cage = new Cage(new Dog)

  class Car
//  val newCage = new Cage(new Car) // will error because outside of bounds

  // bounded types solve variance problem


  // expand MyList to be generic
}
