package lectures.part2oop

object Inheretance extends App {

  // single class inheretance
  class Animal { // super class
    protected def eat = println("nom nom nom") // private makes it inaccessible, protected allows it to be called but only if declared??
    val creatureType: String = "Wild"

  }

  class Cat extends Animal { // sub class
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age) // extends class with constructors

  // overriding
  class Dog(override val creatureType: String) extends Animal {
//    override protected def eat: Unit = super.eat
    override def eat: Unit = {
      super.eat
      println("NOM NOM")
    }

//    override val creatureType: String = "Domestic"
  }
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
//  unknownAnimal.eat // why won't this compile

  //overRIDING vs overLOADing (overwrite a method vs multiple methods with same name but different signitures

  // super

  // preventing overrides
  // 1 - use final on member keyword before def
  // 2 - use final on class itself
  // 3 - seal the class - extends classes in THIS FILE, but prevent extension in other files (keyword sealed)


}


