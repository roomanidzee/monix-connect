import sbt._

object Dependencies {

  object Versions {

    //main
    val Monix = "3.3.0"
    val AwsSdk = "2.15.67"
    val AkkaStreams = "2.6.9"
    val AWS = "1.11.749"
    val DynamoDb = "2.10.60"
    val GCS = "1.107.0"
    val Hadoop = "3.1.4"
    val MongoScala = "4.1.1"
    val MongoReactiveStreams = "4.1.1"
    val S3 = "2.14.21"
    val Parquet = "1.11.1"
    val Pureconfig = "0.14.0"
    val Elastic4s = "7.10.2"
    val ScalaCompat = "2.3.2"
    val Tethys = "0.11.0"
    val Json4s = "3.6.7"
    val Sttp = "2.2.9"

    //test
    val Scalatest = "3.2.3"
    val Scalacheck = "1.14.0"
    val Mockito = "1.15.0"
    val GCNio = "0.122.4"
    val WireMock = "2.27.2"
  }

  private def commonDependencies(hasIt: Boolean = false): Seq[sbt.ModuleID] = {
    val common: Seq[ModuleID] = MonixDependency ++ CommonTestDependencies.map(_ % Test)
    if (hasIt) common ++ CommonTestDependencies.map(_                           % IntegrationTest)
    else common
  }

  private val MonixDependency = Seq("io.monix" %% "monix-reactive" % Versions.Monix)

  private val CommonTestDependencies = Seq(
    "org.scalatest" %% "scalatest"   % Versions.Scalatest,
    "org.scalacheck" %% "scalacheck" % Versions.Scalacheck,
    "org.mockito" %% "mockito-scala" % Versions.Mockito
  )

  val Akka = Seq("com.typesafe.akka" %% "akka-stream" % Versions.AkkaStreams) ++ commonDependencies(hasIt = false)

  val AwsAuth = Seq(
    "software.amazon.awssdk" % "auth" % Versions.AwsSdk,
    "com.github.pureconfig" %% "pureconfig" % Versions.Pureconfig) ++ commonDependencies(hasIt = false)

  val Benchmarks = Seq(
   "com.lightbend.akka" %% "akka-stream-alpakka-s3" % "2.0.2",
    "org.scalacheck" %% "scalacheck" % Versions.Scalacheck,
    "dev.profunktor"    %% "redis4cats-effects" % "0.10.3",
    "io.chrisdavenport" %% "rediculous"         % "0.0.8",
    "io.laserdisc"      %% "laserdisc-fs2"      % "0.4.1"
  )++ commonDependencies(hasIt = false)

  val DynamoDb = Seq("software.amazon.awssdk" % "dynamodb" % Versions.AwsSdk) ++ commonDependencies(hasIt = true)

  val Hdfs = Seq(
    "org.apache.hadoop" % "hadoop-client"      % Versions.Hadoop,
    "org.apache.hadoop" % "hadoop-common"      % Versions.Hadoop,
    "org.apache.hadoop" % "hadoop-hdfs"        % Versions.Hadoop,
    "org.apache.hadoop" % "hadoop-minicluster" % Versions.Hadoop % Test
  ) ++ commonDependencies(hasIt = false)

  val MongoDb = Seq(
    "org.mongodb"       % "mongodb-driver-reactivestreams" % Versions.MongoReactiveStreams,
    "org.mongodb.scala" %% "mongo-scala-bson"   % Versions.MongoScala,
    "org.mongodb.scala" %% "mongo-scala-driver" % Versions.MongoScala
  ) ++ commonDependencies(hasIt = true)

  val Parquet = Seq(
    "org.apache.parquet" % "parquet-avro"     % Versions.Parquet,
    "org.apache.parquet" % "parquet-hadoop"   % Versions.Parquet,
    "org.apache.hadoop" % "hadoop-client" % Versions.Hadoop,
    "org.apache.hadoop" % "hadoop-common" % Versions.Hadoop % Test
  ) ++ commonDependencies(hasIt = false)

  val S3 = Seq(
    "software.amazon.awssdk" % "s3" % Versions.AwsSdk,
    "org.scala-lang.modules" %% "scala-collection-compat" % Versions.ScalaCompat,
  "org.scalatestplus" %% "scalacheck-1-14" % "3.1.4.0" % Test
  ) ++ commonDependencies(hasIt = true)

  val Redis = Seq(
    "io.lettuce" % "lettuce-core" % "5.1.8.RELEASE",
    "org.scala-lang.modules" %% "scala-collection-compat" % Versions.ScalaCompat
  ) ++ commonDependencies(hasIt = true)

  val GCS = Seq(
    "com.google.cloud"               % "google-cloud-storage" % Versions.GCS,
    "com.google.cloud"               % "google-cloud-nio" % Versions.GCNio % IntegrationTest,
    "commons-io"                     % "commons-io" % "2.6" % Test
  ) ++ commonDependencies(hasIt = true)

  val Elasticsearch = Seq(
    "com.sksamuel.elastic4s" %% "elastic4s-client-esjava" % Versions.Elastic4s
  ) ++ commonDependencies(hasIt = true)

  val KSQLDB = Seq(
    "io.monix" %% "monix-nio" % "0.0.9",
    "com.github.tomakehurst" % "wiremock" % Versions.WireMock % Test,
    "com.tethys-json" %% "tethys-core" % Versions.Tethys,
    "com.tethys-json" %% "tethys-jackson" % Versions.Tethys,
    "com.tethys-json" %% "tethys-derivation" % Versions.Tethys,
    "com.tethys-json" %% "tethys-json4s" % Versions.Tethys,
    "org.json4s" %% "json4s-jackson" % Versions.Json4s,
    "com.softwaremill.sttp.client" %% "core" % Versions.Sttp,
    "com.softwaremill.sttp.client" %% "okhttp-backend-monix" % Versions.Sttp
  )++ commonDependencies(hasIt = false)
}
