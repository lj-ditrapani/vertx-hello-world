### Build frontend
FROM node:12.16.2-stretch-slim AS frontend
MAINTAINER Jonathan Di Trapani
COPY frontend/package.json frontend/package-lock.json ./
RUN npm install
COPY frontend/tslint.json frontend/.prettierrc.json frontend/tsconfig.json ./
COPY frontend/src src/
COPY frontend/test test/
RUN npm run all-pipeline

### Build backend
FROM gradle:6.3.0-jdk11 AS backend
COPY build.gradle.kts settings.gradle.kts ./
COPY src src
COPY --from=frontend code.js src/main/resources/webroot/js
RUN gradle check test assembleDist installDist

### Release
FROM openjdk:11-jre-alpine AS release
COPY --from=backend /home/gradle/build/install/ ./
EXPOSE 44770
CMD [ "./vertx-kotlin-hello-world/bin/vertx-kotlin-hello-world" ]
