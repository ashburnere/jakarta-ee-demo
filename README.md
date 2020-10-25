# Demo application using features of Jakarta EE and Micropofile

The demo uses Open Liberty to run the application.

- To run the application within Open Liberty in interactive mode use: mvn liberty:run
- To stop the application use: mvn liberty:stop
- To run the application within Open Liberty in dev mode use: mvn liberty:dev
- To run unit tests when in dev mode press Enter

An example of a Java Servlet which processes an input parameter can be found here:
http://localhost:9080/jakarta-ee-demo/servlet?name=test

Rest endpoints offered by the application under context root http://localhost:9080/jakarta-ee-demo:

- resources/properties

A JSF page is shown at http://localhost:9080/jakarta-ee-demo


Next steps:
Add JPA example (e.g. https://www.baeldung.com/java-open-liberty)
Add Tests
Add OpenAPI UI
Include Primefaces: https://jaxenter.de/jsf-2-3-moderne-webandwendung-primefaces-7-0-86515


