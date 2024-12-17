FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

COPY . .

RUN ./gradlew build --no-daemon

FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8086

ENTRYPOINT ["java", "-jar", "app.jar"]