package lectures.part3fp

import scala.annotation.tailrec

object TuplesAndMaps extends App {

  // tuples - finit ordered "lists"
  val aTuple = (2, "hello, scala") // Tuple2[Int, String] = (Int, String)
  // can group at most 22 elements of different types
  println(aTuple._1) // _ to unpack
  println(aTuple.copy(_2 = "goodbye java"))
  println(aTuple.swap) // swaps the elemtns in place -> ("hello, scala", 2)

  // Maps - associate Keys -> values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map("Jim" -> 555, "Daniel" -> 789).withDefaultValue(-1) // tuples inside
  // a -> b is syntactic sugar for tuple (a, b)
  println(phonebook)

  // map ops
  println(phonebook.contains("Jim"))
  println(phonebook("Mary")) // if not key will throw NoSuchElement exception unless default value

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  // functionals on maps
  // map, flatMap, filter // apply to pairings
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))
  // filterKeys
  println(phonebook.filterKeys(x => x.startsWith("J")))
  // mapValues
  println(phonebook.mapValues(number => number * 10))

  // conversions to other collections
  println(phonebook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  val phonebookTest = Map("JIM" -> 999, "Jim" -> 555)
  println(phonebookTest.map(pair => pair._1.toLowerCase -> pair._2))
/*
* exercises
* 1. what would happen if I had two original entries "Jim" -> 555 and "JIM" -> 9000
* 2. Overly simplified social network based on maps
*   - Person - String - value is friends
*   - add a person to the network
*   - remove
*   - friend
*   - unfruend
*   stats:
*   - number of friends of a person
*   - person with most friends
*   - how many people have no friends
*   - if there is a social connection between two people (direct or not)
* */

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b) + b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    @tailrec
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))

  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")
  println(testNet)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size

  println(nFriends(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
    network.filterKeys(k => network(k).isEmpty).size

  println(nPeopleWithNoFriends(testNet))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    def bfs(target: S)
  }
}
