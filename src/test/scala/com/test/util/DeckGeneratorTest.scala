package com.test.util

import org.scalatest.{FlatSpec, Matchers}

class DeckGeneratorTest extends FlatSpec with Matchers {

  "DeckGenerator" should "generate deck with given size" in {
    val deck = DeckGenerator.generate(10, 10)
    deck.size should be (10)
  }

}
