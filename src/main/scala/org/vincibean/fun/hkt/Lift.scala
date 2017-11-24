package org.vincibean.fun.hkt

import scala.language.higherKinds

object Lift {

  def lift[A, B, C, T[_] : Functor : Monad](ta: T[A], tb: T[B])(f: (A, B) => C): T[C] = {
    Monad[T].flatMap(ta) { a =>
      Functor[T].map(tb)(b => f(a, b))
    }
  }

}