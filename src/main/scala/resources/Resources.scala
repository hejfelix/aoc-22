package resources

def resourceAsStrings(path: String): List[String] =
  val buffer  = io.Source.fromResource(path)
  val strings = buffer.getLines().toList
  buffer.close()
  strings
