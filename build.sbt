name := "TestWS"

version := "1.0"

organization := "com.fortitude"

scalaVersion := "2.10.3"

scalaSource in Compile <<= baseDirectory(_ / "scala/src")

scalaSource in Test <<= baseDirectory(_ / "scala/test")

//resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

libraryDependencies += "javax" % "javaee-api" % "7.0"

libraryDependencies += "org.clapper" % "grizzled-slf4j_2.10" % "1.0.1"

libraryDependencies += "org.specs2" % "specs2_2.10" % "2.3.7" % "test"

