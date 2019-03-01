package com.test

import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import com.test.domain._
import com.test.util.DeckGenerator
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.Await
import scala.concurrent.duration._

object HelloGame extends App with LazyLogging {

  val deck = DeckGenerator.generate(2000, 100)

  val cardAmount = deck.length

  logger info s"Current deck is: \n\t${deck.mkString("\n\t")}"

  val ded = Player("Ded")
  val god = Player("God")

  logger info s"New Game started. $ded VS $god"

  while (ded.hand.size < cardAmount / 2 && god.hand.size < cardAmount / 2 && deck.nonEmpty) {
    ded ++ deck.dequeue
    god ++ deck.dequeue
  }

  logger info s"""Hands: \n\t ${ded.name} : ${ded.hand.mkString(", ")} \n\t ${god.name} : ${god.hand.mkString(", ")}"""

  // Game with Actors

  val system = ActorSystem("card-game")

  val game = system.actorOf(Props[Game])

  implicit val timeout: Timeout = Timeout(5 seconds)

  def makeMove(round: Int): Unit = {
    val future = game ? Round(ded, god)
    val result = Await.result(future, timeout.duration).asInstanceOf[List[Player]]
    logger info s"round: $round, winners: ${result.mkString(" ")}"
  }

  logger info "LET THE GAME BEGIN!"

  (1 to cardAmount / 2).foreach(makeMove)

  logger info s"Game is done $ded wins: ${ded.winningAmount}, $god wins: ${god.winningAmount}"

  system.terminate()

}


