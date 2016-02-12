trait GreetA {
  def greet(): Unit
}

trait GreetB extends GreetA {
  override def greet(): Unit = println("Good morning")
}

trait GreetC extends GreetA {
  override def greet(): Unit = println("Good evening")
}

// 継承順番を線形化して，後からミックスインされた方を優先している．
// GreetCが優先
class ClassGreetA extends GreetB with GreetC
// GreetBが優先
class ClassGreetB extends GreetC with GreetB

