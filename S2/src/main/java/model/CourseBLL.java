package model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.table.TableModel;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class CourseBLL {

	CourseRepository courseRepository;
	@Inject
	public CourseBLL(CourseRepository courseRepository)
	{
		this.courseRepository=courseRepository;
	}
	
	public List<Object> findAll() {
		return courseRepository.findAll();
	}
	//insertia se face dupa id student, id teacher
	public void insert (Course c) {
		
		courseRepository.insert(c);
	}
	
	public void delete(Course c)
	{
		 courseRepository.delete(c);
	}
	

	public void update(Course c)
	{
		 courseRepository.update( c);
	}
	
	public Course findByIdTeacher(int x)
	{
		System.out.println(x);
		return courseRepository.findById(x);
	}
	public Course findByIdStudent(int x)
	{
		System.out.println(x);
		return courseRepository.findById(x);
	}
	
	//id course de aici
	public Course findById(int x)
	{
		System.out.println(x);
		return courseRepository.findById(x);
	}

	public List<Object> findCourses(int id) {
		// TODO Auto-generated method stub
		return courseRepository.findCourses(id);
	}

	public TableModel tableCourses(int id) {
		// TODO Auto-generated method stub
		List<Object> l= courseRepository.findCourses(id);
		return courseRepository.tableCourses(l);
	}
	public TableModel tableGrades(int id) {
		// TODO Auto-generated method stub
		List<Object> l= courseRepository.findGrades(id);
		return courseRepository.tableGrades(l);
	}
	
	
	public static void main(String[] args)
	{
		Injector guice = Guice.createInjector(new RepositoryGuiceModule());
	     CourseBLL courseBLL = guice.getInstance(CourseBLL.class);
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );
			
			LocalDate localDate = LocalDate.parse("2019-08-09" , formatter );
			
			java.sql.Date sqlDate = java.sql.Date.valueOf( localDate );
	     Course c=new Course(sqlDate,1,2,"10");
	   //  courseBLL.insert(c);
	    // Course c1=courseBLL.findById(3);
	     //courseBLL.delete(c1);
	}
	}