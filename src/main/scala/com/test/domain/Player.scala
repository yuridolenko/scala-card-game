package com.test.domain

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random

case class Player(name: String, hand: mutable.ListBuffer[Card] = ListBuffer(), var winningAmount: Int = 0) {

  override def toString: String = name

  def ++(card: Card): Unit = hand += card

  def peekCard(): Card = hand.remove(Random.nextInt(hand.length))

  def win(): Unit = winningAmount += 1

}
