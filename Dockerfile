FROM alpine:3.18

# Install required libraries
RUN apk add --no-cache libstdc++ gcompat

WORKDIR /app
COPY ./target/gen-me /app/gen-me
RUN chmod +x /app/gen-me

EXPOSE 8080
ENTRYPOINT ["/app/gen-me"]