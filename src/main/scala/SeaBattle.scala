import scala.io.StdIn

object SeaBattle extends App {
  type Point = (Int, Int)
  type Field = Vector[Vector[Boolean]]
  type Ship = List[Point]
  type Fleet = Map[String, Ship]
  type Game = (Field, Fleet)

//  def testValidateShip() = {
//    val ships = List(
//      List(),
//      List( (1,12) ),
//      List( (1,2),(1,4) ),
//      List( (1,2),(2,3) ),
//      List( (1,1),(1,2),(1,3),(1,4),(1,5)),
//      List( (1,1) ),
//      List( (2,2),(3,2) ),
//      List( (1,1),(1,2),(1,3),(1,4))
//    )
//    val expected = List(false,false,false,false,false,true,true,true)
//
//    for (i <- ships.indices) {
//      println(s"Now testing ship: ${ships(i)}")
//      val actual = validateShip(ships(i))
//      actual == expected(i) match {
//        case true => println(s"Passed!\texpected: ${expected(i)}\tactual: $actual\n")
//        case false => println(s"FAILED!\texpected: ${expected(i)}\tactual: $actual\n")
//      }
//    }
//  }
//  testValidateShip()

  val field: Field = Vector(
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false),
    Vector(false, false, false, false, false, false, false, false, false, false))

  var game: Game = (field, Map[String, Ship]())

  val shipNumber = StdIn.readLine().toInt
  for(i <- 0 until shipNumber) {
    val nameAndLength = StdIn.readLine().split(" ")
    var ship: Ship = List()
    for (j <- 0 until nameAndLength(1).toInt) {
      val points = StdIn.readLine().split(" ")
      val point: Point = (points(0).toInt, points(1).toInt)
      ship = ship :+ point
    }
    game = tryAddShip(game, nameAndLength(0), ship)
  }

  game._2.keySet.foreach(println)

  def validateShip(ship: Ship): Boolean = {
    if (ship.size <= 0 || ship.size > 4) {
      return false
    }
    val point = ship(0)
    if (ship.size == 1) {
      return point._1 >= 0 && point._1 < 10 && point._2 >= 0 && point._2 < 10
    }
    if (!isFlat(ship, _._1) && !isFlat(ship, _._2)) {
      return false
    }
    doValidateShip(ship, point._1, point._2)
  }

  def isFlat(ship: Ship, func: ((Int, Int)) => Int): Boolean = {
    ship.map(func).distinct.size == 1
  }

  @scala.annotation.tailrec
  def doValidateShip(ship: Ship, prevX: Int, prevY: Int): Boolean = {
    ship match {
      case Nil => true
      case point :: tail => if (point._1 >= 0 && point._1 < 10 && point._2 >= 0 && point._2 < 10
        && (Math.abs(prevX - point._1) <= 1 && Math.abs(prevY - point._2) <= 1)
      )
        doValidateShip(tail, point._1, point._2) else false
    }
  }

  // определить, можно ли его поставить
  def validatePosition(ship: Ship, field: Field): Boolean = {
    ship.forall(point => isFree(point, field))
  }

  def isFree(point: Point, field: Field): Boolean = {
    val x = point._1
    val y = point._2
    !LazyList(
      (x - 1, y + 1), (x, y + 1), (x + 1, y + 1),
      (x - 1, y), (x, y), (x + 1, y),
      (x - 1, y - 1), (x, y - 1), (x + 1, y - 1)
    ).filter(point => point._1 >= 0 && point._1 < field.size && point._2 >= 0 && point._2 < field.size)
      .exists(point => field(point._1)(point._2))
  }

  // добавить корабль во флот
  def enrichFleet(fleet: Fleet, name: String, ship: Ship): Fleet = {
//    println(name)
    fleet + (name -> ship)
  }

  // пометить клетки, которые занимает добавляемый корабль
  @scala.annotation.tailrec
  def markUsedCells(field: Field, ship: Ship): Field = {
    ship match {
      case Nil => field
      case point :: newSheep => markUsedCells(field.updated(point._1, field(point._1).updated(point._2, true)), newSheep)
    }
  }

  // логика вызовов методов выше
  def tryAddShip(game: Game, name: String, ship: Ship): Game = {
    if (validateShip(ship) && validatePosition(ship, game._1)) {
      val fleet = enrichFleet(game._2, name, ship)
      val field = markUsedCells(game._1, ship)
      (field, fleet)
    } else {
      game
    }
  }
}