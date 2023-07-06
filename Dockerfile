FROM amazoncorretto:17

ARG DEFAULT_PROFILE=local
ENV ACTIVE_PROFILE=$DEFAULT_PROFILE
RUN mkdir /opt/app
COPY ./ctf-webapp/build/libs/ctf-webapp-1.0-SNAPSHOT.jar /opt/app/app.jar
CMD ["java", "-jar", "/opt/app/app.jar", "--spring.profiles.active=${ACTIVE_PROFILE}"]