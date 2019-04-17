package model;




import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import model.Student;



public class StudentBLL {

	StudentRepository studentRepository;
	private List<Validator<Student>> validators;
	//private StudentDAO studentDAO;
	@Inject
	public StudentBLL(StudentRepository studentRepository) {
		validators=new ArrayList<Validator<Student>>();
		validators.add(new CnpValidator());
		validators.add(new NameValidator());
		validators.add(new EmailValidator());
		this.studentRepository=studentRepository;

	}
	
	//
	public void buildStudent (int id, String name, String cnp,String address,String email,String password,int idgroup) {
		Student c = new Student (id,name,cnp,address,email,password,idgroup);
		for (Validator<Student> v : validators) {
			System.out.println(v.isValid(c));
			if (v.isValid(c)==0) {
				
				throw new IllegalArgumentException("Invalid argument identified by " + v.getClass().getName());
			}
		}
		studentRepository.insert(c);
		
	}
	
	public Student findById(int id) {
		Student st =studentRepository.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The student with id =" + id + " was not found!");
		}
		return st;
	}
	
	public List<Object> findAll() {
		return studentRepository.findAll();
	}
	public List<Object> StudentListId(int id) {
		List<Object> s=new ArrayList<Object>(); 
		s.add(studentRepository.findById(id));
		return s;
	}
	
	
	
	
	public void delete(Student s)
	{
		studentRepository.delete(s);
	}
	
	public void buildStudentForUpdate(int id, String name, String cnp,String address,String email,String password,int idgroup)
	{
		
		Student c = new Student (id,name,cnp,address,email,password,idgroup);
		for (Validator<Student> v : validators) {
			System.out.println(v.isValid(c));
			if (v.isValid(c)==0) {
				
				throw new IllegalArgumentException("Invalid argument identified by " + v.getClass().getName());
			}
		}
		 studentRepository.update(c);
	}
	
	
	public Student findByMail(String x)
	{
		return studentRepository.findByMail(x);
	}
	
	//era pentru findID from email o folosesc pe cea de mai sus
	/*public int findId(String x)
	{
		return studentDAO.findId(x);
	}*/
	//find id group for nuj ce o sa folosesc finby id
	public Student findById1(int id) {
		return studentRepository.findById(id);
	}
	public List<Object> findByIdGroup(int id1) {
		// TODO Auto-generated method stub
		return studentRepository.findByIdGroup(id1);
	}
	
	/*public String findCNP(int id) {
		String x =studentDAO.findCNP(id);
		
		return x;
	}*/
	public static void main(String[] args)
	{
		 Injector guice = Guice.createInjector(new RepositoryGuiceModule());
	     StudentBLL studentBLL = guice.getInstance(StudentBLL.class);
		
		//Student s =new Student(6,"Catalin","1234567890123","Obs","catalin@yahoo.com","catalin",30233);
		//studentBLL.buildStudent(6,"Mihai","1234567890123","Observator","catalin@yahoo.com","catalin",30233);
		//studentBLL.buildStudentForUpdate(4,"Catalin","1234567890123","Obsggghghg","catalin@yahoo.com","catalin",30233);
		//Student s=studentBLL.findById(4);
		//studentBLL.delete(s);
	     List<Object> list=studentBLL.findAll();
			for(Object c: list) {
				System.out.println(c.toString());
			}

		
	}

	
}