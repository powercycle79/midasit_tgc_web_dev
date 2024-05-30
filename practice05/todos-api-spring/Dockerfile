FROM gradle as build
WORKDIR /app
COPY gradle gradle
COPY build.gradle settings.gradle gradlew ./
COPY src src
RUN gradle build -x test

FROM openjdk:11
ARG JAR_FILE=/app/build/libs/eduSurvay-1.0.war
COPY --from=build ${JAR_FILE} ./app.war
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar","/app.war"]