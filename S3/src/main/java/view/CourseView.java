package view;

import java.awt.BorderLayout;
import java.util.List;
import java.lang.reflect.Field;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.google.inject.Guice;
import com.google.inject.Injector;

import controller.ControllerCourse;
import model.CourseBLL;
import model.RepositoryGuiceModule;
import model.StudentBLL;
import model.TeacherBLL;
import tableModel.CourseTableModel;
import tableModel.TeacherTableModel;



public class CourseView extends JFrame{
	private  ControllerCourse controllercourse;
	private JLabel textt;
	 private JButton mycourses;
	
	
	private JTextField name1;
	
	private JTable table;
	private JTable table1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane1;
	private CourseTableModel tableC;
	private TeacherTableModel tableT;
	private JButton logout;
	private JButton enrol;
	private CourseBLL courseBLL;
	private TeacherBLL teacherBLL;
	
	
	public CourseView(int id)
	{
		
		 
		 table1=new JTable();
		 scrollPane= new JScrollPane();
		 scrollPane1 = new JScrollPane();
		controllercourse=new ControllerCourse(this,id);
		tableC=new CourseTableModel();
		tableT=new TeacherTableModel();
		Injector guice = Guice.createInjector(new RepositoryGuiceModule());
	     teacherBLL = guice.getInstance(TeacherBLL.class);
	    courseBLL=guice.getInstance(CourseBLL.class);
	  
		textt=new JLabel("Pick a course!");
		setEnrol(new JButton("Enrol!"));
		setMycourses(new JButton("My Courses"));
		setLogout(new JButton("Logout"));
		
		JTable table=new JTable();
		
		 table=tableC.teacherTable(teacherBLL.showTeachers());
		 
		 this.setTable(table);
		
		
		this.setTitle("Enrol");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);

		
		
		JPanel panel2=new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		
		panel2.add(textt);
		panel2.add(getEnrol());
		panel2.add(getMycourses());
		panel2.add(getLogout());
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout(0, 0));

		tablePanel.add(scrollPane);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		this.add(panel3);
		panel3.add(panel2);
		panel3.add(tablePanel);
		this.setVisible(true);
		
		getEnrol().addActionListener(controllercourse);
		getMycourses().addActionListener(controllercourse);
		getLogout().addActionListener(controllercourse);
		
	}
	
	public void setTable(JTable newTable) {
		this.table = newTable;
	System.out.println("----"+table.getColumnName(1));
		
		scrollPane.setViewportView(table);
		repaint();
		revalidate();
	}

	public JButton getLogout() {
		return logout;
	}

	public void setLogout(JButton logout) {
		this.logout = logout;
	}

	public JButton getMycourses() {
		return mycourses;
	}

	public void setMycourses(JButton mycourses) {
		this.mycourses = mycourses;
	}

	public JButton getEnrol() {
		return enrol;
	}

	public void setEnrol(JButton enrol) {
		this.enrol = enrol;
	}

	public JTable getTable() {
		return table;
	}
	
	
	
	 
	
	
}
