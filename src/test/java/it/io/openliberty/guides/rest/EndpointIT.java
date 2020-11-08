// tag::comment[]
/*******************************************************************************
 * Copyright (c) 2017, 2020 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
 // end::comment[]
package it.io.openliberty.guides.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Properties;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import com.ashburnere.jakarta_ee_demo.boundary.RestConsumer;
import com.ashburnere.jakarta_ee_demo.entity.Person;

public class EndpointIT {
    
    private static final Jsonb jsonb = JsonbBuilder.create();

    // tag::test[]
    @Test
    // end::test[]
    public void testGetProperties() {
        // tag::systemProperties[]
        String port = System.getProperty("http.port");
        String context = System.getProperty("context.root");
        // end::systemProperties[]
        String url = "http://localhost:" + port + "/" + context + "/";

        // tag::clientSetup[]
        Client client = ClientBuilder.newClient();
        // end::clientSetup[]

        // tag::target[]
        WebTarget target = client.target(url + "resources/properties");
        // end::target[]
        // tag::requestget[]
        Response response = target.request().get();
        // end::requestget[]

        // tag::assertequals[]
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus(),
                     "Incorrect response code from " + url);
        // end::assertequals[]

        // tag::body[]
        String json = response.readEntity(String.class);
        Properties sysProps = jsonb.fromJson(json, Properties.class);

        // tag::assertosname[]
        assertEquals(System.getProperty("os.name"), sysProps.getProperty("os.name"),
                     "The system property for the local and remote JVM should match");
        // end::assertosname[]
        // end::body[]
        response.close();
    }
    
    @Test
	public void whenConsumeWithJsonb_thenGetPerson() {
	    String url = "http://localhost:9080/jakarta-ee-demo/resources/persons/1";
	    String result = RestConsumer.consumeWithJsonb(url);        
	    
	    Person person = JsonbBuilder.create().fromJson(result, Person.class);
	    assertEquals(1, person.getId());
	    assertEquals("normanlewis", person.getUsername());
	    assertEquals("normanlewis@email.com", person.getEmail());
	}
}
