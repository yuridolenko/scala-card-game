name := "scala-card-game"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  /* Logger */
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",

  /* akka */
  "com.typesafe.akka" %% "akka-actor" % "2.5.21",

  /* Telegram */
  "com.bot4s" %% "telegram-core" % "4.0.0-RC2",
  "com.bot4s" %% "telegram-akka" % "4.0.0-RC2",

  /* Test */
  "org.scalatest" %% "scalatest" % "3.2.0-SNAP10" % Test,
  "org.scalacheck" %% "scalacheck" % "1.14.0" % Test
)

