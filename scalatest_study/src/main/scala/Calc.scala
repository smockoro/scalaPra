class Calc {
  /**
   * 整数の配列から合計値を整数で返す
   * Intの最大を上回った際にはオーバーフロー
   * @param seq
   * @return
   */
  def sum(seq: Seq[Int]): Int = seq.foldLeft(0)(_ + _)

  /**
   * 整数を2つ受け取り，割った値を浮動小数点で返す
   * 0でわろうとした際には実行時例外
   * @param numerator
   * @param denominator
   * @return
   */
  def div(numerator: Int, denominator: Int): Double = {
    if( denominator == 0 ) throw new ArithmeticException("/ by zero")
    numerator.toDouble / denominator.toDouble
  }

  /**
   * 整数値を受け取り，素数であるかブール値を返す
   * @param n
   * @return
   */
  def isPrime(n: Int): Boolean = {
    if ( n < 2 ) false else !((2 to Math.sqrt(n).toInt) exists ( n % _ == 0))
  }
}
