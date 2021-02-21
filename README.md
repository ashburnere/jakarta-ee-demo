# Demo application using features of Jakarta EE

This branch of the demo can be used to deploy the app to Wildfly. As database the H2 DB which is integrated in JBoss is 
as used in in-memory mode. See: http://www.mastertheboss.com/jboss-server/jboss-datasource/h2-database-tutorial

## Features
This demo application shows Jakarta EE & MicroProfile features like JAX-RS, JPA, CDI, JSF, Health Check, OpenAPI UI etc.

* An example of a Java Servlet which processes an input parameter can be found here:
[http://localhost:9080/jakarta-ee-demo/servlet?name=test](http://localhost:8080/jakarta-ee-demo/servlet?name=test)
* A JSF page is shown at: [http://localhost:8080/jakarta-ee-demo](http://localhost:8080/jakarta-ee-demo)
* REST API endpoints offered by the application under context root can be found in the OpenAPI UI. E.g. to get a list of all person: [http://localhost:8080/jakarta-ee-demo/resources/persons](http://localhost:8080/jakarta-ee-demo/resources/persons).


