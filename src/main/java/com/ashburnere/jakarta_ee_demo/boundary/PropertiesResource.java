
package com.ashburnere.jakarta_ee_demo.boundary;

import java.time.LocalDateTime;
import java.util.Properties;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ashburnere.jakarta_ee_demo.entity.RequestMonitorTransient;

/**
 * Simple resource which just returns the value of {@link System#getProperties()} as JSON.
 * 
 * @author Erik
 *
 */
@Path("properties")
public class PropertiesResource {
	
	@Inject
	RequestMonitorTransient requestMonitorTransient;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Properties getProperties() {
    	
    	requestMonitorTransient.addRequest(LocalDateTime.now().toString());
        return System.getProperties();
    }
}
