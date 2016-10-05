FROM fengshuaiju/tomcat:latest

MAINTAINER shuaijufeng "1179694483@qq.com"

WORKDIR /code

RUN echo "Asia/Shanghai" > /etc/timezone && \
        dpkg-reconfigure -f noninteractive tzdata

RUN rm -r /usr/local/tomcat/webapps/*

RUN sed -i '1i JAVA_OPTS= -Xms128m -Xmx256m ' /usr/local/tomcat/bin/catalina.sh

ADD pom.xml /code/pom.xml 
RUN mvn dependency:resolve 

ADD . /code
RUN mvn package && cp -r target/ROOT.war /usr/local/tomcat/webapps/

# Start Tomcat
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]