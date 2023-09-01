package com.luv2code.demorestcrud.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demorestcrud.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	// define @PostConstruct to load the students data
	@PostConstruct
	public void loadData() {
		theStudents=new ArrayList<>();
		theStudents.add(new Student("Aditi","patel"));
		theStudents.add(new Student("mario","pal"));
		theStudents.add(new Student("carlo","tale"));
		
	}
	
	//define endpoint for"/students"-return a list of students
	@GetMapping("/students")
	public List<Student> getStudents(){		
		return theStudents;
	}
	
	//define endpoint for"/students/(studentId)"-return student at index
		@GetMapping("/students/{studentId}")
		public Student getStudent(@PathVariable int studentId){		
			
			//just index into the list ...keep it simple for now
			
			//check the studentID against the list size
			
			if((studentId >= theStudents.size()) || (studentId < 0)){
			throw new StudentNotFoundException("Student id not found-"+studentId, null);
		    }
			return theStudents.get(studentId);
		}	

		
		//commenting code to use Controller advice for global exception handling
		//Add exception handler using @ExceptionHandler
		/*
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
			
			//Create a StudentError Response
			
			StudentErrorResponse error = new StudentErrorResponse();
			
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			//Return Response Entity
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
			
		}
		
		//add another exception handler to catch any exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (Exception exc){
    	//Create a StudentError Response
    	StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//Return Response Entity
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
    	
    }
    */
    


}

