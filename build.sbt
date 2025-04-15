def Scala213 = "2.13.16"
def Scala3 = "3.0.2"

scalaVersion := Scala213

crossScalaVersions := Seq(Scala213, Scala3)

libraryDependencies ++= {
  if (CrossVersion.partialVersion(scalaVersion.value).exists(_._1 == 2)) {
    Seq("com.chuusai" %% "shapeless" % "2.3.13")
  } else {
    Nil
  }
}
