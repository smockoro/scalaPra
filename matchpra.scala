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
    }
}
