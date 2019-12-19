import scala.math.BigDecimal.RoundingMode
import scala.io.StdIn

object Example extends App {
  //  println(normalDistribution(1.0, 1.0, 1.0))
  //  println(crispsWeight(100, 0.99, 0.98))
  //  println(crispsWeight(90, 0.9, 0.1))
  //  println(amountOfOne())
  //  println(isCapital("Str", 0));
  //  println(reverse())
  //  println(snakeCase("snake_case"))

//  val accountAmounts = List(100, 200, 500, 300, 700)
//  val newAmounts = accountAmounts.map(amount => sendGift(amount, getGift()))
//  println(newAmounts)



  def plus: Int => Int => Int = x => y => x + y
  val plus2: Int => Int => Int = x => y => x + y
  val plus3: (Int, Int) => Int = (x, y) => x + y

  println(plus2(5)(4))

  def sendGift(currentAmount: Int, gift: => Int) = {
    if (currentAmount >= 500)
      currentAmount + gift
    else
      currentAmount
  }

  def getGift() = {
    println("The gift is received")
    100
  }

  def fibs(num: Int): Int = {
    if (num == 1) 1
    else if (num == 2) 1
    else fibs(num - 1) + fibs(num - 2)
  }

  def snakeCase(input: String): Boolean = {
    val regex = "^[a-zA-Z0-9]+(_[a-zA-Z0-9]+)*$".r
    regex.pattern.matcher(input).matches()
  }

  def reverse(): String = {
    val indexes = StdIn.readLine()
    val space = indexes.indexOf(' ')
    val startIndex = indexes.substring(0, space).toInt
    val endIndex = indexes.substring(space + 1).toInt
    val str = StdIn.readLine()
    val part = str.substring(startIndex, endIndex + 1)

    str.substring(0, startIndex) + part.reverse + str.substring(endIndex + 1)
  }

  def isCapital(word: String, pos: Int): Boolean = {
    val letter = word.charAt(pos)
    letter.isLetter && letter.isUpper
  }

  def amountOfOne(): Int = {
    val input = scala.io.StdIn.readLine()
    val chars = input.toInt.toBinaryString
    var result: Int = 0
    for (c <- chars) {
      if (c == 49) {
        result = result + 1
      }
    }
    result
  }

  def normalDistribution(mu: Double, sigma: Double, x: Double): Double = {
    val first: Double = 1 / (sigma * scala.math.sqrt(2 * scala.math.Pi))
    val second: Double = scala.math.pow(scala.math.E, -scala.math.pow(x - mu, 2) / (2 * scala.math.pow(sigma, 2)))
    first * second
  }


  def crispsWeight(weight: BigDecimal, potatoWaterRatio: Double, crispsWaterRatio: Double): BigDecimal = {
    val potatoWeight = (weight * (1.0 - potatoWaterRatio)).setScale(5, RoundingMode.HALF_UP)
    val percent = BigDecimal(1.0 - crispsWaterRatio).setScale(5, RoundingMode.HALF_UP)
    (potatoWeight / percent).setScale(5, RoundingMode.HALF_UP)
  }


}

