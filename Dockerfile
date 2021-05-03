FROM openjdk:11

WORKDIR /usr/src/app

COPY . .

EXPOSE 9090

ENTRYPOINT ["./gradlew","bootRun"]

