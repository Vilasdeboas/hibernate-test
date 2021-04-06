package domain;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.ws.rs.Produces;

@ApplicationScoped
public class PersonProducer {

    @Produces
    @Default
    public Person newPerson(){
        return new Person();
    }

}
