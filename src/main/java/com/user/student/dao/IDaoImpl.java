package com.user.student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.user.student.entities.Student;
import com.user.student.entities.User;

@Repository
@Transactional
public class IDaoImpl implements IDao {

	
	public IDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Student> getStudents() {

		Query query = entityManager.createQuery("from Student student");
		@SuppressWarnings("unchecked")
		List<Student> students = query.getResultList();

		return students;
	}

	@Override
	public List<Student> getStudentsByName(String name) {

		Query query = entityManager.createQuery("from Student student where student.name like :name")
				.setParameter("name", name);
		@SuppressWarnings("unchecked")
		List<Student> students = query.getResultList();

		return students;
	}

	@Override
	public Student getStudentByID(int id) {

		Student student = entityManager.find(Student.class, id);

		return student;
	}

	@Override
	public Student addStudent(Student student) {

		entityManager.persist(student);

		return student;
	}

	@Override
	public Student updateStudente(Student student) {

		return entityManager.merge(student);
	}

	@Override
	public boolean deleteStudent(int id) {

		User user = entityManager.find(User.class, id);

		entityManager.remove(user);
		return true;
	}
}
