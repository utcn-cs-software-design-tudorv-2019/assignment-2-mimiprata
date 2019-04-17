package model;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import connection.HibernateConnectionFactory;

public class TeacherDAO implements TeacherRepository{
	public SessionFactory sessionFactory = HibernateConnectionFactory.getSessionFactory();

    public void delete(Teacher objectToDelete) {
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(objectToDelete);
        transaction.commit();
        currentSession.close();
    }

    public void update(Teacher objectToUpdate) {
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.update(objectToUpdate);
        transaction.commit();
        currentSession.close();
    }

    public void insert(Teacher objectToCreate) {
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
	 public Teacher findByMail(String email) {
	        Session session = sessionFactory.openSession();
	  
	        Criteria cr = session.createCriteria(Teacher.class);
	        cr.add(Restrictions.eq("email", email));
	// You can add as many as Restrictions as per your requirement
	        Object results = cr.list().get(0);
	        session.close();
	        return (Teacher) results;
	    }
	 public List<Object> findAll() {

	        Session session = sessionFactory.openSession();
	        Criteria cr = session.createCriteria(Teacher.class);
	        List <Object> results = cr.list();
	        session.close();
	        return results;

	    }
	 
	 

}
