package dec1

import resources.resourceAsStrings

@main def foo =
  val text     = resourceAsStrings(path = "input_1")
  val calories = text.mkString.split("\n\n").map(_.split("\n").map(_.toInt))
  println(calories.map(_.sum).max)
  println(calories.map(_.sum).sorted.takeRight(3).sum)
