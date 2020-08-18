name := "scalatest-silent"

lazy val commonSettings = Seq(
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.12.12",
  description := "ScalaTest AnyFunSpec it print issue",
  organization := "com.pomadchin",
  licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")),
  scalacOptions ++= Seq(
    "-deprecation",
    "-unchecked",
    "-feature",
    "-language:implicitConversions",
    "-language:reflectiveCalls",
    "-language:higherKinds",
    "-language:postfixOps",
    "-language:existentials",
    "-language:experimental.macros",
    "-feature",
    "-Ypartial-unification",
    "-target:jvm-1.8"
  ),

  addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full),
  addCompilerPlugin("org.scalamacros" %% "paradise" % "2.1.1" cross CrossVersion.full),

  libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.1" % Test,

  Global / cancelable := true,
  Test / fork := true,
  Test / parallelExecution := false,
  Test / connectInput := true,
  Test / testOptions += Tests.Argument("-oDF")
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .aggregate(silent)

lazy val silent = project.settings(commonSettings)
