package api;

import domain.Person;
import org.hibernate.SQLQuery;
import service.PersonHandler;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("/")
public class MainResource {

    @Inject
    PersonHandler personHandler;

    @Inject
    Person person;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("test")
    public String test() {
        System.out.println("Test");
        return "Vilas test";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("person/{name}/{age}")
    public String createPerson(@PathParam("name") String name, @PathParam("age") int age) {
        person.setName(name);
        person.setAge(age);
        personHandler.createPerson(person);
        return "fodase";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("all-person")
    public String getAllPerson(){
        Collection<Person> persons = personHandler.getAllPerson();
        StringBuilder result = new StringBuilder();
        for (Person person: persons){
            result.append(person.getName()).append("-").append(person.getAge()).append("\n");
        }
        return result.toString();
    }
}
