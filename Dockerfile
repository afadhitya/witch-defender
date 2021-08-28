FROM azul/zulu-openjdk-alpine:11-jre as build
COPY . /source
WORKDIR /source

RUN ["chmod", "+x", "gradlew"]
RUN ./gradlew build -x test

FROM azul/zulu-openjdk-alpine:11-jre
COPY --from=build /source/build/libs/*.jar /usr/app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "/usr/app/app.jar"]