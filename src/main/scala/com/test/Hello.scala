package com.test

import com.typesafe.scalalogging.LazyLogging

object Hello extends App with LazyLogging {

  logger info "HW app"

  /*val immutableVar: String = "immutable value"
  lazy val lazyImmutableVar: String = "immutable value"

  var mutableVar: String = _

  println(s"immutable var: $immutableVar")
  println(s"lazy immutable var: $lazyImmutableVar")
  println(s"mutable var: $mutableVar")*/


  /* Generic functions */
  def genericFunc[T](param: T): T = {
    param match {

      case p: String =>
        println(s"String param is $p")
        p.asInstanceOf[T]

      case p: Int =>
        println(s"Int param is $p")
        p.asInstanceOf[T]

      case _ => param
    }
  }

  logger info s"string: ${genericFunc("generic string")} int: ${genericFunc(10)} double: ${genericFunc(.75)}"

  val genericFunctionWithFunctionParameterResult = genericFunc { a: Int => a * 2 }(4)

  printf(s"result id : $genericFunctionWithFunctionParameterResult")

}
