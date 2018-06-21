package fr.user.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.student.dao.IDao;
import com.user.student.entities.Student;

@RestController
public class ServiceController { // A CHAQUE FOIS IL FAUT CHANGER LA PATH

	@Autowired
	private IDao iDao;

	// ALL STUDENTS

	@GetMapping(value = "/students")
	public List<Student> getAllStudents() {
		return iDao.getStudents();
	}

	// STUDENTS BY NAME

	@GetMapping(value = "students/{name}")
	public List<Student> getStudentsByName(@PathVariable(value = "name") String name) {
		return iDao.getStudentsByName(name);
	}

	// STUDENTS BY NAME SECOND METHOD WITH REQUEST PARAM

	@GetMapping(value = "studentsSecondMethod")
	public List<Student> getStudentsByNameSecondMethod(@RequestParam(name = "name") String name) {
		return iDao.getStudentsByName(name);
	}

	// STUDENT BY ID FIRST METHOD I D'ONT ADVICE CAUSE THE ID IS SHOW IT

	@GetMapping(value = "/studentsByID/{id}")
	public Student getStudentByID(@PathVariable(value = "id") int id) {
		return iDao.getStudentByID(id);
	}

	// STUDENT BY ID WITH SECOND METHOD

	@RequestMapping(value = "/studentsByIDSecond", method = RequestMethod.GET)
	public Student getStudentByIDSecondMethod(@RequestParam(name = "id") int id) {

		return iDao.getStudentByID(id);
	}

	// ADD A STUDENT

	@PostMapping(value = "/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return iDao.addStudent(student);
	}

	// DELETE STUDENT FIRST METHOD

	@DeleteMapping(value = "/deleteStudent/{id}")
	public void deleteStudente(@PathVariable(value = "id") int id) {
		iDao.deleteStudent(id);
	}

	// DELETE METHOD WITH SECOND METHOD REQUESTPARAM

	@DeleteMapping(value = "/deleteStudentSecondMethod")
	public void deleteStudenteSecondMethod(@RequestParam(name = "id") int id) {
		iDao.deleteStudent(id);
	}

	// UPDATE STUDENT
	@PutMapping(value = "/updateStudent/{id}")
	public Student updateStudente(@PathVariable(value = "id") int id, @RequestBody Student student) {
		return iDao.updateStudente(student);
	}
}
