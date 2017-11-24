package org.vincibean.fun.hkt

object Option {

  def apply[A](a: A): Option[A] = if (a == null) None else Some(a)

  implicit val optionFunctor: Functor[Option] = new Functor[Option] {
    def map[A, B](ta: Option[A])(f: A => B): Option[B] = ta match {
      case None => None
      case Some(a) => Some(f(a))
    }
  }

  implicit val optionMonad: Monad[Option] = new Monad[Option] {
    def pure[A](a: A): Option[A] = Some(a)
    def flatMap[A, B](ta: Option[A])(f: A => Option[B]): Option[B] = ta match {
      case None => None
      case Some(a) => f(a)
    }
  }

}

sealed trait Option[+A]
object None extends Option[Nothing]
case class Some[A](value: A) extends Option[A]