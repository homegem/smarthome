### Requirements

- Docker
- Gradle

### Run

```docker-compose up``` command can be used to run project.

For building all applications use `gradle build` and after building run these applications with `gradle bootRun` command. Thanks to the multi-project structure provided by gradle, it is enough to run these commands only once in the root directory.

Note: There will be exceptions during initialization. However, after initialization process is completed system work properly.

### Kafka

Apache Kafka is used as message broker. Kafka Cluster and related components can be monitored and managed by Landoop UI at http://localhost:3030/. This UI helps us to see topics, schemas and connectors.

### Example

```
Weather service with API Gateway

http://localhost:8765/weather-serving-service/hello/world
```

```
Weather service without API Gateway

http://localhost:8000/hello/world
```