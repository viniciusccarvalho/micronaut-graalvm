FROM scratch
EXPOSE 8080
COPY micronaut-graal /app/micronaut-graal
ENTRYPOINT ["/app/micronaut-graal", "-Djava.library.path=/app"]
