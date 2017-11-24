package org.vincibean.fun.hkt

import scala.language.higherKinds

object Functor {
  def apply[A[_] : Functor]: Functor[A] = implicitly[Functor[A]]
}

trait Functor[T[_]] {
  def map[A, B](ta: T[A])(f: A => B):  T[B]
}