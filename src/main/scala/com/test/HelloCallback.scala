package com.test

object HelloCallback extends App with SimpleLog {

  def funcWithCallback(name: String, callback: () => Unit, anotherCallback: Option[() => Unit] = None): Unit = {
    log(name)
    callback() // Do callback
    anotherCallback.foreach(callable => callable()) // do callback if present
  }

  funcWithCallback("Func with both callbacks",
    () => log("Callback"),
    Some(() => log("Another Callback"))
  )

  funcWithCallback("Func with single callback", {
    () => log("Callback")
  })



}
