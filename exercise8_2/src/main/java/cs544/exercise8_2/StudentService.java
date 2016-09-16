package cs544.exercise8_2;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentService {
	private StudentDAO studentdao;
	private  SessionFactory sf ;//= HibernateUtil.getSessionFactory();

	public StudentService() {
		
	}

	public void setStudentdao(StudentDAO studentdao) {
		this.studentdao = studentdao;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public Student getStudent(long studentid) {
		Transaction tx = sf.getCurrentSession().beginTransaction();
		Student student = studentdao.load(studentid);;
		Hibernate.initialize(student.getCourselist());
		tx.commit();
		return student;
	}
}
