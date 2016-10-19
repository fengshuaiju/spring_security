FROM fengshuaiju/tomcat7:v2

MAINTAINER shuaijufeng "1179694483@qq.com"

WORKDIR /code

RUN echo "Asia/Shanghai" > /etc/timezone && \
        dpkg-reconfigure -f noninteractive tzdata
        
RUN source /etc/profile

RUN rm -r /tomcat/webapps/*

ADD pom.xml /code/pom.xml 
RUN mvn dependency:resolve 

ADD . /code
RUN mvn package && cp -r target/ROOT.war /usr/local/tomcat/webapps/

# Start Tomcat
CMD ["/tomcat/bin/catalina.sh", "run"]