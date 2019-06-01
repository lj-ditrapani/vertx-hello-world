Hello world in Vert.x + kotlin + kotlin/javascript + docker
===========================================================

Dockerized hello world
using
Vert.x + kotlin + kotlin/javascript.


Develop
=====================

Run app

    ./gradlew run

Run tests

    ./gradlew test

Run test coverage report

    ./gradlew test jacocoTestReport
    firefox build/reports/jacoco/test/html/index.html

Run tests and static analysis

    ./gradlew check

Format code

    ./gradlew ktlintFormat

Run static analysis

    ./gradlew detekt

Create zip and tar application files under build/distributions/

    ./gradlew assembleDist

Package, install and run artifact

    ./gradlew assembleDist installDist && \
        ./build/install/vertx-kotlin-hello-world/bin/vertx-kotlin-hello-world
