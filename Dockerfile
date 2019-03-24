FROM java:8
ADD target/jinjr-server-*.jar /app/jinjr-server.jar
ENTRYPOINT ["java", "-jar", "/app/jinjr-server.jar"]