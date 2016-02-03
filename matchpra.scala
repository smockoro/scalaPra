import java.util.Locale
class MatchNum(val num: Int)

class MatchList(val lst: List[Any])

object MatchSome {
    def printNum(matchnum : MatchNum) = matchnum.num match {
        case 1 => "One"
        case 2 => "Two"
        case _ => "other"
    }

    def printMatchList(mlst : MatchList) = mlst.lst match {
      case List("A",b,c,d,e) =>
        println("b = " + b + " c = " + c + " d = " + d+ " e = " + e)
      case _ =>
        println("Head is not A")
    }

    def printMatchListAs(mlst : MatchList) = mlst.lst match {
      case List(a@List("A"), x) =>
        println(a)
        println(x)
      case _ => println("Head List is not List('A')")

    def printMatchType(obj: Any) = obj match{
      case v:java.lang.Integer => println("Integer")
      case v:String => println(v.toUpperCase(Locale.ENGLISH))
      case v:List[_] => println("List[_]")
      case _ => println(obj)
    }

    def exChapterFive():Unit = {
      var i:Int = 0;
      while( i <= 1000 ){
        val tmp = new scala.util.Random(new java.security.SecureRandom()).alphanumeric.take(5).toList 
        tmp match {
          case List(a,b,c,d,e) if a == e => {
            println(tmp)
            i += 1
          }
          case _ => {} // {}はなにもしない関数を表している．
        }
      }
    }
}
