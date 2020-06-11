FROM openjdk:8u222-jre
RUN echo "Asia/Shanghai" > /etc/timezone
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
CMD ["java","-Xms256m", "-Xmx256m","-jar","/app.jar"]