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
