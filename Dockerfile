FROM java:8
RUN \
  apt-get update && \
  apt-get install -y maven
RUN mkdir /packer-api
COPY . /packer-api
WORKDIR /packer-api
RUN mvn package
RUN echo 2 | update-alternatives --config java
EXPOSE 2927
CMD ["java", "-jar", "target/packer-api-0.0.1-SNAPSHOT.jar"]