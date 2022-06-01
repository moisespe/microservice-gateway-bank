FROM adoptopenjdk:11-hotspot
LABEL maintainer="jugarriza10@gmail.com"
COPY target/bank.gateway-server-0.0.1-SNAPSHOT.jar bank.gateway-server.jar
CMD ["java", "-jar", "bank.gateway-server.jar"]
EXPOSE 9950