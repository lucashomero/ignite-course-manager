package br.com.lucashomero.ignite_course_manager.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucashomero.ignite_course_manager.repository.CourseRepository;
import br.com.lucashomero.ignite_course_manager.services.CreateCourseService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	
	@Autowired
	private CourseRepository courseRepository;
	
	
	@GetMapping("/")
	public ResponseEntity<Object> getAll(){

		var allProducts = courseRepository.findAll();		
		return ResponseEntity.ok().body(allProducts);
			
		
	}
	
}
