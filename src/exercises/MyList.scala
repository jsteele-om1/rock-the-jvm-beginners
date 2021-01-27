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


  // no idea what is happenning here
  def map[B] (transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B] (transformer: MyTransformer[A, MyList[B]])
  def filter(predicate: MyPredicate[A]): MyList[A]

  // concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

  def map[B] (transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  def flatMap[B] (transformer: MyTransformer[Nothing, MyList[B]]) = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  def ++[B>: Nothing](list: MyList[B]): MyList[Nothing] = Empty
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  def map[B] (transformer: MyTransformer[A, B]): MyList[B] =
    new Cons(transformer.transform(h), t.map(transformer))
  def flatMap[B] (transformer: MyTransformer[Nothing, MyList[B]]) = Empty
  def filter(predicate: MyPredicate[A]): MyList[A] =
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  // if I concat [1,2] ++ [[3,4,5] = new Cons(1, [2] ++ [3, 4, 5]) - remember recursion
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  def flatMap[B] (transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer) // why isn't this working


}

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(element: A): B
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

  println(list2.map(new MyTransformer[Int, Int] {
    override def transform(element: Int): Int = element * 2
  }).toString)

  println(list2.filter(new MyPredicate[Int] {
    override def test(element: Int): Boolean = element % 2 ==0
  })toString)

}
