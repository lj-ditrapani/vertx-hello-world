import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

group "info.ditrapani"
version "1.0-SNAPSHOT"

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.31")
    }
}

plugins {
    id("kotlin2js").version("1.3.31")
    jacoco
    id("org.jlleitschuh.gradle.ktlint").version("8.0.0")
    id("io.gitlab.arturbosch.detekt").version("1.0.0-RC14")
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-js:1.3.31")
}

detekt {
    toolVersion = "1.0.0-RC14"
    input = files("src/main/kotlin")
    filters = ".*/resources/.*,.*/build/.*"
}
