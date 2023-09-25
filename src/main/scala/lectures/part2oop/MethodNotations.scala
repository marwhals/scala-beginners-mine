package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {
  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is haning out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}" // Scala quirk
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favouriteMovie) //Overloaded + operator
    def unary_! : String = s"$name, what the heck?!" // Scala quirk
    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)
    def isAlive : Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
    def apply(n: Int): String = s"$name watched $favouriteMovie $n times"
    def learns(thing: String) = s"$name is learns some $thing"
    def learnsScala = this learns "Scala" //postfix
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // Equivalent
  // infix notation = operator notation (syntactic sugar)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS.
  // Akka actors have ! ?
  //  prefix notation
  val x = -1 // equivalent with  1.unary_-
  val y = 1.unary_-
  // unary_prefix only works - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive) //Postfix notation

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  /*
  1. Overload the + operator
  mary + "the rockstar" => new person "Mary (the rockstar)"

  2. Add an age to the Person Class
  Add a unary + operator => new person with the age + 1
  +mary => mary with the age incremented

  3. Add a "learns" method in the Person class => "Mary learns Scala"
  Add a learnsScala method, calls learn method with "Scala".
  Use it in postfix notation.

  4. Overload the apply method
  mary.apply(2) => "Mary watched Inception 2 times"
  */

  println((mary + "the Rockstar").apply())
  println((+mary).age)
  println(mary learnsScala)
  println(mary(10))
}
