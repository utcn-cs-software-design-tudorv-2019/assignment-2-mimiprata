package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.google.inject.Guice;
import com.google.inject.Injector;

import controller.ControllerReport;
import model.CourseBLL;
import model.RepositoryGuiceModule;
import model.Student;
import model.StudentBLL;
import model.TeacherBLL;
import tableModel.CourseTableModel;



public class ReportView extends JFrame{
	private JButton back;
	private JButton mystudents;
	JButton mystudentsprint;
	private JButton studentsgroup;
	JTable table;
	private ControllerReport controllerreportview;
	private JScrollPane scrollPane;
	private CourseBLL courseBLL;
	private CourseTableModel tableC;
	private StudentBLL studentBLL;
	private TeacherBLL teacherBLL;
	private JLabel idgroup;
	private JTextField idgroup1;
	public ReportView(int id)
	{
		controllerreportview=new ControllerReport(this,id);
		idgroup1=new JTextField(3);
		idgroup=new JLabel("Enter Group");
		scrollPane=new JScrollPane();
		tableC=new CourseTableModel();
		Injector guice = Guice.createInjector(new RepositoryGuiceModule());
	     teacherBLL = guice.getInstance(TeacherBLL.class);
	    courseBLL=guice.getInstance(CourseBLL.class);
	    studentBLL=guice.getInstance(StudentBLL.class);
		table=new JTable();
		scrollPane=new JScrollPane();
		setBack(new JButton("Back"));
		setMystudents(new JButton("View My Students"));
		setStudentsgroup(new JButton("View/Print"));
		
		this.setTitle("Reports");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		JPanel panel1=new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		// panel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add( Box.createRigidArea(new Dimension(2,2)) );
		idgroup.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(idgroup);
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		idgroup1.setAlignmentX(Component.CENTER_ALIGNMENT);
		idgroup1.setMaximumSize(new Dimension(60, 20));
		panel1.add(idgroup1);
		panel1.setPreferredSize(new Dimension(150, 500));
		panel1.setMaximumSize(new Dimension(150, 500));


		
		//JPanel panel2=new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.add(getStudentsgroup());
		panel1.add(getMystudents());
		
		panel1.add(getBack()) ;
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout(0, 0));

		tablePanel.add(scrollPane);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		this.add(panel3);
		
		panel3.add(panel1);
		panel3.add(tablePanel);
		this.setVisible(true);
		getMystudents().addActionListener(controllerreportview);
		getStudentsgroup().addActionListener(controllerreportview);
		getBack().addActionListener(controllerreportview);
		
	}
	public int getIdgroup1() {
		return Integer.parseInt(idgroup1.getText());
	}
	public void setIdgroup1(JTextField idgroup1) {
		this.idgroup1 = idgroup1;
	}
	public void setTable(JTable newTable) {
		this.table = newTable;
		System.out.println("----"+table.getColumnName(1));

		scrollPane.setViewportView(table);
		repaint();
		revalidate();
	}
	public JButton getBack() {
		return back;
	}
	public void setBack(JButton back) {
		this.back = back;
	}
	public JButton getMystudents() {
		return mystudents;
	}
	public void setMystudents(JButton mystudents) {
		this.mystudents = mystudents;
	}
	public JButton getStudentsgroup() {
		return studentsgroup;
	}
	public void setStudentsgroup(JButton studentsgroup) {
		this.studentsgroup = studentsgroup;
	}
	

}
