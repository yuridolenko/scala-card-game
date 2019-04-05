package com.drunk.dsl

import com.drunk.dsl.Grade.{EXPERT, JUNIOR, SENIOR}
import com.drunk.dsl.State.{DEAD, HAPPY, VERY_HAPPY}
import com.drunk.dsl.drinks.{Beer, Vodka, Wine}
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.ListBuffer

class DrunkDSLTest extends FlatSpec with Matchers {

  "Junior Drinker" should "die" in {
    val jun = Drinker("drinker", JUNIOR)

    jun drink Vodka() + 150 drink Vodka() + 50 drink Beer() + 250 drink Vodka() + 50 drink Wine() + 50
    jun drink Vodka() + 50

    assert(jun.state == DEAD)
  }

  "Senior Drinker" should "drink and get happy" in {
    val dima = Drinker("Dima", SENIOR)

    dima drink Beer() + 500 drink Beer() + 500

    assert(dima.state == VERY_HAPPY)
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
    val buhalovo = Buhalovo("friday") + Drinker("Dima", EXPERT) + Drinker("Ded", EXPERT) + Drinker("Shu", EXPERT) + Drinker("Kenny", JUNIOR)

    buhalovo buhat Vodka() + 50
    buhalovo buhat Vodka() + 50
    buhalovo buhat Vodka() + 50
    buhalovo buhat Vodka() + 50
    buhalovo buhat Vodka() + 50

    buhalovo ? HAPPY map (_.name) should contain allOf ("Dima", "Ded", "Shu")
    buhalovo ? DEAD map (_.name) should contain only "Kenny"
  }


}
