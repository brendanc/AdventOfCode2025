plugins {
    kotlin("jvm") version "1.9.21"
    application
}

group = "org.aoc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

application {
    mainClass.set("main.kotlin.MainKt")
}

tasks.register<JavaExec>("runTask") {
    group = "application"
    description = "Run a specific task (e.g., gradle runTask --args='1.1')"
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("main.kotlin.MainKt")
    // Use Java 17 or higher
    javaLauncher.set(javaToolchains.launcherFor {
        languageVersion.set(JavaLanguageVersion.of(17))
    })
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
        // Accepts Java 17 or any higher version (e.g., 18, 19, 21)
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
        // Accepts Java 17 or any higher version (e.g., 18, 19, 21)
    }
}
