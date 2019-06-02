Hello world in Vert.x + kotlin + typescript
===========================================

Hello world
using
Vert.x + kotlin + typescript.


- backend
    - vert.x + kotlin
    - /hello route
    - serves up html and javascript
    - websocketServer
- frontend
    - jquery + typescript
    - hello button (post /hello)
    - count box shows latest global hello count from websocket


Todo
====

- store:
    - mongodb
    - single count document
    - bootup sets count to 0
    - /hello
        - gets count; +1, store
        - broadcasts new count to all websockets
- dockerize (multistage docker file)
- coroutine integration
- rewrite frontend build.gradle in kts.
  See: <https://kotlinlang.org/docs/reference/using-gradle.html>


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

Lint, test, run

    ./gradlew ktlintFormat test run
