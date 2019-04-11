package model;

import java.util.List;

public interface TeacherRepository {

	public void delete(Teacher objectToDelete);
	public void update(Teacher objectToUpdate);
    public void insert(Teacher objectToCreate);
    public List<Object> createObjects(Class type);
    public Teacher findByMail(String email);
	public List<Object> findAll();
	
    
}
