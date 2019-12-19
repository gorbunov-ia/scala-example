object MiddleElementSearcher extends App {

  def middle[T](data: Iterable[T]): T = {
    val size = data.size
    val tuple = data.splitAt(size / 2)
    tuple._2.head
  }

  require(middle("Scala") == 'a')
  require(middle(Seq(1, 7, 5, 9)) == 5)
}
