package lectures.part2oop

object CaseClasses extends App {

  //Case classes provide a lot default methods for a class in one go. Good for lightweight data holding classes

  case class Person(name: String, age: Int)

  //1. class paramters are fields
  //2. sensible toString method - println instance is useful as well
  //3. equalls and hashcode are implmented out of the box
  //4. CCs have handy copy methods - they also can recieve new parameters
  //5. CCS have companion objects
  // -- apply method allows the object to be calld like a function. Apply is like a constuctor
  //6. CCs are serializable -- good for passing data between machines
  //7. CCs have extractor patterns ---> CCs can be used in pattern matching
  //8. Case objects ----> like classes but they are their own companion object
  val jim = new Person("Jim", 34)
  println(jim.name)
  val jim3 = jim.copy(age = 45)
  val thePerson = Person

}
