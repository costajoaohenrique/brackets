FROM fabric8/java-alpine-openjdk8-jdk
COPY target/brackets-0.0.1-SNAPSHOT.jar brackets-0.0.1-SNAPSHOT.jar
CMD java -jar brackets-0.0.1-SNAPSHOT.jar
EXPOSE 8080