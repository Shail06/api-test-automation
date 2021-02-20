FROM ubuntu:18.04

COPY install_maven_363.sh /usr/local/src

RUN apt-get update && apt-get install -y \
    git \
    curl \
    vim \
    wget \
    openjdk-8-jdk

ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
ENV M2_HOME=/opt/maven
ENV MAVEN_HOME=/opt/maven
ENV PATH=${M2_HOME}/bin:${PATH}

WORKDIR /usr/local/src/

RUN chmod +x install_maven_363.sh
RUN /bin/bash install_maven_363.sh

RUN git clone https://github.com/Shail06/api-test-automation.git
