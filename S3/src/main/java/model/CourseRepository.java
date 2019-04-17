package model;

import java.util.List;

import javax.swing.table.TableModel;

public interface CourseRepository {
	  public void delete(Course objectToDelete) ;
	  public void update(Course objectToUpdate);
	  public void insert(Course objectToCreate);
	  public List<Object> createObjects(Class type);
	  public List<Object> findAll();
	  public Course findById (int id);
	  public Course findByIdTeacher (int id);
	  public Course findByIdStudent (int id);
	  public List<Object> findGrades(int id);
	  public TableModel tableGrades(List<Object> l);
	  
		public List<Object> findCourses(int id);
		public TableModel tableCourses(List<Object> l);
		public List<Object> findMyGrades(int id);
		public TableModel tableMyGrades(List<Object> l);

}
