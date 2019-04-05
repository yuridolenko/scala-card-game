package com.drunk

import com.drunk.Grade.JUNIOR
import com.drunk.State.{HAPPY, DEAD}
import org.scalatest.{FlatSpec, Matchers}
import com.drunk.drinks.{Beer, Vodka, Wine}

class DrinkerTest extends FlatSpec with Matchers {

  "Junior Drinker" should "drink and get happy" in {
    val drinker = Drinker("Dima", JUNIOR)

    drinker drink Vodka() +50

    assert(drinker.state == HAPPY)
  }

  "Drinker" should "die" in {
    val drinker = Drinker("Dima", JUNIOR)

    drinker drink Vodka() +150
    drinker drink Vodka() +50
    drinker drink Beer() +250
    drinker drink Vodka() +50
    drinker drink Wine() +50
    drinker drink Beer() +350
    drinker drink Vodka() +50

    assert(drinker.state == DEAD)
  }

}
