lazy val projectVersion = "0.2.1"
lazy val mimaVersion    = "0.2.0"

lazy val deps = new {
  val test = new {
    val scalaTest = "3.2.7"
  }
}

lazy val commonJvmSettings = Seq(
  crossScalaVersions := Seq("3.0.0-RC2", "2.13.5", "2.12.13"),
)

// sonatype plugin requires that these are in global
ThisBuild / version      := projectVersion
ThisBuild / organization := "de.sciss"

lazy val commonSettings = Seq(
  name               := "Numbers",
//  version            := projectVersion,
//  organization       := "de.sciss",
  scalaVersion       := "2.13.5",
  description        := "A collection of numeric functions and type enrichments",
  homepage           := Some(url(s"https://git.iem.at/sciss/${name.value}")),
  licenses           := Seq("LGPL v2.1+" -> url("http://www.gnu.org/licenses/lgpl-2.1.txt")),
) ++ publishSettings

lazy val root = crossProject(JSPlatform, JVMPlatform).in(file("."))
  .settings(commonSettings)
  .jvmSettings(commonJvmSettings)
  .settings(
    mimaPreviousArtifacts := Set("de.sciss" %% "numbers" % mimaVersion),
    initialCommands in console := """import de.sciss.numbers.Implicits._""",
    libraryDependencies += "org.scalatest" %%% "scalatest" % deps.test.scalaTest % Test,
    scalacOptions ++= Seq("-Xlint", "-deprecation", "-unchecked", "-feature", "-encoding", "utf8", "-Xsource:2.13"),
  )

lazy val publishSettings = Seq(
  publishMavenStyle := true,
  publishArtifact in Test := false,
  pomIncludeRepository := { _ => false },
  developers := List(
    Developer(
      id    = "sciss",
      name  = "Hanns Holger Rutz",
      email = "contact@sciss.de",
      url   = url("https://www.sciss.de")
    )
  ),
  scmInfo := {
    val h = "git.iem.at"
    val a = s"sciss/${name.value}"
    Some(ScmInfo(url(s"https://$h/$a"), s"scm:git@$h:$a.git"))
  },
)

