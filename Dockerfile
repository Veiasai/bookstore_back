FROM tomcat:9-jre8

ADD ./target/bookstore.war /usr/local/tomcat/webapps/

RUN /bin/bash -c 'echo init ok!!!'