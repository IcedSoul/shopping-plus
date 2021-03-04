FROM java:8-jre

ENV TimeZone=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TimeZone /etc/localtime && echo $TimeZone > /etc/timezone

ADD ./product-service-provider/target/product-service-provider-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/product-service-provider-0.0.1-SNAPSHOT.jar"]

EXPOSE 8081