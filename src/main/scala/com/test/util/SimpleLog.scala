package com.test.util

import com.typesafe.scalalogging.LazyLogging

trait SimpleLog extends LazyLogging {

  def info(message: String): Unit = logger info message

  def warn(message: String): Unit = logger warn message

  def error(message: String): Unit = logger error message

}
