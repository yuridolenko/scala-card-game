package com.drunk

import com.drunk.Grade.{JUNIOR, SENIOR, EXPERT}
import com.drunk.State.{HAPPY, VERY_HAPPY, DEAD}
import org.scalatest.{FlatSpec, Matchers}
import com.drunk.drinks.{Beer, Vodka, Wine}

class DrinkerTest extends FlatSpec with Matchers {

  "Junior Drinker" should "die" in {
    val jun = Drinker("drinker", JUNIOR)

    jun drink Vodka() +150 drink Vodka() +50 drink Beer() +250 drink Vodka() +50 drink Wine() +50
    jun drink Vodka() +50

    assert(jun.state == DEAD)
  }

  "Senior Drinker" should "drink and get happy" in {
    val dima = Drinker("Dima", SENIOR)

    dima drink Beer() +500 drink Beer() +500

    assert(dima.state == VERY_HAPPY)
  }

  "Expert Drinker" should "always be happy" in {
    val ded = Drinker("Ded", EXPERT)

    ded drink Vodka() +50 drink Vodka() +50 drink Vodka() +50
    ded drink Vodka() +50
    ded drink Vodka() +50
    ded drink Vodka() +50
    ded drink Vodka() +50
    ded drink Vodka() +50
    ded drink Beer() +500

    assert(ded.state == HAPPY)
  }



}
