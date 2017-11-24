package org.vincibean.fun.hkt

object List {

  implicit val listFunctor: Functor[List] = new Functor[List] {
    def map[A, B](ta: List[A])(f: A => B): List[B] = ta match {
      case Nil        => Nil
      case Cons(h, t) => Cons(f(h), map(t)(f))
    }
  }

  implicit val listMonad: Monad[List] = new Monad[List] {
    def pure[A](a: A): List[A] = Cons(a, Nil)
    def flatMap[A, B](ta: List[A])(f: A => List[B]): List[B] = ta match {
      case Nil        => Nil
      case Cons(h, t) => concat(f(h), flatMap(t)(f))
    }
  }

  def concat[A](la: List[A], lb: List[A]): List[A] = la match {
    case Nil        => lb
    case Cons(h, t) => Cons(h, concat(t, lb))
  }

  def apply[A](a: A*): List[A] =
    if (a.isEmpty) Nil else Cons(a.head, apply(a.tail: _*))

}

sealed trait List[+A]
object Nil extends List[Nothing]
case class Cons[A](head: A, tail: List[A]) extends List[A]
