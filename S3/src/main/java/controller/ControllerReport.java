package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.CourseBLL;
import model.RepositoryGuiceModule;
import model.Student;
import model.StudentBLL;
import model.TeacherBLL;
import tableModel.CourseTableModel;
import view.ReportView;



public class ControllerReport implements ActionListener{
	private ReportView view;
	private int id;
	private TeacherBLL teacherBLL;
	private StudentBLL studentBLL;
	private CourseTableModel tableC;
	private CourseBLL courseBLL;
	private FileWriter fw = null;
	private BufferedWriter bw = null;
	
	public ControllerReport(ReportView v,int id){
		this.view = v;
		this.id = id;
		Injector guice = Guice.createInjector(new RepositoryGuiceModule());
	     teacherBLL = guice.getInstance(TeacherBLL.class);
	    courseBLL=guice.getInstance(CourseBLL.class);
	    studentBLL=guice.getInstance(StudentBLL.class);
		tableC=new CourseTableModel();
	}
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == view.getBack())
		{
			view.dispose();
		}
		if(source == view.getMystudents() )
		{
		
		
		TableModel c=courseBLL.tableGrades(id);
		JTable table=new JTable();
		table.setModel(c);
		view.setTable(table);
		
		StringBuffer sbTableData = new StringBuffer();
		for(int row = 0; row < table.getRowCount(); row ++){
		    for(int column = 0; column < table.getColumnCount(); column ++){
		        sbTableData.append(table.getValueAt(row, column)).append("\t");
		    }
			sbTableData.append(System.getProperty("line.separator"));
		    
		}
		try {
			fw = new FileWriter("Students" + id+"_p" + ".txt");
			bw = new BufferedWriter(fw);
			bw.write(sbTableData.toString());
			bw.flush();
		}catch(IOException e1){
			e1.printStackTrace();
	}
		

	
	
		}
		if(source==view.getStudentsgroup())
		{
			int id1 =view.getIdgroup1();
			//TableModel c=teacherBLL.tableGroup(id1);
			JTable x=new JTable();
			
			//table.setModel(c);
			
		
			//view.setTable(table);	
			 x=tableC.createTable( studentBLL.findByIdGroup(id1));
			view.setTable(x);
			StringBuffer sbTableData = new StringBuffer();
			for(int row = 0; row < x.getRowCount(); row ++){
			    for(int column = 0; column < x.getColumnCount(); column ++){
			        sbTableData.append(x.getValueAt(row, column)).append("\t");
			    }
				sbTableData.append(System.getProperty("line.separator"));
			    
			}
		
		try {
			fw = new FileWriter("Students_" + id1+"_p" + ".txt");
			bw = new BufferedWriter(fw);
			bw.write(sbTableData.toString());
			bw.flush();
		}catch(IOException e1){
			e1.printStackTrace();
	}
		}
	}
}

