package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.x)
  println(person.age)

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1812, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(imposter))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}

// constructor
class Person(name: String,val age: Int = 0) { //to convert a parameter to a field just use the key work val
  // body
  val x = 2

  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am ${this.name}")
//  def greet(): Int = 42

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

//class parameters are NOT fields

/*
  Novel and writer

  Writer: first name, surname, year
    - method fullname

  Novel: name, year of release, author
    - authorAge
    - isWrittenBy (author)
    - copy (new year of release) = new instance of Novel

*/

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName: String = firstName + " " + surname
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

class Counter(val count: Int = 0) { //same as defining a method that gets that field
  def inc = {
    println("incrementing")
    new Counter(count + 1)
  } // Immutability
  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(count)

}

