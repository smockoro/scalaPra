trait TraitA {
  val name: String
  def printName(): Unit = println(name)
}

class ClassA(val name: String) extends TraitA

object ObjectA {
  // トレイトはクラスにすればインスタンス化できる
  val a = new ClassA("Takahiro")
  // 実装を与えてもインスタンス化できる
  val a2 = new TraitA { val name = "Oshima" }
  
  def printObjVal() = {
    println(a)
    println(a2)
  }
}


