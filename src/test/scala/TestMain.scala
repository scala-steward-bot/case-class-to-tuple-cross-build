import AsTuple._

object TestMain {

  case class A(x1: Int, x2: String)

  case class B[T](x1: T, x2: List[T], x3: Option[T])

  def a = A(2, "a").asTuple

  def b = B[Boolean](false, List(true, false), Option(true)).asTuple

  def main(args: Array[String]): Unit = {
    a: (Int, String)
    b: (Boolean, List[Boolean], Option[Boolean])

    println(a)
    println(b)
  }

}
