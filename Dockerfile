FROM tomcat:8
RUN ["rm","-fr","/usr/local/tomcat/webapps/ROOT/*"]
COPY ./src/ /usr/local/tomcat/webapps/ROOT/
