package com.test

import com.typesafe.scalalogging.LazyLogging

trait SimpleLog extends LazyLogging{

  def log(message: String): Unit = logger info message

}
