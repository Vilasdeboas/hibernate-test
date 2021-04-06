package service;

import domain.Person;
import io.quarkus.hibernate.orm.PersistenceUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.*;

@ApplicationScoped
@SuppressWarnings("unchecked")
public class PersonHandler {

    @Inject
    EntityManager entityManager ;

    @Inject
    Person person;

    @Transactional
    public void createPerson(Person person){
        entityManager.merge(person);
        //entityManager.persist(this.person);
    }

    public Collection<Person> getAllPerson(){
        Query query = entityManager.createQuery("SELECT p FROM Person p");
        return (Collection<Person>) query.getResultList();
    }

}