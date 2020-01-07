object DiffListExample extends App {

  val l1 = List(1,2,3)
  val l2 = List(4,5,6)
  val dl = new DiffListImpl[Int](identity)

  val resultList = dl.append(l2).prepend(l1).result // List(1,2,3,4,5,6)

  println(resultList)

}
final class DiffListImpl[A](listFunc: List[A] => List[A]) /*extends DiffList[A](listFunc)*/ {

  def prepend(s: List[A]) = new DiffListImpl[A](x => s ::: listFunc(x))

  def append(s: List[A]) = new DiffListImpl[A](x => listFunc(x) ::: s)

  def result = listFunc(Nil)
}
