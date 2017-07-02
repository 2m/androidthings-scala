scalaVersion := "2.11.11"

resolvers ++= Seq(
  "Google" at "https://maven.google.com", // android.arch
  Resolver.jcenterRepo                    // android.things
)

val GmsVersion = "11.0.0"

libraryDependencies ++= Seq(
  "android.arch.lifecycle"    % "extensions"        % "1.0.0-alpha3",
  "com.google.android.things" % "androidthings"     % "0.4.1-devpreview",
  "com.google.firebase"       % "firebase-database" % GmsVersion,
  "com.google.android.gms"    % "play-services"     % GmsVersion
)

platformTarget := "android-24"
minSdkVersion := "24"
proguardVersion := "5.1"

useProguardInDebug := false
dexMulti := true

enablePlugins(AndroidApp, AndroidGms)
