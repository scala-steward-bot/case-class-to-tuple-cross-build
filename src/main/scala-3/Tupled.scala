import scala.deriving.Mirror._
import scala.quoted._

object Tupled {
  transparent inline def tupled[A]: Any = 
    ${tupledImpl[A]}

  def tupledImpl[A](using a: Type[A], q: Quotes): Expr[Any] = {
    import q.reflect._

    val companion = TypeRepr.of[A].typeSymbol.companionModule
//    println(companion)
    val List(x) = companion.memberMethod("apply")
   
//    println(x)
    val (x3, n) = x.tree.match {
      case x1: DefDef =>
    //  println(x1)
        x1.paramss.map(_.params).head.match { 
          case x2: List[ValDef] =>
            (x1, x2)
        }
    }
    println(n.map(_.name))
    val z = Lambda(
      companion,
      MethodType(n.map(_.name))(_ => Nil, _ => TypeRepr.of[A]), 
      (sym, params) => Apply(x3.asExpr.asTerm, Nil)
    )
    z.asExpr
    //'{ 1 }
  }
}
