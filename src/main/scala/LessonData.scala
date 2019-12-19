object LessonData extends App {
  def searchInArray(cond: Int => Boolean, array: List[Int]): List[Int] = {
    array.filter(cond)
  }

  val searchOdd: List[Int] => List[Int] = list => LessonData.searchInArray(x => x % 2 == 1, list)

  println(searchOdd(List(8,11,12))) // List(11)

}