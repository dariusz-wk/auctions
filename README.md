auctions
========

Simple auction web service for testing purposes

requires:
- tomcat 7.0
- maven 

change the <server> property in pom.xml to match the location of your's

run: mvn clean install -> to compile and deploy

startup tomcat

WS are available at localhost:8080/auctions/services

======
integration info
======

/WEB-INF/spring.properties contains all the configuration

Mail service is confiured to use gmail account just set username and password and switch demo to false


Integration with useraccounts service is will be enabled after setting proper url's for wsdl's and seting demo to false
To authorise acces to web app add 

username = value
password = value

to request html header for every request

=====
testing
=====

use attached A-soapui-project.xml to test functionalities
in has a useraccount service mock so run it to find out how it all work
