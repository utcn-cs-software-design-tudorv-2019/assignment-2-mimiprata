package model;


import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import model.Student;
import model.Teacher;

public class TeacherBLL {
	TeacherRepository teacherRepository;
	StudentRepository studentRepository;
	//private List<Validator<Client>> validators;
	//private StudentDAO studentDAO;
	//private TeacherDAO teacherDAO;
	@Inject
	public TeacherBLL(TeacherRepository teacherRepository) {
	//	validators=new ArrayList<Validator<Client>>();
		//validators.add(new EmailValidator());
		//studentDAO=new StudentDAO();
		//teacherDAO=new TeacherDAO();
		this.teacherRepository=teacherRepository;
	}
	
	//
	
	public Student findClientById(int id) {
		Student st =studentRepository.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The student with id =" + id + " was not found!");
		}
		return st;
	}
	
	public List<Object> findAll() {
		return studentRepository.findAll();
	}
	public List<Object> showTeachers() {
		System.out.print("A INTRAT IN BLL");
		return teacherRepository.findAll();
	}
	
	public void buildStudent (int id, String name, String cnp,String address,String email,String password,int idgroup) {
		Student c = new Student (id,name,cnp,address,email,password,idgroup);
		 studentRepository.insert(c);
		
	}
	
	public void delete(Student s)
	{
		studentRepository.delete(s);
	}
	
	public void buildStudentForUpdate(int id, String name, String cnp,String address,String email,String password,int idgroup)
	{
		Student c = new Student (id,name,cnp,address,email,password,idgroup);
		 studentRepository.update(c);
	}
	//pt parola si id
	public Teacher findByMail(String x)
	{
		return teacherRepository.findByMail(x);
	}
	/*
	public int findId(String x)
	{
		return teacherDAO.findId(x);
	}*/
	/*public TableModel tableGroup(int id)
	{
		return teacherDAO.tableGroup(id);
	}*/
	public static void main(String[] args)
	{
		Injector guice = Guice.createInjector(new RepositoryGuiceModule());
	     TeacherBLL teacherBLL = guice.getInstance(TeacherBLL.class);
		
		//teacherBLL.buildStudent(4,"Catalin","1234567890123","Observator","catalin@yahoo.com","catalin",30233);
		//teacherBLL.buildStudentForUpdate(4,"Catalin","1234567890123","Obs","catalin@yahoo.com","catalin",30233);
		//Student s=studentBLL.findById(4);
		//studentBLL.delete(s);
	    String mail = "ion@utcluj.ro";
	    System.out.println(teacherBLL.findByMail(mail));
		List<Object> list=teacherBLL.showTeachers();
		for(Object c: list) {
			System.out.println(c.toString());
		}
		
	}
}