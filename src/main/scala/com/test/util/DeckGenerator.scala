package com.test.util

import com.test.domain.{Card, CardType}

import scala.collection.mutable
import scala.util.Random

object DeckGenerator {

  private def randomCardType(): CardType.Value = CardType(Random.nextInt(CardType.maxId))

  private def randomCardWeight(max: Int): Int = Random.nextInt(max)

  def generate(size: Int, maxCardWeight: Int): mutable.Queue[Card] = {

    val deck = mutable.Queue[Card]()

    (1 to size).foreach(i => {
      deck += Card(s"Card $i", randomCardType(), randomCardWeight(maxCardWeight))
    })

    Random.shuffle(deck)
  }

}
