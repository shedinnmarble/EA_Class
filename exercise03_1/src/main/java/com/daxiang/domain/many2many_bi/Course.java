package com.daxiang.domain.many2many_bi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
public class Course {
	@Id
	@GeneratedValue
	private int id;
	private String courseNumber;
	private String name;
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Student> students=new ArrayList<Student>();
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course(String courseNumber, String name) {
		super();
		this.courseNumber = courseNumber;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
