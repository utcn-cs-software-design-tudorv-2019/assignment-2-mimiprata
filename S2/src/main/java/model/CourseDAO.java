package model;

import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import connection.HibernateConnectionFactory;

public class CourseDAO implements CourseRepository{
	public SessionFactory sessionFactory = HibernateConnectionFactory.getSessionFactory();
    public void delete(Course objectToDelete) {
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(objectToDelete);
        transaction.commit();
        currentSession.close();
    }

    public void update(Course objectToUpdate) {
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.update(objectToUpdate);
        transaction.commit();
        currentSession.close();
    }

    public void insert(Course objectToCreate) {
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
	
	 public List<Object> findAll() {

	        Session session = sessionFactory.openSession();
	        Criteria cr = session.createCriteria(Course.class);
	        List <Object> results = cr.list();
	        session.close();
	        return results;

	    }
	 public Course findById (int id) {
	        Session session = sessionFactory.openSession();
	        Criteria cr = session.createCriteria(Course.class);
	        cr.add(Restrictions.eq("idcourse", id));
	// You can add as many as Restrictions as per your requirement
	        List <Object> results = cr.list();
	        session.close();
	        return (Course) results.get(0);
	    }
	 
	 public Course findByIdTeacher (int id) {
	        Session session = sessionFactory.openSession();
	        Criteria cr = session.createCriteria(Course.class);
	        cr.add(Restrictions.eq("idteacher", id));
	// You can add as many as Restrictions as per your requirement
	        List <Object> results = cr.list();
	        session.close();
	        return (Course) results.get(0);
	    }
	 public Course findByIdStudent (int id) {
	        Session session = sessionFactory.openSession();
	        Criteria cr = session.createCriteria(Course.class);
	        cr.add(Restrictions.eq("idstudent", id));
	// You can add as many as Restrictions as per your requirement
	        List <Object> results = cr.list();
	        session.close();
	        return (Course) results.get(0);
	    }
	 
	 
	 public List<Object> findGrades(int id){
		 Session session = sessionFactory.openSession();
			Query qry= session.createQuery("select s.name, s.email, t.courseName, c.examDate, c.grade from Teacher t, Course c, Student s "
					+ "where t.idteacher=c.idteacher and  s.idstudent=c.idstudent and t.idteacher = :idteacher");
			
	        List l = qry.setParameter("idteacher",id).list();
			session.close();
			return l;
		 
	 }
	 public TableModel tableGrades(List<Object> l)
		{
			DefaultTableModel model=new DefaultTableModel(new Object[] {"Student Name","Student email","Course Name", "ExamDate","Grade"},0);
			Iterator it=l.iterator();
	        while(it.hasNext())
	        {
	            model.addRow((Object[])it.next());
	         
	        }
	        return model;
			
		}
	 
	public List<Object> findCourses(int id){
		
		Session session = sessionFactory.openSession();
		Query qry= session.createQuery("select t.name, t.courseName, c.examDate from Teacher t, Course c "
                + " where t.idteacher = c.idteacher and t.idteacher= :idteacher");
		
        List l = qry.setParameter("idteacher",id).list();
		session.close();
		return l;
	}
	
	public TableModel tableCourses(List<Object> l)
	{
		DefaultTableModel model=new DefaultTableModel(new Object[] {"Teacher Name","Course Name", "ExamDate"},0);
		Iterator it=l.iterator();
        while(it.hasNext())
        {
            model.addRow((Object[])it.next());
         
        }
        return model;
		
	}
	static public  void main(String [] args)
	{
		
		CourseDAO c=new CourseDAO();
		List<Object> l=c.findGrades(1);
		Iterator it=l.iterator();
        while(it.hasNext())
        {
            Object rows[] = (Object[])it.next();
            System.out.println(rows[0]+ " -- " +rows[1] + "--"+rows[2]+"---"+rows[3]);
        }
	}

}
