package org.vincibean.fun.hkt

import scala.language.higherKinds

object Monad {
  def apply[A[_]: Monad]: Monad[A] = implicitly[Monad[A]]
}

trait Monad[T[_]] {
  def pure[A](a: A): T[A]
  def flatMap[A, B](ta: T[A])(f: A => T[B]): T[B]
}
