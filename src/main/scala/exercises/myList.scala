package exercises

abstract class MyList[+A] {
/*
  head = first element of the list
  tail = remainder of the list
  isEmpty = is this list empty
  add(int) => new list with ths element added
  toString => a string representation of the list

 */



  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"

  //the below are called hgher order functioins i.e they recieve functions as parameters or recive other functions as results
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  //concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

  //hofs
  def foreach(f: A => Unit): Unit


}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty

  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  //concatenation
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  def foreach(f: Nothing => Unit): Unit = ()
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements  //Scala 2 only, scala 3 requires a string interpolator

  def map[B](transformer:A => B): MyList[B] =
    new Cons(transformer(h),t.map(transformer))


  def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  //concatenation
  def ++[B >: A](list: MyList[B]) : MyList[B] = new Cons(h, t ++ list)

  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  //hofs
  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala",  Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

}