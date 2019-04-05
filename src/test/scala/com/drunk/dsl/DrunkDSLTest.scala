package com.drunk.dsl

import com.drunk.dsl.Grade.{EXPERT, JUNIOR, SENIOR}
import com.drunk.dsl.State._
import com.drunk.dsl.drinks.{Beer, Vodka, Wine}
import org.scalatest.{FlatSpec, Matchers}

class DrunkDSLTest extends FlatSpec with Matchers {

  "Junior Drinker" should "die" in {
    val jun = Drinker("Junior", JUNIOR)

    jun drink Vodka() + 150 drink Vodka() + 50 drink Beer() + 250 drink Vodka() + 50 drink Wine() + 50
    jun drink Vodka() + 50

    assert(jun.state == DEAD)
  }

  "Senior Drinker" should "drink and get happy and get very happy and die in the end" in {
    val senior = Drinker("Senior", SENIOR)

    assert(senior.state == OK)

    senior drink Beer() + 200

    assert(senior.state == HAPPY)

    senior drink Vodka() + 200

    assert(senior.state == VERY_HAPPY)

    senior drink Vodka() + 200

    assert(senior.state == SHIT)

    senior drink Vodka() + 200

    assert(senior.state == WOOD)

    senior drink Vodka() + 200

    assert(senior.state == DEAD)
  }

  "Expert Drinker" should "always be happy" in {
    val ded = Drinker("Ded", EXPERT)

    ded drink Vodka() + 50 drink Vodka() + 50 drink Vodka() + 50
    ded drink Vodka() + 50
    ded drink Vodka() + 50
    ded drink Vodka() + 50
    ded drink Vodka() + 50
    ded drink Vodka() + 50
    ded drink Beer() + 500

    assert(ded.state == HAPPY)
  }

  "Buhalovo" should "makes everybody happy" in {
    val buhalovo = Buhalovo("friday") + Drinker("Expert-1", EXPERT) + Drinker("Ded", EXPERT) + Drinker("Expert-2", EXPERT) + Drinker("Kenny", JUNIOR)

    buhalovo buhat Vodka() + 50
    buhalovo buhat Vodka() + 50
    buhalovo buhat Vodka() + 50
    buhalovo buhat Vodka() + 50
    buhalovo buhat Vodka() + 50

    val happyDrinkers = buhalovo whoIs HAPPY
    val deadDrinkers = buhalovo whoIs DEAD

    happyDrinkers  map (_.name) should contain allOf ("Expert-1", "Ded", "Expert-2")
    deadDrinkers map (_.name) should contain only "Kenny"
  }

}
