package ca.jeonghoon.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.jeonghoon.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// Define end point for "/students" - which returns a list of students
	@GetMapping("/students")
	public List<Student> getStudents() {

		List<Student> theStudents = new ArrayList<>();

		theStudents.add(new Student("Sheldon", "Couper"));
		theStudents.add(new Student("Penny", "Rossi"));
		theStudents.add(new Student("Leonard", "Smith"));

		// @RestController will pass list of students to Jackson project
		// and Jackson will convert it to a JSON array and then the result 
		// will return to the user
		return theStudents;
	}
}
//