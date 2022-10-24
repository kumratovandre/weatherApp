FROM maven:3.6.0-jdk-11-slim as build
COPY /src /home/app/src
COPY ../pom.xml /home/app
COPY ../org.apache.karaf.features.cfg /home
RUN mvn -f /home/app/pom.xml clean install

FROM apache/karaf:4.4.1
COPY --from=build /home/app/target/weather-fetcher-1.0-SNAPSHOT.jar \
/opt/apache-karaf-4.4.1/deploy
COPY --from=build /home/org.apache.karaf.features.cfg /opt/apache-karaf-4.4.1/etc
RUN chmod 755 /opt
EXPOSE 1099 8101 44444 8181
CMD ["/opt/apache-karaf-4.4.1/bin/karaf"]
