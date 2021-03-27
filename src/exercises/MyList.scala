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

  // higher-order functions - use functions as first class values
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B] (transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  //  concatenation
  def ++[B >: A] (list: MyList[B]): MyList[B]

  // hofs
  def foreach(f: A => Unit): Unit
  def sort(compare: (A, A) => Int): MyList[A]
  def zipWith[B, C](list: MyList[B], zip:(A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: Nothing = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B] (transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing] (list: MyList[B]): MyList[B] = list

  // hofs
  def foreach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int) = Empty
  def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] =
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Empty
  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  def ++[B >: A] (list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  def flatMap[B] (transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  // hofs
  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }
  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }
    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }
  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] =
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))
  def fold[B](start: B)(operator: (B, A) => B): B = {
//    val newStart = operator(start, head)
    t.fold(operator(start, head))(operator)
  }
}

// removing for now
//trait MyPredicate[-T] { // T-> Boolean
//  def test(elem: T): Boolean
//}
//
//trait MyTransformer[-A, B] { // A-> B
//  def transform(elem: A): B
//}

object ListTest extends App {
  val list1 = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list1.head)

  val list2 = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list2.head, list2.tail.head)

  val anotherList: MyList[Int] = new Cons(4, new Cons[Int](5, Empty))

  println((list1.add(4)).head)

  println(list1.isEmpty)
  // polymorphic call
  println(list2.toString)

  //  println(list1.m)

  println(list1.map(elem => elem * 2).toString)

  println(list1.filter(elem => elem % 2 == 0).toString)

  println((list1 ++ anotherList).toString)
  println("test flatmap")
  println(list1.flatMap(elem => new Cons(elem, new Cons(elem + 1, Empty))).toString)

  /// after case class implementation
  val cloneOfList1 = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(cloneOfList1 == list1)

  list1.foreach(println)

  println(list1.sort((x, y) => y - x))

  println(list1.fold(0)(_ + _))

}
