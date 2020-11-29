package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 25) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickName: String): Person = new Person(s"$name ($nickName)", favoriteMovie)
    def unary_! : String = s"$name, what the heck??!!"
    def isAlive(): Boolean = true
    def apply(): String = s"Hi my name is $name and I like $favoriteMovie"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def learns(subject: String): String = s"$name learns $subject"
    def learnsScala(): String = learns("Scala")
    def apply(numWatched: Int): String = s"$name watched $favoriteMovie $numWatched times!"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent to above
  // intix notation = operation notation (only works with single parameter) -- sytactic sugar

  // "operators" in Scala - not reserved
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)

  // prefix notation
  val x = -1 // the - is a unary operator
  val y = 1.unary_- // equals same as above, they are actually methods
  // unary_prefix only works with a few operators - + ~ !

  println(!mary)

  // postfix notation
  println(mary.isAlive())
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  // Exercises
  println("\n\n\nExercises:\n")
  // 1. overload the + operator - return another person with name "Mary (the rockstart)"
  println(mary + "the rockstar")

  // 2. add age to person class with default 0 value and add unary + operator returns new person with age + 1
  println(mary.age)
  val maryOld = +mary
  println(maryOld.age)

  // 3. Add "learns" method in Person Class - receives string param and returns "Mary learns Scala"
  //    Add a learnScala method that doesn't receive any params and calls the learns method with scala as param
  //    use it in postfix notation
  println(mary.learns("Python"))
  println(mary.learnsScala())

  // 4. Overload the apply method mary.apply(2) "mary watched her {fav movie} {2} times
  println(mary(2))

}
