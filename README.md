# OMNI README 

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
  * mvn clean install
  * mvn spring-boot:run -Dspring-boot.run.profiles=local
* Collections and indexes will be created automatically



### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines

### Who do I talk to? ###

* Repo owner or admin
* Other community or team contact

Author: Ashish Rathore