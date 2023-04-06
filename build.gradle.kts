plugins {
    kotlin ("js") version "1.8.0"
}

group = "com.encodeering.showcase"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral ()
}

dependencies {
    implementation (npm ("app", "file://" + projectDir.resolve ("app").canonicalPath, generateExternals = false))

    testImplementation (kotlin ("test"))
}

kotlin {
    sourceSets["main"].apply {
        kotlin.srcDir ("$projectDir/src/main/dukat/externals")
    }

    js {
        binaries.executable ()
        nodejs {
        }
        useCommonJs ()
    }
}
