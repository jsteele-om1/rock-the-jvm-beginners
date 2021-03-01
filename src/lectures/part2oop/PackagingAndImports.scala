package lectures.part2oop

import java.sql

import playground.{PrinceCharming, Cinderella => Princess} // this says that whatever we define in this file will be a part of the lecturs.partoop package
// only use _ if you actually need it
import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2000)

  // import the package
  val princess = new Princess

  // use fully quallified name - another option
  val princess2 = new Princess // playground.Cinderella is a fully qualified name

  // packages are in a hierarchy
  // matching folder structure

  // package object -- pretty rareely used
  sayHello
  println(speedOfLight)

  val prince = new PrinceCharming

  // use fully qualified name or aliasing
  val d = new Date
  val sqlDate = new SqlDate(2019, 5, 3)

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
  // rarely need to worry about the default imports above
}
