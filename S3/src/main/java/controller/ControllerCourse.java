package controller;

import model.CourseBLL;
import model.RepositoryGuiceModule;
import tableModel.CourseTableModel;
import model.TeacherBLL;
import view.CourseView;
import view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.google.inject.Guice;
import com.google.inject.Injector;



public class ControllerCourse implements ActionListener{
	private CourseView view;
	private int id;
	private CourseBLL courseBLL;
	private TeacherBLL teacherBLL;
	private CourseTableModel ctm;
	public ControllerCourse(CourseView v, int id)
	{
		this.view=v;
		this.id=id;
		Injector guice = Guice.createInjector(new RepositoryGuiceModule());
	     teacherBLL = guice.getInstance(TeacherBLL.class);
	    courseBLL=guice.getInstance(CourseBLL.class);
		this.ctm=new CourseTableModel();
		//System.out.println("ddddddddddddddddddddd"+id);
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == view.getEnrol()) {
			
			int row = view.getTable().getSelectedRow();
			int idteacher=Integer.parseInt(view.getTable().getValueAt(row,0).toString());
			courseBLL.setCourse(idteacher, id);
			JOptionPane.showMessageDialog(null,"You have registered to this course!", null,
					JOptionPane.OK_OPTION);  
			
	}
		if (source ==view.getMycourses())
		{
			JTable x =new JTable();
			//x.setModel(courseBLL.tableGradeStud(id));
			x.setModel(courseBLL.tableMyGrades(id));
			view.setTable(x);
		}
		if(source == view.getLogout())
		{
			  
		            view.dispose();
		            // northInformation.removeAll();
		            // init();
		          LoginView login=new LoginView();
		       
		}
		
	}
	

	
	private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
	     JTable source = (JTable)evt.getSource();
	            int row = source.rowAtPoint( evt.getPoint() );
	            int column = source.columnAtPoint( evt.getPoint() );
	            String s=source.getModel().getValueAt(row, column)+"";
System.out.println(s);
	           // JOptionPane.showMessageDialog(null, s);


	}
}
