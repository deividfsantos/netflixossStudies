# Music Service

## Spring Boot Poc


```
[Method]: GET
Endpoint: http://localhost:9000/playlist/v1/
Result: Return a JSON of all Playlists
```

```
[Method]: GET
Endpoint: http://localhost:9000/playlist/v1/[Name of Playlist]
Result: Return a JSON the playlist by playlist's name
```

```
[Method]: GET
Endpoint: http://localhost:9000/playlist/v1/full/[Name of Playlist]
Result: Return a JSON with the songs of the playlist by playlist's name
Run MusicService first to work fine
```

## Build
./gradlew clean build

java -jar build/libs/playlistservice-0.1.0.jar --server.port=[Choose a port]
