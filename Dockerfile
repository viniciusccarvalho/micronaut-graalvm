FROM gradle:6.1.1-jdk8 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle assemble

FROM oracle/graalvm-ce:20.0.0-java11 as graalvm
#FROM oracle/graalvm-ce:19.3.0-java11 as graalvm # For JDK 11
COPY --from=build /home/gradle/src /home/app/micronaut-graal
WORKDIR /home/app/micronaut-graal
RUN gu install native-image
RUN native-image -H:ReflectionConfigurationFiles=native-config/reflect-config.json --initialize-at-build-time=org.mariadb --static  --no-server --verbose  --no-fallback  -cp build/libs/micronaut-graal-0.1-all.jar 

FROM scratch
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-graal/micronaut-graal /app/micronaut-graal
ENTRYPOINT ["/app/micronaut-graal", "-Djava.library.path=/app"]
