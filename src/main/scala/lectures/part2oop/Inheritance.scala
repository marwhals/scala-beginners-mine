package lectures.part2oop

class Inheritance extends App {

  // single class inheritance
  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }
  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch  crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution  (broad sense: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat //Will use the overridden dog method despite being an animal

  // over riding vs over loading

  // super

  // preventing overrides
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - seal the class = extend  classes in this file,  prevent extension in other files

}
