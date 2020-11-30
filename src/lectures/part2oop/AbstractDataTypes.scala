package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract - do not supply values ?? - want the subclasses to do that for you
  // cannot be instantiated
  abstract class Animal {
    val creatureType: String = "Wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch") // override keyword not really needed here for compiler
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat" // non-abstract member
  }

  trait ColdBlooded {

  }

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"

    override def eat: Unit = println("nom nom nom")
    override def eat(animal: Animal): Unit = println(s"I'm a croc and I am eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat
  croc.eat(dog)

  // traits vs abstract classes
  // both have abstract and non-abstract members
  // traits do not have constructor parameters
  // multiple traits may be inherited by the same class (this is how you do multiple inheretance in scala)
  // traits = behavior, abstract class = "thing", traits describe what they do

}
