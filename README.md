Hello world in Vert.x + kotlin + kotlin/javascript + docker
===========================================================

Dockerized hello world
using
Vert.x + kotlin + kotlin/javascript.

Todo
====

- backend
    - /hello route
    - static serving html, css, js
    - websocketServer
- frontend: kotlin/javascript
    - hello button (post /hello)
    - count box shows latest value from websocket
- store:
    - mongodb
    - single count document
    - bootup sets count to 0
    - /hello
        - gets count; +1, store
        - broadcasts new count to all websockets


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
