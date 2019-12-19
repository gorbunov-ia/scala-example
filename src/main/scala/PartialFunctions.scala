object PartialFunctions extends App {

  val discount: PartialFunction[Jar, String] = {
    case x if x.value >= 5 && x.value <= 10 => x.name + " " + calcDisc(x, 5)
    case x if x.value > 10 => x.name + " " + calcDisc(x, 10)
  }

  def calcDisc(jar: Jar, percent: Int): Double = {
    jar.price / 100.0 * percent
  }

  case class Jar(name: String, value: Int, price: Double)

  val jars = List(Jar("Морской синий 6л", 6, 3000), Jar("Огненно-красный 12л", 12, 5000))

  println(jars.collect(discount))

  def swap3(tuple: (Int, Int, Int)): (Int, Int, Int) = (tuple._3, tuple._2, tuple._1)

}



