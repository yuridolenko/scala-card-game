package com.drunk

import com.drunk.Grade.JUNIOR
import com.drunk.State.HAPPY
import org.scalatest.{FlatSpec, Matchers}
import com.drunk.drinks.Vodka

class DrinkerTest extends FlatSpec with Matchers {

  "Junior Drinker" should "drink and get happy" in {
    val drinker = Drinker("Dima", JUNIOR)

    drinker drink Vodka() +50

    assert(drinker.state == HAPPY)
  }

}
