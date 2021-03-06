name := "scala-test"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq (
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
  "com.typesafe.akka" %% "akka-actor" % "2.5.21"
)