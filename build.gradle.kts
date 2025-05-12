import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.0"
    id("org.openjfx.javafxplugin") version "0.0.13"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("com.github.oshi:oshi-core:5.8.5")
}

javafx {
    version = "21.0.1"
    modules = listOf("javafx.controls")
}

application {
    mainClass.set("io.github.guinunesdev.thermowatch.MainKt")
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "17"
}
