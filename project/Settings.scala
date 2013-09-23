import sbt._
import Keys._

object Settings {

  lazy val basicSettings = Seq(
    organization  := "edu.smagnacco",
    organizationName := "SergioMagnacco",
    scalaVersion  := "2.10.2",
    resolvers    ++= Dependencies.resolutionRepos,
    scalacOptions := Seq(
      "-encoding",
      "utf8",
      "-g:vars",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-target:jvm-1.7",
      "-language:postfixOps",
      "-language:implicitConversions",
      "-Xlog-reflective-calls"
    ),
    sourceGenerators in Compile <+= (sourceManaged in Compile, organization, version) map { (out: File, organization: String, version: String) =>
      val versionFile = out / "Version.scala"
      IO.write(versionFile, """package %s; object Version { val current="%s" }""".format(organization, version))
      Seq(versionFile)
    }
  ) 
}
