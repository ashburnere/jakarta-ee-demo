# Demo application using features of Jakarta EE and Micropofile

The demo uses Open Liberty to run the application.


## Usage
* To run the application within Open Liberty in interactive mode use `mvn liberty:run`
* To stop the application use `mvn liberty:stop`
* To run the application within Open Liberty in dev mode use `mvn liberty:dev`
* To run unit tests when in dev mode press Enter

## Features
This demo application shows Jakarta EE & MicroProfile features like JAX-RS, JPA, CDI, JSF, Health Check, OpenAPI UI etc.

* An example of a Java Servlet which processes an input parameter can be found here:
[http://localhost:9080/jakarta-ee-demo/servlet?name=test](http://localhost:9080/jakarta-ee-demo/servlet?name=test)
* A JSF page is shown at: [http://localhost:9080/jakarta-ee-demo](http://localhost:9080/jakarta-ee-demo)
* MicroProfile Health Check: [http://localhost:9080/health](http://localhost:9080/health)
* MicroProfile OpenAPI UI: [http://localhost:9080/openapi/ui](http://localhost:9080/openapi/ui)
* REST API endpoints offered by the application under context root can be found in the OpenAPI UI. E.g. to get a list of all person: [http://localhost:9080/jakarta-ee-demo/resources/persons](http://localhost:9080/jakarta-ee-demo/resources/persons).

## TODO
- [ ] Add unit tests
- [ ] Add integration test
- [ ] Include Primefaces: https://jaxenter.de/jsf-2-3-moderne-webandwendung-primefaces-7-0-86515


