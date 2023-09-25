package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // Expression
  println(x)

  println(2 + 3 * 4)

  println(1 == x)

  println(!(1 == x))

  var aVariable = 2
  aVariable += 3  //also works with -= += /=
  println(aVariable)

  //Instructions (DO) vs Expressions (Value)
  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition)  5 else 3 //IF Expression
  println(aConditionedValue)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  //Everything in scala is an expression

  val aWeridValue  = (aVariable =  3) // Unit == void
  println(aWeridValue)

  //side effects: println(), whiles, reassignment

  //Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

}
