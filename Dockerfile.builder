# docker build -t bizm/mvn3-jdk11-docker -f Dockerfile.builder .
# docker run --rm -it --net host --env DOCKER_HOST="tcp://192.168.65.2:2375" bizm/mvn3-jdk11-docker bash
# docker run --rm -it --net host --env DOCKER_HOST="tcp://192.168.65.2:2375" -v C:\work\test\docker-thorntail-jee8-microprofile:/tmp/src bizm/mvn3-jdk11-docker bash
FROM maven:3-jdk-11

RUN apt-get update
RUN apt-get install -y \
     apt-transport-https \
     ca-certificates \
     curl \
     gnupg2 \
     software-properties-common
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
RUN add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/debian \
   $(lsb_release -cs) \
   stable"
RUN apt-get update
RUN apt-get install -y docker-ce

RUN apt-get install -y net-tools