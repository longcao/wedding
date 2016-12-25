name := "wedding"

organization := "org.longcao"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.8"

enablePlugins(JavaAppPackaging)
enablePlugins(SbtTwirl)

cancelable in Global := true

fork in run := true

val http4sVersion = "0.15.0a"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-dsl"          % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-twirl"        % http4sVersion
)

