// 非変
// 型パラメータをもったクラスG，型パラメータT1,T2があったとき
// T1=T2のときのみ
// val : G[T1] = G[T2]
// という代入が許される性質を非変という．
//
// 共変
// 型パラメータをもったクラスG，型パラメータT1,T2があったとき
// T1がT2を継承している時のみ（T2がT1の親のときのみ），
// val : G[T2] = G[T1]
// という代入が許される性質を共変という．
// クラス定義時に
// class G[+T]
// とすると共変になる．

trait Stack[+T] {
  def pop(): (T, Stack[T])
  def push[E >: T](e: E): Stack[E]
  def isEmpty(): Boolean
}

class NonEmptyStack[+T](private val top: T, private val rest: Stack[T]) extends Stack[T] {
  def push[E >: T](e: E): Stack[E] = new NonEmptyStack[E](e, this)
  def pop(): (T,Stack[T]) = {
    if (rest.isEmpty) {
      (top, EmptyStack)
    } else {
      (top, rest)
    }
  }
  def isEmpty(): Boolean = false
}

case object EmptyStack extends Stack[Nothing] {
  def pop(): Nothing = throw new IllegalArgumentException("empty stack")
  def push[E >: Nothing](e: E): Stack[E] = new NonEmptyStack[E](e, this)
  def isEmpty(): Boolean = true
}

object Stack {
  def apply(): Stack[Nothing] = EmptyStack
}

// 反変
// 型パラメータをもったクラスG，型パラメータT1,T2があったとき
// T1がT2を継承している時のみ（T2がT1の親のときのみ），
// val : G[T1] = G[T2]
// という代入が許される性質を共変という．
// クラス定義時に
// class G[-T]
// とすると共変になる．
// 親のクラスを子のクラスに代入できるという意味
