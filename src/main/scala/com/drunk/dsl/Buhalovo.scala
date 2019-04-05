package com.drunk.dsl

import com.drunk.dsl.drinks.Shot

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

case class Buhalovo(description: String) {

  val drinkers: ListBuffer[Drinker] = mutable.ListBuffer[Drinker]()

  def +(drinker: Drinker): Buhalovo = {
    drinkers += drinker
    this
  }

  def buhat(shot: Shot): Buhalovo = {
    drinkers.foreach(_ drink shot)
    this
  }

  def ?(state: State.Value): ListBuffer[Drinker] = drinkers.filter(_.state == state)
}
