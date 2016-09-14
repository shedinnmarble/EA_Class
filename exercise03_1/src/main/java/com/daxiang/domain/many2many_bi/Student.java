package com.daxiang.domain.many2many_bi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
public class Student {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int studentid;
	private String firstname;
	private String lastname;
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Course> courses=new ArrayList<Course>();
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	

}
