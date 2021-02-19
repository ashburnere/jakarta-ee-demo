//package com.ashburnere.jakarta_ee_demo.control;
//
//import java.util.List;
//
//import javax.enterprise.context.RequestScoped;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//
//import com.ashburnere.jakarta_ee_demo.entity.Person;
//
//@RequestScoped
//public class PersonDao {
//    @PersistenceContext(name = "jpa-unit")
//    private EntityManager em;
// 
//    public Person createPerson(Person person) {
//        em.persist(person);
//        return person;
//    }
// 
//    public Person readPerson(int personId) {
//        return em.find(Person.class, personId);
//    }
//    
//	public List<Person> getAll() {
////		return getAllWithNamedQuery();
////		return getAllWithCriteriaAPI();
////		return getAllWithNativeQuery();
//		
//		return getAllWithNamedNativeQuery();
//	}
//
//	public List<Person> getAllWithAdHocJPQL() {
//		final List<Person> persons = em.createQuery("SELECT p FROM Person p",  Person.class).getResultList();
//		return persons;
//	}
//	
//	public List<Person> getAllWithNamedQuery() {
//		final List<Person> persons = em.createNamedQuery("Person.findAll",  Person.class).getResultList();
//		return persons;
//	}
//	
//	public List<Person> getAllWithCriteriaAPI() {
//		final CriteriaBuilder cb = em.getCriteriaBuilder();
//		final CriteriaQuery<Person> cq = cb.createQuery(Person.class);
//		final Root<Person> root = cq.from(Person.class);
//		cq.select(root);
//
//		final TypedQuery<Person> query = em.createQuery(cq);
//		final List<Person> persons = query.getResultList();;
//		return persons;
//	}
//	
//	public List<Person> getAllWithNativeQuery() {
//		final List<Person> persons = em.createNativeQuery("SELECT * from Person" ,  Person.class).getResultList();
//		return persons;
//	}
//	
//	public List<Person> getAllWithNamedNativeQuery() {
//		final List<Person> persons = em.createNamedQuery("Person.findAllNative",  Person.class).getResultList();
//		return persons;
//	}
//}