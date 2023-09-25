package lectures.part2oop

object Exceptions extends App {

  val x: String = null

//  val someValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class
  // These classes are Exception and Error

  // catching exceptions

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    // code that mmight throw
    getInt(false)
  } catch {
    case e: RuntimeException => 43
  } finally {
    // code that will get executed no matter what
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects
    println("finally")
  }

  //custom exceptions
  class MyException extends Exception
  val exception = new MyException

//  throw exception


}
