import sbt._
import Keys._
import com.typesafe.sbt.SbtAtmos.{Atmos, atmosSettings}

object Build extends Build {
  import Settings._
  import Dependencies._

  lazy val root = Project("akkagar",file("."))
    .settings(basicSettings: _*)
    .settings(libraryDependencies ++=
       compile(sprayCan, sprayRouting, sprayClient, sprayJson, slf4j, logback,
               akkaActor, akkaAgent, akkaSlf4j, akkaChannels,
               json4sJackson) ++
       test(scalaTest, akkaTestkit, sprayTestkit))
    .configs(Atmos)
    .settings(atmosSettings: _*)
    .settings(spray.revolver.RevolverPlugin.Revolver.settings: _*)
    .settings(net.virtualvoid.sbt.graph.Plugin.graphSettings: _*)
    .settings(org.scalastyle.sbt.ScalastylePlugin.Settings: _*)

}
