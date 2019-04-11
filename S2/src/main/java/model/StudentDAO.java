package model;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import connection.HibernateConnectionFactory;


public class StudentDAO implements StudentRepository{
	  private EntityManagerFactory entityManagerFactory;
	  public SessionFactory sessionFactory = HibernateConnectionFactory.getSessionFactory();

	    public void delete(Student objectToDelete) {
	        Session currentSession = sessionFactory.openSession();
	        Transaction transaction = currentSession.beginTransaction();
	        currentSession.delete(objectToDelete);
	        transaction.commit();
	        currentSession.close();
	    }

	    public void update(Student objectToUpdate) {
	        Session currentSession = sessionFactory.openSession();
	        Transaction transaction = currentSession.beginTransaction();
	        currentSession.update(objectToUpdate);
	        transaction.commit();
	        currentSession.close();
	    }

	    public void insert(Student objectToCreate) {
	        Session currentSession = sessionFactory.openSession();
	        Transaction transaction = currentSession.beginTransaction();
	        currentSession.merge(objectToCreate);
	        transaction.commit();
	        currentSession.close();
	    }

	  
	  

	    public List<Object> createObjects(Class type) {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<Object> criteria = builder.createQuery(type);
	        criteria.from(type);
	        List<Object> data = session.createQuery(criteria).getResultList();
	        transaction.commit();
	        session.close();
	        return data;
	    }
	  
	  public Student findByMail(String email) {
	        Session session = sessionFactory.openSession();
	  
	        Criteria cr = session.createCriteria(Student.class);
	        cr.add(Restrictions.eq("email", email));
	// You can add as many as Restrictions as per your requirement
	        Object results = cr.list().get(0);
	        session.close();
	        return (Student) results;
	    }
	  
	  public Student findById (int id) {
	        Session session = sessionFactory.openSession();
	        Criteria cr = session.createCriteria(Student.class);
	        cr.add(Restrictions.eq("idstudent", id));
	// You can add as many as Restrictions as per your requirement
	        List <Object> results = cr.list();
	        session.close();
	        return (Student) results.get(0);
	    }
	  public List<Object> findByIdGroup (int id) {
	        Session session = sessionFactory.openSession();
	        Criteria cr = session.createCriteria(Student.class);
	        cr.add(Restrictions.eq("idgroup", id));
	// You can add as many as Restrictions as per your requirement
	        List <Object> results = cr.list();
	        session.close();
	        return  results;
	    }
	  public List<Object> findAll() {

	        Session session = sessionFactory.openSession();
	        Criteria cr = session.createCriteria(Student.class);
	        List <Object> results = cr.list();
	        session.close();
	        return results;

	    }

}
