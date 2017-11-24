name := "FunHKT"

version := "0.1"

scalaVersion := "2.12.4"

scalafmtOnCompile in ThisBuild := true

lazy val compileScalastyle = taskKey[Unit]("compileScalastyle")

// scalastyle >= 0.9.0
compileScalastyle := scalastyle.in(Compile).toTask("").value

(compile in Compile) := ((compile in Compile) dependsOn compileScalastyle).value
