FROM maven as build
WORKDIR /app
COPY . .
RUN mvn package

FROM openjdk
WORKDIR /app
COPY --from=build /app/target/exercise.jar .
COPY --from=build /app/src/main/resources/sample.db .
ENTRYPOINT ["java", "-Dspring.data.rest.base-path=sample.db", "-jar","exercise.jar"]