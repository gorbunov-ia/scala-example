import scala.collection.mutable

object Collections extends App {
  val ints: List[Int] = List(0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0)

  val lists = splitZeros(ints)
  println(lists._1.mkString(","))
  println(lists._2.mkString(","))

  @scala.annotation.tailrec
  def splitZeros(ints: List[Int],
                 zeros: mutable.Buffer[String] = mutable.Buffer[String](),
                 other: mutable.Buffer[String] = mutable.Buffer[String]()): (mutable.Buffer[String], mutable.Buffer[String]) = {
    ints match {
      case Nil => (zeros, other)
      case e :: tail => if (e == 0) splitZeros(tail, zeros += e.toString, other)
      else splitZeros(tail, zeros, other += e.toString)
    }
  }

//  val ints: List[Int] = List(3, 8, 1, 12, 23)
//  println(kOrder(ints, 4))

  def kOrder(list: List[Int], k: Int): Int = {
    val res = list.sorted
    res(k - 1)
  }
}
