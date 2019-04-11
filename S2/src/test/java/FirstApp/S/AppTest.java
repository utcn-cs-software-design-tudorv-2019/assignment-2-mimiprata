package FirstApp.S;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;


import com.google.inject.Guice;
import com.google.inject.Injector;

import model.Course;
import model.CourseBLL;
import model.RepositoryGuiceModule;
import model.Student;
import model.StudentBLL;
import model.TeacherBLL;


public class AppTest {
	Injector guice=Guice.createInjector(new RepositoryGuiceModule());
	TeacherBLL u=guice.getInstance(TeacherBLL.class);
	StudentBLL studentBLL=guice.getInstance(StudentBLL.class);
	CourseBLL courseBLL=guice.getInstance(CourseBLL.class);
	
	public void test1() {
		Student s=new Student(4,"Catalin","1234567890123","Observator","catalin@yahoo.com","catalin",30233);
		String s1=s.toString();
		Student ss=studentBLL.findById(1);
		String s2=ss.toString();
		Assert.assertEquals(s1,s2);
	}
	/*
	@Test
	public void test2() {
		int expected1=u.login("admin", "admin");
		int actual=0;
		Assert.assertEquals(expected1, actual);
	}
	
	@Test
	public void test3() {
		Profile expected=new Profile(4,3,"Monalisa","Moldova",444);
		String s1=expected.toString();
		Profile actual=p.findbyIdUser(3);
		String s2=actual.toString();
		Assert.assertEquals(s1, s2);
		
	}
	@Test
    public void test4() {
		Profile expected=new Profile(4,3,"Monalisa","Moldova",444);
		String s1=expected.toString();
		Profile actual=p.findProfile(4);
		String s2=actual.toString();
		Assert.assertEquals(s1,s2);
	}
	@Test
	public void test5() {
		Course expected=new Course(2,"SSC","Baruch");
		String s1=expected.toString();
		Course actual=c.findCourse(2);
		String s2=actual.toString();
		Assert.assertEquals(s1, s2);
		
	}
	@Test
	public void test6() {
		Course cc=new Course(2,"SSC","Baruch");
		String s=cc.toString();
		List<Course> l2=c.listCourses(2);
		String s1=l2.get(0).toString();
		Assert.assertEquals(s,s1);
	}*/
}