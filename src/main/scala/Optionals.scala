import PartialFunctions.{Jar, calcDisc}

object Optionals extends App {

  //  println(foo(List(1, 2, 3, 4, 5, 6)) == 6)

  def foo(list: List[Int]): Int = {
    list.find(item => item % 3 == 0)
      .map(digit => digit * 2)
      .getOrElse(0)
  }

//  println(divide(1, 3)(1, 2))

  def divide(p: (Int, Int))(q: (Int, Int)): Either[String, (Int, Int)] = {
    if (!isRightFraction(p) || !isRightFraction(q)) {
      return Left("Invalid input")
    }
    if (p._2 == 0 || q._1 == 0) {
      return Left("Zero divisor")
    }
    var result = (p._1 * q._2, p._2 * q._1)
    if (!isRightFraction(result)) {
      return Left("Improper result")
    }
    val gcd = BigInt(result._1).gcd(result._2).toInt
    if (gcd != 1) {
      result = (result._1 / gcd, result._2 / gcd)
    }
    Right(result)
  }

  def isRightFraction(p: (Int, Int)): Boolean = {
    Math.abs(p._1) < Math.abs(p._2)
  }

  println(flatten(List(Option(1), Option.empty, Option(3))))

  def flatten(options: List[Option[Int]]): List[Int] = {
    options.collect(convert)
  }

  def convert: PartialFunction[Option[Int], Int] = {
    case Some(x) => x
  }

}
