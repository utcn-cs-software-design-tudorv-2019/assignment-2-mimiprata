package model;

import java.util.List;

public interface StudentRepository {
	public void delete(Student objectToDelete);
	public void insert(Student objectToInsert);
	public void update(Student objectToUpdate);
	public Student findByMail(String email);
	public List<Object> createObjects(Class type);
	 public Student findById (int id);
	 public List<Object> findByIdGroup (int id);
	 public List<Object> findAll();
	
	
}
