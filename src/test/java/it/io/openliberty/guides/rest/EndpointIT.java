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

import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;
import java.util.Properties;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.Test;

import com.ashburnere.jakarta_ee_demo.boundary.RestConsumer;
import com.ashburnere.jakarta_ee_demo.entity.Person;

import static org.junit.jupiter.api.Assertions.*;

public class EndpointIT {
    
    private static final Jsonb jsonb = JsonbBuilder.create();

    @Test
    public void testGetProperties() {
        String port = System.getProperty("http.port"); // z.B. 9080
        String context = System.getProperty("context.root"); // z.B. jakarta-ee-demo
        String url = "http://localhost:" + port + "/" + context + "/";

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url + "resources/properties");
        Response response = target.request().get();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus(),
                     "Incorrect response code from " + url);

        String json = response.readEntity(String.class);
        Properties sysProps = jsonb.fromJson(json, Properties.class);

        assertEquals(System.getProperty("os.name"), sysProps.getProperty("os.name"),
                     "The system property for the local and remote JVM should match");
        response.close();
    }

    @Test
    public void testHealtcheck() {
        String port = System.getProperty("http.port");
        String context = System.getProperty("context.root");
        String url = "http://localhost:" + port + "/";

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url + "health");
        Response response = target.request().get();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus(),
                "Incorrect response code from " + url);

        String json = response.readEntity(String.class);
        Health health = jsonb.fromJson(json, Health.class);

        assertEquals("UP", health.status,
                "Health status is not up");
        response.close();
    }
}
