FROM oracle/graalvm-ce:19.3.0-java8 as graalvm
#FROM oracle/graalvm-ce:19.3.0-java11 as graalvm # For JDK 11
COPY . /home/app/micronaut-graal
WORKDIR /home/app/micronaut-graal
RUN gu install native-image
RUN native-image --no-server --static -cp build/libs/micronaut-graal-*-all.jar

FROM scratch
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-graal/micronaut-graal /app/micronaut-graal
ENTRYPOINT ["/app/micronaut-graal", "-Djava.library.path=/app"]
