package com.drunk.drinks

class Shot {

  var amount: Int = 0

  def +(amount: Int): Shot = {
    this.amount = amount
    this
  }

}

case class Vodka() extends Shot
case class Beer() extends Shot
case class Wine() extends Shot