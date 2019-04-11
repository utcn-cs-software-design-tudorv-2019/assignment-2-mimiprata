package test;


import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.Course;
import model.CourseBLL;
import model.RepositoryGuiceModule;
import model.Student;
import model.StudentBLL;
import model.TeacherBLL;


public class Tests {
	Injector guice=Guice.createInjector(new RepositoryGuiceModule());
	TeacherBLL u=guice.getInstance(TeacherBLL.class);
	StudentBLL studentBLL=guice.getInstance(StudentBLL.class);
	CourseBLL courseBLL=guice.getInstance(CourseBLL.class);
	@Test
	public void test1() {
		Student s=new Student(6,"Mihai","1234567890123","Observator","catalin@yahoo.com","catalin",30233);
		String s1=s.toString();
		Student ss=studentBLL.findById(6);
		String s2=ss.toString();
		Assert.assertEquals(s1,s2);
	}
	@Test
	public void test2() {
		Student s=new Student(6,"Mihai","1234567890123","Observator","catalin@yahoo.com","catalin",30233);
		String s1=s.toString();
		Student ss=studentBLL.findByMail("catalin@yahoo.com");
		String s2=ss.toString();
		Assert.assertEquals(s1, s2);
		
	}
	}