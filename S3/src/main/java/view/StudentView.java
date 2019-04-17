package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;

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

import controller.ControllerStudent;
import model.CourseBLL;
import model.RepositoryGuiceModule;
import model.StudentBLL;
import model.TeacherBLL;
import tableModel.StudentTableModel;



public class StudentView extends JFrame {


	private StudentBLL studentBLL;
	private StudentTableModel tableC;
	
	private JLabel name;
	private JLabel adress;
	private JLabel email;
	
	private JLabel password ;
	private JLabel idgroup ;



	ControllerStudent controllerstudent ;
	
	private JTextField name1;
	private JTextField adress1;
	private JTextField email1;
	
	private JTextField password1;
	private JTextField idgroup1;
	private JTable table;
	private JScrollPane scrollPane;
	
	private JButton v;
	private JButton enrol;
	private JButton update;
	private StudentView viewStudent;
	private CourseView viewCourse;
	public StudentView(int id)
	{
		controllerstudent=new ControllerStudent(this,id);

		name=new JLabel("Name:");
		adress=new JLabel("Address:");
		email=new JLabel("Email:");
		
		password = new JLabel("Password:");
	
		tableC=new StudentTableModel();
		Injector guice = Guice.createInjector(new RepositoryGuiceModule());
	    studentBLL = guice.getInstance(StudentBLL.class);
	    

		name1=new JTextField(3);
		adress1=new JTextField(3);
		email1=new JTextField(3);
		password1=new JTextField(3);
		idgroup1=new JTextField(3);
	
		table=new JTable();
		scrollPane=new JScrollPane();
		setEnrol(new JButton("Enrol to a course"));
		setV(new JButton("View"));

		setUpdate(new JButton("Edit"));
		JTable x=tableC.createTable( studentBLL.StudentListId(id));
		this.setTable(x);
		this.setTitle("Student operations");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);

		JPanel panel1=new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		// panel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add( Box.createRigidArea(new Dimension(2,2)) );
		/*id.setAlignmentX(Component.CENTER_ALIGNMENT);
		/*panel1.add(id);
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		id1.setAlignmentX(Component.CENTER_ALIGNMENT);
		id1.setMaximumSize(new Dimension(60, 20));
		panel1.add(id1);*/
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		name.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(name);
		panel1.add( Box.createRigidArea(new Dimension(10,5)) );
		name1.setMaximumSize(new Dimension(145, 20));
		name1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(name1);
		
		//address
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		adress.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(adress);
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		adress1.setAlignmentX(Component.CENTER_ALIGNMENT);
		adress1.setMaximumSize(new Dimension(150, 20));
		panel1.add(adress1);
		//email
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		email.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(email);
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		email1.setAlignmentX(Component.CENTER_ALIGNMENT);
		email1.setMaximumSize(new Dimension(150, 20));
		panel1.add(email1);
		//password
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		password.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(password);
		panel1.add( Box.createRigidArea(new Dimension(10,5)) );
		password1.setMaximumSize(new Dimension(145, 20));
		password1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(password1);

		//idgroup
		/*panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		idgroup.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(idgroup);
		panel1.add( Box.createRigidArea(new Dimension(10,5)) );
		idgroup1.setMaximumSize(new Dimension(145, 20));
		idgroup1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(idgroup1);*/
		

		panel1.setPreferredSize(new Dimension(150, 500));
		panel1.setMaximumSize(new Dimension(150, 500));


		
		JPanel panel2=new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel2.add(getV());
		panel2.add(panel1);
		panel2.add(getEnrol());
		panel2.add(getUpdate());
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout(0, 0));

		tablePanel.add(scrollPane);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		this.add(panel3);
		panel3.add(panel2);
		panel3.add(tablePanel);
		this.setVisible(true);
		getV().addActionListener(controllerstudent);
		getEnrol().addActionListener(controllerstudent);
		getUpdate().addActionListener(controllerstudent);


	}

	
	public String getName1() {
		return name1.getText();
	}

	public String getAdress1() {
		return adress1.getText();
	}

	public String getEmail1() {
		return email1.getText();
	}
	

	public String getPassword1() {
		return password1.getText();
	}
	public void setPassword1(JTextField password1) {
		this.password1 = password1;
	}
	public void setTable(JTable newTable) {
		this.table = newTable;
		System.out.println("----"+table.getColumnName(1));

		scrollPane.setViewportView(table);
		repaint();
		revalidate();
	}
	public void setCourseView(int id) {
		// TODO Auto-generated method stub
		viewCourse = new CourseView(id);
	}


	public JButton getV() {
		return v;
	}


	public void setV(JButton v) {
		this.v = v;
	}


	public JButton getEnrol() {
		return enrol;
	}


	public void setEnrol(JButton enrol) {
		this.enrol = enrol;
	}


	public JButton getUpdate() {
		return update;
	}


	public void setUpdate(JButton update) {
		this.update = update;
	}

}
