import scala.io.StdIn

object ForExample extends App {

  val n = StdIn.readInt()

  for {
    i <- 1 until n
    j <- 1 until n
  }
    if (BigInt(i).gcd(j) == 1)
      println(s"$i $j")
}
