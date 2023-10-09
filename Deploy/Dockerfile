FROM tomcat:10.1.13-jdk21-openjdk-slim-bookworm

RUN rm -rf /usr/local/tomcat/webapps/ROOT
RUN rm -rf /usr/local/tomcat/webapps/examples

ADD ROOT.war /usr/local/tomcat/webapps/
ADD EmailList.war /usr/local/tomcat/webapps/
ADD Survey.war /usr/local/tomcat/webapps/
ADD Cart.war /usr/local/tomcat/webapps/
ADD Session.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]