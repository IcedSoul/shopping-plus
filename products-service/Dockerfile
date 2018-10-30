FROM java:8-jre

ADD ./target/products-service-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/products-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 19694