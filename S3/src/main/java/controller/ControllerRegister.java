package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.google.inject.Guice;
import com.google.inject.Injector;

import view.RegisterView;
import model.RepositoryGuiceModule;
import model.StudentBLL;

public class ControllerRegister implements ActionListener {
	private RegisterView view;
	Injector guice = Guice.createInjector(new RepositoryGuiceModule());
    StudentBLL studentBLL = guice.getInstance(StudentBLL.class);
	public ControllerRegister(RegisterView v){
		this.view = v;

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == view.register) {
		studentBLL.buildStudent(view.getIdstudentT(), view.getNameT(), view.getCnpT(), view.getAddressT(), view.getEmailT(), view.getPasswordT(), view.getIdgroupT());
		view.dispose();
		view.setLoginView();
		}
	}

}
