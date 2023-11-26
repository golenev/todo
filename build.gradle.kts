import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    application
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    testImplementation("org.aspectj:aspectjweaver:1.9.5")
    testImplementation("io.qameta.allure:allure-junit5:2.12.1")
    testImplementation("io.qameta.allure:allure-commandline:2.12.1")
    testImplementation("io.qameta.allure:allure-assertj:2.12.1")
    testImplementation("io.qameta.allure:allure-java-commons:2.12.1")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}