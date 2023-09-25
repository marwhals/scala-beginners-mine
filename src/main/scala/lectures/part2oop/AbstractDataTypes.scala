package lectures.part2oop

import com.sun.tools.internal.xjc.generator.bean.DualObjectFactoryGenerator

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")

  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    val creatureType: String = "croc"
    def eat: Unit = println("nomnomonom")
    def eat(animal: Animal): Unit = println(s"""I'm a croc and'm eating ${animal.creatureType}""")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  //traits vs abstract classes
  // 1 - traits do not have constructor parameters ****** In Scala 3 this is actually possible
  // 2 - multiple traits may be inherited  *** java only has single trait inheritance
  // 3 - traits are behaviour, abstract class = "thing"


}
