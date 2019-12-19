import scala.annotation.tailrec

object Fibonacci extends App {

  val n = 6
  println(fibs(n))

//  0 + 1 + 1 + 2 + 3 + 5 + 8

  @tailrec
  def fibs(n: Int, currentNumber: Int = 1, f1: Long = 0, f2: Long = 1): Long = {
    if (n == currentNumber)
      f2
    else {
      //put your code here
      fibs(n, currentNumber + 1, f2, f1 + f2)
    }
  }
}


