FROM tomcat:8
RUN ["rm","-fr","/usr/local/tomcat/webapps"]
COPY ./dest/ /usr/local/tomcat/webapps/ROOT/
