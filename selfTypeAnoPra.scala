trait Greeter {
  def greet(): Unit = println("Hello!")
}

// この場合，RobotオブジェクトはGreeterトレイトのgreetメソッドを呼び出せない．
trait Robot {
  self: Greeter =>

  def start(): Unit = greet()
}

// この場合，Robot2オブジェクトはGreeterトレイトのgreetメソッドを呼び出せる．
class Robot2 extends Greeter {
  def start(): Unit = greet()
}

// self Type anotetionを利用するとトレイトの相互参照を許す．
trait SayName {
  self: Flog =>

  def sayName(): Unit = println(s"My name is $name")
}

trait Flog {
  self: SayName =>

  val name: String
  def start(): Unit = sayName()
}

object objectFlog {
  val fs = new Flog with SayName { val name = "King" }
}
