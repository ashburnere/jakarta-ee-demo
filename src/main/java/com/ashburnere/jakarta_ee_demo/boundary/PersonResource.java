package com.ashburnere.jakarta_ee_demo.boundary;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ashburnere.jakarta_ee_demo.control.PersonDao;
import com.ashburnere.jakarta_ee_demo.entity.Person;

@RequestScoped
@Path("persons")
public class PersonResource {

	@Inject
	private PersonDao personDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAllPersons() {
		return personDao.getAll();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Person getPerson(@PathParam("id") int id) {
	    Person person = personDao.readPerson(id);
	    return person;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Response addPerson(Person person) {
	    personDao.createPerson(person);
	    String respMessage = "Person #" + person.getId() + " created successfully.";
	    return Response.status(Response.Status.CREATED).entity(respMessage).build();
	}
}
