package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.Course;
import model.CourseBLL;
import model.RepositoryGuiceModule;
import model.TeacherBLL;
import tableModel.CourseTableModel;
import view.LoginView;
import view.TeacherOpView;



public class ControllerTeacherOp implements ActionListener {
	private TeacherOpView view;
	private int id;
	private TeacherBLL teacherBLL;
	private CourseTableModel tableC;
	private CourseBLL courseBLL;
	public ControllerTeacherOp(TeacherOpView v,int id){
		this.view = v;
		this.id = id;
		Injector guice = Guice.createInjector(new RepositoryGuiceModule());
	     teacherBLL = guice.getInstance(TeacherBLL.class);
	     courseBLL=guice.getInstance(CourseBLL.class);
		tableC=new CourseTableModel();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == view.getManageStudents())
		{
			view.setTeacherView();
		}
		if (source == view.getReports())
		{
			view.setReportView(id);
			
		}
		if(source==view.getView())
		{
			JTable x =new JTable();
			x.setModel(courseBLL.tableCourses(id));
				this.view.setTable(x);
		}
		
		if (source == view.getSetDate())
		{
			Course c = courseBLL.findById(id);
			c.setExamDate(view.getEnterDate1());
			courseBLL.update(c);
		}
		if (source == view.getSetGrade())
		{
			view.dispose();
		
			view.setGradeView(id);
		}
		if (source == view.getBack())
		{
			view.dispose();
			  LoginView login=new LoginView();
			
		}
	}
	
	

}
