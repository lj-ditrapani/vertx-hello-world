### Build frontend
FROM node:10.16.0-stretch-slim AS frontend
MAINTAINER Jonathan Di Trapani
COPY frontend/package.json frontend/package-lock.json /
RUN npm install
COPY frontend/tslint.json frontend/.prettierrc.json frontend/tsconfig.json /
COPY frontend/src src/
COPY frontend/test test/
RUN stat /src/code.ts
RUN stat /tsconfig.json
RUN npm run all-pipeline
RUN stat /code.js

### Build backend
FROM gradle:5.4.1-jdk8 AS backend
COPY build.gradle.kts settings.gradle.kts /
COPY --from=frontend code.js src/main/resources/webroot/js
COPY src src
RUN pwd
RUN stat /settings.gradle.kts
RUN stat /src/main/resources/webroot/js/code.js
RUN gradle check test assembleDist installDist

### Release
FROM openjdk:8-jre-alpine AS release
COPY --from=backend build/install/ /
EXPOSE 44770
CMD [ "./vertx-kotlin-hello-world/bin/vertx-kotlin-hello-world" ]
