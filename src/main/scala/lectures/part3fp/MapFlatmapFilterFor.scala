package lectures.part3fp

object MapFlatmapFilterFor extends App {

  val list = List(1,2,3)
  println(list.head)
  println(list)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x : Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // print all combiniations between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("black", "white")

  //'iterations'.....
  val combinations = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  //These are the same except below is written to chains of map and flat map
  val combinations2 = for {
    _ <- colors :: List("not used color")
    n <- numbers
    x <- numbers.filter(x => x % 2 == 0)
    f <- numbers if n == 1
    c <- chars
    col <- colors
    _ <- colors :: List("not used color")
  } yield "" + c + n + "-" + col

  println(combinations)
  println(combinations2)

  //foreach
  list.foreach(println)

  //for comprehension

  //syntax overload
  list.map {
    x => x * 2
  }



}
