val sparkVersion = "2.1.0"

resolvers +=
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

lazy val root = (project in file(".")).
  settings(
    name := "algolia-test",
    version := "1.0",
    scalaVersion := "2.11.8"
  )

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
  "com.algolia" %% "algoliasearch-scala" % "1.19.0-SNAPSHOT"
)

// META-INF discarding
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}