package com.test.util

import org.scalatest.{FlatSpec, Matchers}

class DeckGeneratorTest extends FlatSpec with Matchers {

  "DeckGenerator" should "generate deck with given size" in {
    val deck = DeckGenerator.generate(10, 10)
    deck should have size 10
  }

  "DeckGenerator" should "generate deck card weight not greater than given" in {
    val deck = DeckGenerator.generate(10, 10)
    deck.foreach(_.weight should be <= 10)
  }

}
