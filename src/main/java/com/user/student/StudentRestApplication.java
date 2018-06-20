package com.user.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.user.student.dao.IDao;
import com.user.student.entities.Student;

@SpringBootApplication
@EntityScan(basePackages = { "com.user.student.entities" })
@ComponentScan(basePackages = { "com.user.student.dao" })
@ComponentScan(basePackages = { "fr.user.student.service" })

public class StudentRestApplication implements CommandLineRunner {

	@Autowired

	private IDao idDao;
	public static void main(String[] args) {
		SpringApplication.run(StudentRestApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Student ali = idDao.addStudent(new Student(060606, "Ali", "belhadj", "ali.belhadj@gmail.com"));
		Student abdessalem = idDao
				.addStudent(new Student(070707, "Abdessalem", "belhadj", "abdessalem.belhadj@gmail.com"));
		Student mohamed = idDao.addStudent(new Student(050505, "Mohamed", "belhadj", "mohamed.belhadj@gmail.com"));
		Student rabii = idDao.addStudent(new Student(040404, "Rabii", "belhadj", "rabii.belhadj@gmail.com"));

		List<Student> students = new ArrayList<>();
		students.add(ali);
		students.add(abdessalem);
		students.add(mohamed);
		students.add(rabii);
//		idDao.deleteStudent(3);
		rabii.setEmail("belhadj.rabii.updated@gmail.com");
		students=idDao.getStudents();
		System.out.println(students);
		System.out.println("the user is "+idDao.getStudentByID(1));
	}
}
