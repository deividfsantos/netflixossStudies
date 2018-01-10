# Music Service

## Spring Boot Poc

[Method]: GET
Endpoint: http://localhost:9000/musics/
Result: Return a JSON of all Musics

[Method]: GET
Endpoint: http://localhost:9000/musics/[id of music]
Result: Return a JSON of music by ID

## Build
./gradlew clean build

java -jar build/libs/musicservice-0.1.0.jar --server.port=[Choose a port]
