package com.drunk

import com.drunk.drinks.Shot

case class Drinker(name: String, grade: Grade.Value) {

  var state: State.Value = State.OK

  def drink(vodka: Shot): Unit = {
    if (state != State.DEAD) {
      state = State(state.id + 1)
    }
  }

}
