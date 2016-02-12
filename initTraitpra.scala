trait A {
  val foo: String
}

trait B extends A {
  val bar = foo + "World"
}

class C extends B {
  val foo = "Hello"
  // nullWorldが出力される．
  def printBar(): Unit = println(bar)
}

// 処理遅延によるnullWorldの回避
//
trait B2 extends A {
  //処理遅延
  lazy val bar = foo + "World" // もしくはdef barでもよい
}

class C2 extends B2 {
  val foo = "Hello"
  // HelloWorldが出力される．
  def printBar(): Unit = println(bar)
}

// 事前定義によるnullWorldの回避
//
class C3 extends {
  val foo = "Hello" //スーパークラスの初期化の前に呼び出される
} with B {
  def printBar(): Unit = println(bar)
}
