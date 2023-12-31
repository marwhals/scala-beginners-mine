package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)
  // VALS are immutable, types can be inferred

  val aString: String = "hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 245367895435L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4
  aVariable = 5 //side effects

}
