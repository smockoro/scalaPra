class Point(val x: Int, val y: Int){
  def +(p: Point): Point = new Point(x + p.x, y + p.y)
  override def toString(): String = "(" + x + "," + y + ")"
}

class Adder {
  // カリー化された関数．この場合はobj.m(x)(y)の形式で呼び出す必要がある．
  // 部分適用もカリー化されているのでできる．
  def add(x: Int)(y: Int): Int = x + y
}

class PrinterA() {
  def print(): Unit = println("A")
}
class PrinterB() extends PrinterA {
  override def print(): Unit = println("B")
}


