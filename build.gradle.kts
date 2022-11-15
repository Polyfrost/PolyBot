import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
}

group = "cc.polyfrost.crashylizer"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        name = "Kotlin Discord"
        url = uri("https://maven.kotlindiscord.com/repository/maven-public")
    }
}

dependencies {
    implementation("com.kotlindiscord.kord.extensions:kord-extensions:1.5.5-SNAPSHOT")
    implementation("dev.kord:kord-core:0.8.0-M17")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "18"
}

application {
    mainClass.set("cc.polyfrost.crashylizer.MainKt")
}