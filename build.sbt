name := "wedding"

organization := "org.longcao"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.8"

enablePlugins(JavaAppPackaging)

cancelable in Global := true

val http4sVersion = "0.15.0a"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-dsl"          % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion
)

