trait GreetAbst {
  def greet(): Unit
}

// abstract override しないとこの場合はコンパイルエラー
//
// trait GreetCont extends GreetAbst {
//   override def greet(): Unit = {
//     super.greet()
//     println("Good evening")
//   }
// }

// コンパイルできる．
// 抽象クラスに対して，abstract overrideによって処理の積重ねが可能
trait GreetCont extends GreetAbst {
  abstract override def greet(): Unit = {
    super.greet()
    println("Good evening")
  }
}

trait GreetMixin extends GreetAbst{
  def greet(): Unit = {
    println("Hello")
  }
}

class ClassGreetC extends GreetMixin with GreetCont
