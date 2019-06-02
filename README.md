Hello world in Vert.x + kotlin + typescript
===========================================

Dockerized hello world using Vert.x + kotlin + typescript.


- backend
    - vert.x + kotlin
    - /hello route
    - serves up html and javascript
    - websocketServer
- frontend
    - Runtime: Uses typescript and jquery
    - Build: browserify + tsify
    - hello button (post /hello)
    - count box shows latest global hello count from websocket
- pipeline & deployment:
  [multi-stage Dockerfile](https://docs.docker.com/develop/develop-images/multistage-build/)
    - all formatting, linting, testing and building happen in intermediate
      images, final artifacts are copied into the final release image.

To build and run you only need [docker](https://www.docker.com/) installed.
To develop the backend, you need a Java JDK 8.
I recommend installing via [sdkman](https://sdkman.io/).
To develop the frontend, you need [node](https://nodejs.org/) 10.16.0.
I recommend installing via [nvm](https://github.com/nvm-sh/nvm).


Build it!
=========

    sh build.sh


Run it!
=======

    sh docker-run.sh


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


Todo
====

- store:
    - mongodb
    - single count document
    - bootup sets count to 0
    - /hello
        - gets count; +1, store
        - broadcasts new count to all websockets
- coroutine integration
- rewrite frontend build.gradle in kts.
  See: <https://kotlinlang.org/docs/reference/using-gradle.html>
- docker: browserify + tsify can't seem to get it to work in docker...
    - `Error: tsify: no compiled file for /src/code.ts`
    - npm run all-pipeline doesn't fail when browserify fails when piped to uglify
