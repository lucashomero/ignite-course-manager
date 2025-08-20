package br.com.lucashomero.ignite_course_manager.exceptions;

public class CourseFoundException extends RuntimeException {

	public CourseFoundException() {
		super("Course already exists.");
	}
	
}
