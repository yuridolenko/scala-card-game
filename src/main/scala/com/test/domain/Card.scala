package com.test.domain

case class Card(text: String, cardType: CardType.Value, weight: Int) {

  override def toString = s"$cardType: $text, weight: $weight"

  def >(card: Card): Boolean = weight > card.weight
  def <(card: Card): Boolean = weight < card.weight

}