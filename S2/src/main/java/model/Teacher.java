package model;

import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name="school.teacher")
public class Teacher {
	/*@OneToMany(mappedBy="teacher")
    private Set<Course> courses;*/
	 @Id
	 @Column(name="idteacher")
	private int idteacher;
	 @Column(name="name")
	private String name;
	 @Column(name="courseName")
	private String courseName;
	 @Column(name="phoneNumber")
	private String phoneNumber;
	 @Column(name="email")
	private String email;
	 @Column(name="password")
	private String password;
	
	public Teacher() {
		
	}
	public int getIdteacher() {
		return idteacher;
	}
	public void setIdteacher(int idteacher) {
		this.idteacher = idteacher;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Teacher [idTeacher=" + idteacher + ", name=" + name + ", phoneNumber=" + phoneNumber  + ", email="+email + "]";
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
