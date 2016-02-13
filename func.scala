val add1 = new Function2[Int, Int, Int] {
  def apply(x: Int, y: int): Int = x + y
}

// Lambda type
val add2 = (x: Int, y: Int) => x + y

val addCurried = (x: Int) => ((y: Int) => x + y)

// Scalaでのメソッドと関数の扱い．
// メソッド・・・defで表現されるもの全て．変数にメソッドが入ることは無い．
// 関数・・・関数オブジェクトからできているサブインスタンス．変数にメソッドが入ることはある．

// 高階関数・・・関数を引数に取るor関数を返すメソッドや関数のこと
def double(n : Int, f: Int => Int): Int = {
  f(f(n))
}

// 初期化->何らかの処理->後始末処理 という典型パターンをメソッドにした高階関数
def around(init: () => Unit, body: () => Any, fin: () => Unit): Any = {
  init()
  try {
    body()
  } finally {
    fin()
  }
}

// 処理を値として利用する（関数を値として利用する）ことで，表現の自由度，部品化の仕方の自由度が高くなる．
