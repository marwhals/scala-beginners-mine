package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    // use the type A for the class MyList[+A]
    def add[B >: A](element: B): MyList[B] = ???
  }

  class MyMap[Key, Value]
  //Works for traits as well

  val listOfIntegers = new MyList[Int] //Int will replace the generic of type A
  val listOfString = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList:  CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ------ so what happens if I add a dog to the list of cats
  // we return a list of animals....

  // 2. NO = INVARIANCE
  class InvariantList[A]
//  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  // Cats are animals
  // We are replacing a list of cats with a list of animals
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types class A only accepts types which are subtypes of animal
  // This is an upper bounded type of Animal
  // lower bound symbol is :>
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)


//  class Car
//  val newCage = new Cage(new Car) car does not subclass aniimal
}