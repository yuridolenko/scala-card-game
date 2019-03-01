package com.test

import scala.util.Random

object HelloTailRecursive extends App with SimpleLog {

  val data = Random.shuffle(1 to 100 toList)

  log(s"data is $data")

  @annotation.tailrec
  def findElementIndex(value: Int, data: List[Int], index: Int = 0): Option[Int] = {
    if (data.length == index) {
      return None
    }

    if (data(index) == value) {
      return Some(index)
    }

    findElementIndex(value, data, index + 1)
  }

  log(s"index is:  ${findElementIndex(100, data)}")

}
