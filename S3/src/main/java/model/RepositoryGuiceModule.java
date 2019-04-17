package model;



public class RepositoryGuiceModule  extends com.google.inject.AbstractModule{

    @Override
    protected void configure() {
       bind(StudentRepository.class).to(StudentDAO.class);
       bind(TeacherRepository.class).to(TeacherDAO.class);
       bind(CourseRepository.class).to(CourseDAO.class);
    }
    
}
