package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.Course;
import model.CourseBLL;
import model.RepositoryGuiceModule;
import model.StudentBLL;
import model.TeacherBLL;
import tableModel.CourseTableModel;
import view.GradeView;

public class ControllerGrade implements ActionListener {
	private GradeView view;
	private int id;
	private CourseTableModel tableC;
	private CourseBLL courseBLL;
	private StudentBLL studentBLL;
	public ControllerGrade(GradeView v,int id){
		this.view = v;
		this.id = id;
		Injector guice = Guice.createInjector(new RepositoryGuiceModule());
	     studentBLL = guice.getInstance(StudentBLL.class);
	     courseBLL=guice.getInstance(CourseBLL.class);
		tableC=new CourseTableModel();
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source==view.getView())
		{
			JTable x =new JTable();
			x.setModel(courseBLL.tableGrades(id));
	view.setTable(x);
		}
		if (source == view.getBack())
		{
			
			view.dispose();
			//view.setTeacherOpView(id);
		}
		if (source == view.getSetGrade())
		{
			
			int row = view.getTable().getSelectedRow();
			String emailStudent=view.getTable().getValueAt(row,1).toString();
			/*int idStudent = studentBLL.findId(emailStudent);
			System.out.println(idStudent+ "id Stud");
			
			courseBLL.setGrade(idStudent,id,view.getEnterGrade1());	*/
			Course c=courseBLL.findByIdStudent(studentBLL.findByMail(emailStudent).getIdstudent());
			c.setGrade(view.getEnterGrade1());
			courseBLL.update(c);
			
		}
		
	}

}
