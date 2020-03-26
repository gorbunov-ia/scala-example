object ClassExample extends App {
  val waiter = new Waiter("иван", List.empty)
  val positions = waiter.giveMe("борщ").giveMe("хлеб").complete()
  println(positions)
}

class Waiter(guestName: String, var order: List[String]) {
  println(s"My name $guestName")

  def giveMe(dish: String): Waiter = {
    order = order :+ dish
    this
  }

  def complete(): List[String] = {
    order
  }
}