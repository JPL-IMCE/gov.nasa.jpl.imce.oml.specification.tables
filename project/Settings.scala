import sbt._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

object Settings {

  val name = "jpl.omf.schema.tables"

  val organization = "gov.nasa.jpl.imce"

  val version = "0.9.0"

  val scalacOptions = Seq(
    "-deprecation",
    "-encoding", "UTF-8",     // yes, this is 2 args
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xlint",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",       // N.B. doesn't work well with the ??? hole
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    "-Xfuture",
    "-Ywarn-unused-import",   // 2.11 only
    "-Yno-imports"            // no automatic imports at all; all symbols must be imported explicitly
  )

  object versions {
    val scala = "2.11.8"
  }

  /**
    * These dependencies are shared between JS and JVM projects
    * the special %%% function selects the correct version for each project
    */
  val sharedDependencies = Def.setting(Seq(
    "org.scalacheck" %%% "scalacheck" % "1.13.2" % "test"
  ))


  /** Dependencies only used by the JVM project */
  val jvmDependencies = Def.setting(Seq(
    "org.scala-js" %% "scalajs-stubs" % scalaJSVersion % "provided",
    "com.novocode" % "junit-interface" % "0.11" % "test"
  ))


  /** Dependencies only used by the JS project (note the use of %%% instead of %%) */
  val scalajsDependencies = Def.setting(Seq(
  ))

}