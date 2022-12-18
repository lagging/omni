# OMNI 🚚

Following are the steps necessary to get your application up and running.

### What is this repository for? ###

* Omni service is used for tracking mobile food facility permit

### How do I get set up in local? ###

* install java 11
* install mongodb 5.x
* create a database with the name omni
* change mongodb username password in application-local.properties file
* create folder /var/log/omni and provide current user permission i.e chmod 755 /var/log/omni
* perform following steps to run application:

## Build
To build:

```
$ git clone https://github.com/lagging/omni.git
$ cd omni/
$ mvn clean install
```

## RUN
To run:
```
$ mvn spring-boot:run -Dspring-boot.run.profiles=local
```
You will see output similar to following:

```
{"@timestamp":"2022-12-18T08:41:06.643+05:30","@version":"1","message":"Tomcat started on port(s): 8080 (http) with context path ''","logger_name":"org.springframework.boot.web.embedded.tomcat.TomcatWebServer","thread_name":"main","level":"INFO","level_value":20000}
{"@timestamp":"2022-12-18T08:41:06.643+05:30","@version":"1","message":"Tomcat started on port(s): 8080 (http) with context path ''","logger_name":"org.springframework.boot.web.embedded.tomcat.TomcatWebServer","thread_name":"main","level":"INFO","level_value":20000}
{"@timestamp":"2022-12-18T08:41:06.661+05:30","@version":"1","message":"Started OmniApplication in 19.116 seconds (JVM running for 25.85)","logger_name":"com.creditsaison.OmniApplication","thread_name":"main","level":"INFO","level_value":20000}
{"@timestamp":"2022-12-18T08:41:06.661+05:30","@version":"1","message":"Started OmniApplication in 19.116 seconds (JVM running for 25.85)","logger_name":"com.creditsaison.OmniApplication","thread_name":"main","level":"INFO","level_value":20000}
{"@timestamp":"2022-12-18T08:41:07.351+05:30","@version":"1","message":"Initializing Spring DispatcherServlet 'dispatcherServlet'","logger_name":"org.apache.catalina.core.ContainerBase.[Tomcat].[localhost].[/]","thread_name":"RMI TCP Connection(5)-192.168.29.142","level":"INFO","level_value":20000}
{"@timestamp":"2022-12-18T08:41:07.351+05:30","@version":"1","message":"Initializing Spring DispatcherServlet 'dispatcherServlet'","logger_name":"org.apache.catalina.core.ContainerBase.[Tomcat].[localhost].[/]","thread_name":"RMI TCP Connection(5)-192.168.29.142","level":"INFO","level_value":20000}
{"@timestamp":"2022-12-18T08:41:07.352+05:30","@version":"1","message":"Initializing Servlet 'dispatcherServlet'","logger_name":"org.springframework.web.servlet.DispatcherServlet","thread_name":"RMI TCP Connection(5)-192.168.29.142","level":"INFO","level_value":20000}
{"@timestamp":"2022-12-18T08:41:07.352+05:30","@version":"1","message":"Initializing Servlet 'dispatcherServlet'","logger_name":"org.springframework.web.servlet.DispatcherServlet","thread_name":"RMI TCP Connection(5)-192.168.29.142","level":"INFO","level_value":20000}
{"@timestamp":"2022-12-18T08:41:07.388+05:30","@version":"1","message":"Completed initialization in 36 ms","logger_name":"org.springframework.web.servlet.DispatcherServlet","thread_name":"RMI TCP Connection(5)-192.168.29.142","level":"INFO","level_value":20000}
{"@timestamp":"2022-12-18T08:41:07.388+05:30","@version":"1","message":"Completed initialization in 36 ms","logger_name":"org.springframework.web.servlet.DispatcherServlet","thread_name":"RMI TCP Connection(5)-192.168.29.142","level":"INFO","level_value":20000}
```
* Collections and indexes will be created automatically

## Bugs and Feedback

For bugs, questions and discussions please use the [GitHub Issues](https://github.com/lagging/omni/issues).


### Who do I talk to? ###

* Reach out to ashishrathore00792@gmail.com for any concerns

Author: Ashish Rathore