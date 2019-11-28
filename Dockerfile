#FROM jboss/wildfly
#ADD target/task12.war /opt/jboss/wildfly/standalone/deployments/
#RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
#CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]


FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


FROM jboss/wildfly
COPY --from=build  /home/app/target/task12.war /opt/jboss/wildfly/standalone/deployments/


