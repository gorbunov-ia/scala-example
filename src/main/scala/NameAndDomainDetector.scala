object NameAndDomainDetector extends App {

//  val input: List[String] = "oleg\noleg@email.com\n7bdaf0a1be3\na8af118b1a2\n28d74b7a3fe".split("\n").toList
  val input: List[String] = "oleg oleg@email.com\n7bdaf0a1be3\na8af118b1a2\n28d74b7a3fe".split("\n").toList

  val namePattern = "([a-zA-Z]+)".r
  val mailPattern = "\\w+@(\\w+\\.\\w+)".r
  val commonPattern = "([a-zA-Z]+) \\w+@(\\w+\\.\\w+)".r

  val result = input match {
    case List(namePattern(x), mailPattern(y), rest@_*) =>  x + " " + y
    case List(commonPattern(x, y), rest@_*) =>  x + " " + y
    case _ => "invalid"
  }
  println(result)
}
