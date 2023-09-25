package lectures.part3fp

object AnonymousFunctions extends App {

  //this is an anonymous function or a lambda
  val double = (x : Int) => x * 2

  //multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  // care
  println(justDoSomething) // function itself
  println(justDoSomething()) // call

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // syntax sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int  = _ + _ // equivalent to (a,b) => a + b

  val superAdd = (x: Int) => (y: Int) => x + y //Currying
  println(superAdd(1)(3))

}
