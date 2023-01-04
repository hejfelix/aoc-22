package dec2

import resources.resourceAsStrings

enum Play:
  case Rock, Paper, Scissors

  def points = this match
    case Rock     => 1
    case Paper    => 2
    case Scissors => 3

  def beats(that: Play) = (this, that) match
    case (Rock, Scissors) | (Paper, Rock) | (Scissors, Paper) => true
    case _                                                    => false

  def pointsAgainst(that: Play) = (this, that) match
    case _ if this.beats(that) => 6 + this.points // win
    case (x, y) if x == y      => 3 + this.points // draw
    case _                     => 0 + this.points // loss
end Play

object Play:
  def fromChar(c: Char): Play = c match
    case 'A' | 'X' => Rock
    case 'B' | 'Y' => Paper
    case 'C' | 'Z' => Scissors
end Play

@main def main =
  val input: List[String]        = resourceAsStrings(path = "input_2")
  val parsed: List[(Play, Play)] = input.map(s => (Play.fromChar(s.head), Play.fromChar(s.last)))

  val points: List[Int] = parsed.map((opponent, me) => me.pointsAgainst(opponent))
  println(points.sum)
