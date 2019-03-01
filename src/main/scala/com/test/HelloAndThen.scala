package com.test

object HelloAndThen extends App with SimpleLog {

  val doSomething = (name: String) => {
    log(s"Processing '$name'")

    s"'$name' is done"
  }

  val printResult = (result: String) => log(result)

  (doSomething andThen printResult) ("using andThen Function")

  (printResult compose doSomething) ("using compose Function")
}
