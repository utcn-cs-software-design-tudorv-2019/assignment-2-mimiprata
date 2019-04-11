package model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.mapping.Set;
@Entity
@Table(name="school.course")
public class Course {
	/*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idstudent", nullable=false)
    private Student student;
	@ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="idteacher", nullable=false)
	    private Teacher teacher;
	    */
	@Id
	 @Column(name="idcourse")
	//@Generated(value="incrementor")
	// @GenericGenerator(name="incrementor",strategy="increment")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcourse;
	 @Column(name="examDate")
	private Date examDate;
	 @Column(name="idteacher")
	private int idteacher;
	 @Column(name="idstudent")
	private int idstudent;
	 @Column(name="grade")
	private String grade;
	
	public Course() {
		
	}
	public Course (int idcourse, Date examDate, int idteacher, int idstudent, String grade)
	{
		this.idcourse=idcourse;
		this.examDate=examDate;
		this.idteacher=idteacher;
		this.idstudent=idstudent;
		this.grade=grade;
	}
	public Course (Date examDate, int idteacher, int idstudent, String grade)
	{
		this.examDate=examDate;
		this.idteacher=idteacher;
		this.idstudent=idstudent;
		this.grade=grade;
	}
	public int getIdcourse() {
		return idcourse;
	}
	public void setIdcourse(int idcourse) {
		this.idcourse = idcourse;
	}
	public int getIdteacher() {
		return idteacher;
	}
	public void setIdteacher(int idTeacher) {
		this.idteacher = idTeacher;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	public int getIdstudent() {
		return idstudent;
	}
	public void setIdstudent(int idstudent) {
		this.idstudent = idstudent;
	}

	@Override
	public String toString() {
		return "Course [idcourse=" + idcourse  + ",examDate="+examDate+ ",grade=" + grade+ "]";
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
