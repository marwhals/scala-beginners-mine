package lectures.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need the factorial  of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }

  }

  println(factorial(10))

  def anotherFactorial(n: BigInt): BigInt = {
    @tailrec //Tells compiler that this function should be tail recursive
    def factHelper(x: BigInt, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) //  TAIL RECURSION - use recursive call  as the LAST expression

    factHelper(n, 1)
  }

  println(50000)

  /*
  anotherFactorial(10) = factHelper(10, 1)
  = factHelper(9, 10 * 1)
  = factHelper(8, 9 * 10  * 1)
  = factHelper(7, 8 * 9 * 10 * 1)
  = ...
  = factHelper(2, 3 * 4 * ... * 10 * 1)
  = factHelper(1, 2 * 3 * 4 * ... * 10 * 1)
  = 1 * 2 * 3 ..... * 10
   */

  // When you need loops use tail recursion
  @tailrec
  def concatenateTailrec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailrec(aString, n - 1, aString + accumulator)

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeTailrec(n / 2, true)
  }

  def fibonacci(n: Int): Int = {
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fiboTailRec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailRec(2, 1, 1)
  }

  println(fibonacci(8))


}
