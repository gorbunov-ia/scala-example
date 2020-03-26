object ForComprehensionExample extends App {
  val list1 = List(1, 3, 5, 6, 7)
  val list2 = List(2, 4, 6, 8)
  val list3 = List(1, 3, 5, 8, 10, 12, 14, 36)

  for {
    first <- list1
    second <- list2 if first != second
    sum <- list3 if first * second == sum
  } yield println(s"($first,$second)")

  def service1: Either[String, Double] = Right(1)
  def service2(res1: Double): Either[String, Int] = Right(2)
  def service3: String = "Result"
  def service4(res1: Double, res2: Int, res3: String): Either[String, String] = {
    Right(res3)
  }

  def result = for {
    x <- service1
    y <- service2(x)
    z = service3
    result <- service4(x, y, z)
  } yield result

  println(result)

  for { (k,v) <- Map("a" -> 1, "b" -> 2) } yield k
  //for { x <- Some(2); y <- List(1,2,3,4) } yield x + y
  for { x <- List(1,2,3,4) } x
  for { x <- Some(1) ; y <- None } yield (x, y)
  //for { x <- Some(1) ; y <- Left("year") } yield x + y

}
