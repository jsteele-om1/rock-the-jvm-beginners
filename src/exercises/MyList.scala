package exercises

abstract class MyList[+A] {

  /*
  head = int first element of the list
  tail = remainder of the list
  isEmpty = boolean
  add: int = returns new list with this element added
  toString -> string representation of the list
   */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"
//  override def toString: String = super.toString
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App {
  val list = new Cons(1, Empty)
  println(list.head)

  val list2 = new Cons(1, new Cons(5, new Cons(2, Empty)))
  println(list2.head, list2.tail.head)

  println((list.add(4)).head)

  println(list.isEmpty)
  // polymorphic call
  println(list2.toString)
}
