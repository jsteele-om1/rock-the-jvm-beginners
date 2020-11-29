package lectures.part2oop
import java.time.Year

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  println(person.x)
  person.greet("Daniel")
  person.greet

  // excercises:
  println("\n\nExercise 1:\n")
  val writer = new Writer("James", "Steele", 1995)
  val novel = new Novel("Learning Scala", 2019, writer)
  println(novel.authorAge(), novel.isWrittenBy(), novel.yearOfRelease)
  val newNovel = novel.copy(2020)
  println(newNovel.authorAge(), newNovel.isWrittenBy(), newNovel.yearOfRelease)

  println("\n\nExercise 2:\n")
  val counter = new Counter(4)
  println(counter.currentCount)
  val counter_inc1 = counter.increment()
  println(counter_inc1.currentCount)
  val counter_dec1 = counter.decrement()
  println(counter_dec1.currentCount)
  val counter_incn = counter.increment(5)
  println(counter_incn.currentCount)
  val counter_decn = counter.decrement(5)
  println(counter_decn.currentCount)
}
// constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2

  println(1 + 3)
  // value of codeblock is ignored??

  // method
  def greet(name: String): Unit =
    println(s"${this.name} says: Hi, $name")

  // overloading - multiple methods using the same name but different signitures (different number of params/ diff types)
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors - auxillary is impractical, better to use default parameter
  def this(name: String) = this(name, 0)

}
// class parameters are not fields, need val in front

// Exercises
// 1: Implement Novel and Writer Classes
//    - Writer: first name, surname, year of birth
//              methods: full name
//    - Novel: name, year of release, author (writer)
//          methods
//              - authorAge
//              - isWrittenBy(author)
//              - copy (new year of release) = new instance of Novel

class Writer(name: String, surname: String, val yearOfBirth: Int) {
  def fullname(): String = s"$name $surname"
}

class Novel(name: String, val yearOfRelease: Int, author: Writer) {
  def authorAge(): Int = yearOfRelease - author.yearOfBirth
  def isWrittenBy(): String = author.fullname()
  def copy(yearOfRelease: Int): Novel = new Novel(name, yearOfRelease, author)
}


// 2: Counter Class
//    - receives an int value
//    - method: returns current count
//    - method to increment/decrement counter by 1 => return new Counter
//    - overload inc/dec to receive param an amount by which

class Counter(val currentCount: Int) {
  def increment(): Counter = {
    println("incrementing")
    new Counter(currentCount + 1)
  }
  // immutability - instances should be fixed, need to return new instance rather than altering other instance
  def decrement(): Counter = {
    println("decrementing")
    new Counter(currentCount - 1)
  }
//  def increment(amount: Int): Counter = new Counter(currentCount + amount)
//  def decrement(amount: Int): Counter = new Counter(currentCount - amount)

  def increment(amount: Int): Counter = {
    if (amount <= 0) this
    else increment().increment(amount - 1)
//    new Counter(currentCount + amount)
  }
  def decrement(amount: Int): Counter = {
    if (amount <= 0) this
    else decrement().decrement(amount - 1)
    //    new Counter(
  }


}