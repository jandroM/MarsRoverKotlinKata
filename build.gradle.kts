import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
plugins {
    application
    kotlin("jvm") version "1.3.72"
}
application {
    mainClassName = "SetupKt"
    val run by tasks.getting(JavaExec::class) {
        standardInput = System.`in`
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.5.0")
    testImplementation("io.mockk:mockk:1.10.0")
    testImplementation("io.kotest:kotest-assertions-core-jvm:4.1.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.0")
}
repositories {
    mavenCentral()
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}