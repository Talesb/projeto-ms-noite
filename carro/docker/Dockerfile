FROM amazoncorretto:21
MAINTAINER talesb
ENV SENHA_BANCO=123456
WORKDIR /app
COPY app.jar ./
ENTRYPOINT ["java", "-jar", "app.jar"]