object Devide {
  def devide(m: Int, n: Int): (Int, Int) = (m / n, m % n)
}

object EuclidAlgo {
  def euclidean_algorithm(m: Int, n: Int) {
    println(m + "," + n)
    val pair = Devide.devide(m, n)
    println(pair)
    pair match {
      case (a,0) => println(n)
      case (q,r) => euclidean_algorithm(n, r)
    }
  }
}

