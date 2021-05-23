case class A(x: Int, y: String)

object XXX {
  def main(a: Array[String]): Unit = {
    val f = A.apply _
    A.getClass.getMethods.foreach(println)
    val z = A.getClass.getMethods.find(_.getName == "fromProduct").get.invoke(A, new scala.Product{
      def canEqual(that: Any) = true
      def productArity = 2
      def productElement(n: Int) = n.match {
       case 0 => 2
       case 1 => "a"
     }
    })
    println(z)
    println(A(2, "a") == z)
  }
}
