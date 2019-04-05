package com.drunk.dsl

import com.drunk.dsl.drinks.Shot

case class Drinker(name: String, grade: Grade.Value) {

  var state: State.Value = State.OK

  def drink(vodka: Shot): Drinker = {
    if (grade == Grade.EXPERT) {
      state = State.HAPPY
    } else if (state != State.DEAD) {
      state = State(state.id + 1)
    }
    this
  }

}