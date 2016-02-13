import org.scalatest._
import org.scalatest.concurrent.Timeouts
import org.scalatest.time.SpanSugar._
import org.scalamock.scalatest.MockFactory

class CalcSpec extends FlatSpec with DiagrammedAssertions with Timeouts with MockFactory {
  val calc = new Calc

  "sum:" should "Int配列を受け取りその和を返す" in {
    assert(calc.sum(Seq(1,2,3)) === 6)
    assert(calc.sum(Seq(0)) === 0)
    assert(calc.sum(Seq(-1,1)) === 0)
    assert(calc.sum(Seq()) === 0)
    assert(calc.sum(Nil) === 0)
  }

  it should "Intの最大を上回るとオーバーフロー" in {
    assert(calc.sum(Seq(Integer.MAX_VALUE, 1)) === Integer.MIN_VALUE)
  }

  "div:" should "Intを2つとり，その割った値をDoubleで返す" in {
    assert(calc.div(6, 3) === 2.0)
    assert(calc.div(1, 3) === 0.3333333333333333)
  }

  it should "0でわろうとすると実行時例外" in {
    intercept[ArithmeticException] {
      calc.div(1, 0)
    }
  }

  "isPrime: " should "引数が素数であるかBooleanで判定" in {
    assert(calc.isPrime(0) === false)
    assert(calc.isPrime(-1) === false)
    assert(calc.isPrime(2) === true)
    assert(calc.isPrime(17) === true)
  }

  it should "100万以下の値の素数判定を1秒以内に処理できる" in {
    failAfter(1000 millis) {
      assert(calc.isPrime(9999991))
    }
  }

  // おそらくモックはこのテストにこのオブジェクトがいるけど，いちいち生成したくない！ってときにつかえるのでは？
  "Calcのモックオブジェクト" should "振る舞いの偽装" in {
    val mockCalc = mock[Calc]
    (mockCalc.sum _).expects(Seq(3,4,5)).returning(12)
    assert(mockCalc.sum(Seq(3,4,5)) === 12)
  }
}


