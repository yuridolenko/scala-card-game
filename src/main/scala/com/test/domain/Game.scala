package com.test.domain

import akka.actor.Actor
import com.test.util.SimpleLog

case class Game() extends Actor with SimpleLog {

  def play(player1: Player, player2: Player): List[Player] = {
    val card1 = player1 peekCard()
    info(s"Player 1 peeked: $card1")

    val card2 = player2 peekCard()
    info(s"Player 2 peeked: $card2")

    card1 match {
      case card if card > card2 => List(player1)
      case card if card < card2 => List(player2)
      case _ => List(player1, player2)
    }
  }

  override def receive: Receive = {
    case Round(player1, player2) =>
      val winners = play(player1, player2)
      winners.foreach(_.win())
      sender ! winners
  }
}
