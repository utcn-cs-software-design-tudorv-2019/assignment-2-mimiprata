package model;



import connection.HibernateConnectionFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class AbstractDAO {

    public SessionFactory sessionFactory = HibernateConnectionFactory.getSessionFactory();

    public void delete(Object objectToDelete) {
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(objectToDelete);
        transaction.commit();
        currentSession.close();
    }

    public void update(Object objectToUpdate) {
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.update(objectToUpdate);
        transaction.commit();
        currentSession.close();
    }

    public void insert(Object objectToCreate) {
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.merge(objectToCreate);
        transaction.commit();
        currentSession.close();
    }

    public List<Object> findAll() {

        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Object.class);
        List <Object> results = cr.list();
        session.close();
        return results;

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

}
