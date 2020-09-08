FROM openjdk:11.0-slim
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN javac application.java
CMD ["java", "application"]