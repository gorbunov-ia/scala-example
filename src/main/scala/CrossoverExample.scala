import scala.collection.mutable

object CrossoverExample extends App {
  val points: List[Int] = List(1, 3)
  val chr1: List[Char] = List('x', 'x', 'x', 'x', 'x')
  val chr2: List[Char] = List('y', 'y', 'y', 'y', 'y')

  val res1: mutable.Buffer[Char] = mutable.Buffer[Char]()
  val res2: mutable.Buffer[Char] = mutable.Buffer[Char]()

  var currentPoint = 0
  var cross = false

  for (i <- 0 until chr1.size) {
    if (points.size > currentPoint && i + 1 > points(currentPoint)) {
        cross = !cross
        currentPoint += 1
    }
    if (cross) {
      res1 += chr2(i)
      res2 += chr1(i)
    } else {
      res1 += chr1(i)
      res2 += chr2(i)
    }
  }

  println(res1.mkString)
  println(res2.mkString)
}