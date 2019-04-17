package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.*;
import view.LoginView;

public class ControllerLogin implements ActionListener {
	private LoginView view;
	//private TeacherBLL teacherBLL= new TeacherBLL();
	//private StudentBLL studentBLL= new StudentBLL();
	Injector guice = Guice.createInjector(new RepositoryGuiceModule());
    StudentBLL studentBLL = guice.getInstance(StudentBLL.class);
    
    TeacherBLL teacherBLL = guice.getInstance(TeacherBLL.class);
	public ControllerLogin(LoginView v){
		this.view = v;

	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String value = (String) view.cb.getSelectedItem();
		Object source = e.getSource();
		if(source == view.login) {
		
			String pass1= view.getPasswordT();
			
			
			if (value.equals("Student")){
				
				String pass2 = studentBLL.findByMail(view.getEmailT()).getPassword();
				if (pass1.equals(pass2)){
					
					int id = studentBLL.findByMail(view.getEmailT()).getIdstudent();
				
				view.dispose();
				 view.setStudentView(id);
			}
			}
			if (value.equals("Teacher")) {
				String pass2 = teacherBLL.findByMail(view.getEmailT()).getPassword();
				
				if (pass1.equals(pass2)){
					
					int id = teacherBLL.findByMail(view.getEmailT()).getIdteacher();
					System.out.println(id);
					view.dispose();
					view.setTeacherOpView(id);
					
			}
	}


}
		if (source== view.register)
		{
			if (value.contentEquals("Student"))
			{
			view.setRegisterView();
			}
			else  JOptionPane.showMessageDialog(null,"Please register as student!", null,
					JOptionPane.ERROR_MESSAGE);  
			}
	}
	}

