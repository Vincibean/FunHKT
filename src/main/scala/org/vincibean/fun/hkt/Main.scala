package org.vincibean.fun.hkt

object Main extends App {
  val f: (Char, Int) => String = (a, b) => a.toString * b
  println(Lift.lift(List('a', 'b', 'c'), List(1, 2, 3))(f))
  println(Lift.lift(Option('a'), Option(3))(f))
  println(
    Lift.lift(Node(Leaf('a'), Node(Leaf('b'), Leaf('c'))): BTree[Char],
              Node(Leaf(3), Leaf(2)): BTree[Int])(f))
}
