package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.RepositoryGuiceModule;
import model.StudentBLL;
import model.TeacherBLL;
import tableModel.StudentTableModel;
import view.StudentView;

public class ControllerStudent implements ActionListener{
	private StudentView view;
	private StudentBLL studentBLL;
	private StudentTableModel tableC;
	private int id;
	public ControllerStudent(StudentView v, int id){
		this.view = v;
		this.id=id;
		Injector guice = Guice.createInjector(new RepositoryGuiceModule());
	    this.studentBLL = guice.getInstance(StudentBLL.class);
	
		this.tableC=new StudentTableModel();
	
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == view.getV())
		{
			JTable x=tableC.createTable(studentBLL.StudentListId(id));
			this.view.setTable(x);
		}
		if(source==view.getEnrol())
		{
			view.dispose();
			view.setCourseView(id);
			
		}
		/*if(source==view.sterge)
		{
			int id=view.getId1();
			studentBLL.delete(id);
			
		}*/
		if(source==view.getUpdate())
		{
			
			studentBLL.buildStudentForUpdate(id, view.getName1(),studentBLL.findById(id).getCnp(),view.getAdress1(),view.getEmail1(), view.getPassword1(), studentBLL.findById(id).getIdgroup());
			
		}
		
	}
}
