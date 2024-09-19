FROM amazoncorretto:21
LABEL AUTHOR=talesb
WORKDIR /app
EXPOSE 9999
COPY app.jar ./
ENTRYPOINT ["java", "-jar", "app.jar"]