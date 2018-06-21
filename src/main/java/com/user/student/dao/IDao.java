package com.user.student.dao;

import java.util.List;

import com.user.student.entities.Student;

public interface IDao {

	public List<Student> getStudents();// ok----

	public Student addStudent(Student student);// ok------

	public boolean deleteStudent(int id);//ok	---

	public Student updateStudente(Student student);// ok	---

	public List<Student> getStudentsByName(String name);// ok------

	public Student getStudentByID(int id);// ok-------
	// ANOTHER METHOD WITH CONTAINS METHOD
}
