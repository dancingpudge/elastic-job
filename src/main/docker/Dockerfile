FROM frolvlad/alpine-oraclejdk8:slim

ENV TZ=Asia/Shanghai
RUN mkdir /home/wwwlogs
RUN mkdir /home/wwwroot

COPY finance-elasticjob-1.0.0.jar  /home/wwwroot/app.jar
COPY lib  /home/wwwroot/lib



ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/wwwroot/app.jar"]