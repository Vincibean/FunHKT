package org.vincibean.fun.hkt

object BTree {

  implicit val treeFunctor: Functor[BTree] = new Functor[BTree] {
    def map[A, B](ta: BTree[A])(f: A => B): BTree[B] = ta match {
      case Leaf(a)    => Leaf(f(a))
      case Node(l, r) => Node(map(l)(f), map(r)(f))
    }
  }

  implicit val treeMonad: Monad[BTree] = new Monad[BTree] {
    override def pure[A](a: A): BTree[A] = Leaf(a)
    override def flatMap[A, B](ta: BTree[A])(f: A => BTree[B]): BTree[B] =
      ta match {
        case Leaf(a)    => f(a)
        case Node(l, r) => Node(flatMap(l)(f), flatMap(r)(f))
      }
  }

}

sealed trait BTree[+A]
case class Leaf[A](value: A) extends BTree[A]
case class Node[A](left: BTree[A], right: BTree[A]) extends BTree[A]
