package br.com.lucashomero.ignite_course_manager.controller;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucashomero.ignite_course_manager.entity.CourseEntity;
import br.com.lucashomero.ignite_course_manager.repository.CourseRepository;
import br.com.lucashomero.ignite_course_manager.services.CourseService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	@GetMapping("/")
	public ResponseEntity<Object> getAll(){

		var allProducts = courseRepository.findAll();		
		return ResponseEntity.ok().body(allProducts);
		
	}
	
	@PostMapping("/")
	public ResponseEntity<Object> postCourse(@Valid @RequestBody CourseEntity courseEntity){
		
		try {
			
			var data = this.courseService.createCourse(courseEntity);
			return ResponseEntity.ok().body(data);
			
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
}
