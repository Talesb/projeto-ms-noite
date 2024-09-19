FROM amazoncorretto:21
MAINTAINER talesb
EXPOSE 8761
WORKDIR /app
COPY app.jar ./
ENTRYPOINT ["java", "-jar", "app.jar"]