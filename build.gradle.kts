import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm").version("1.3.72")
    application
    jacoco
    id("org.jlleitschuh.gradle.ktlint").version("9.2.1")
    id("com.github.ben-manes.versions").version("0.28.0")
}

repositories {
    jcenter()
}

dependencies {
    val vertxVersion = "3.9.0"

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.vertx:vertx-core:$vertxVersion")
    implementation("io.vertx:vertx-web:$vertxVersion")

    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
    testImplementation("io.vertx:vertx-web-client:$vertxVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

application {
    mainClassName = "info.ditrapani.MainKt"
}

ktlint {
    version.set("0.36.0")
    enableExperimentalRules.set(true)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.test {
    testLogging {
        events("passed", "started", "failed", "skipped")
    }
    useJUnitPlatform()
}
