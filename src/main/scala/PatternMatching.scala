//Известно, что все, кто говорит "meow" или "nya" - кошки, все, кого зовут "Rex" - собаки, а цифры "0" или "1"
//(обратите внимание, что нужно проверять наличие символов, а не целочисленных типов) в строке says есть только
//у роботов. (Кошек и роботов не могут звать "Rex", собаки не мяукают)
//
//Используя pattern-matching, определите вид питомца в переменной pet. Выведите "cat" для кошек, "dog" для собак,
//"robot" для роботов и "unknown" иначе.
object PatternMatching extends App {

  case class Pet(name: String, says: String)

  val pet = Pet("Rexx", "1000")
  val robotRegex = "[01]+".r

    val kind = pet match {
      case Pet(_, "meow") | Pet(_, "nya") => "cat"
      case Pet("Rex", _) => "dog"
      case Pet(_, robotRegex()) => "robot"
  //    case Pet(_, "0") | Pet(_, "1") => "robot"
      case _ => "unknown"
    }

  println(kind)

}
