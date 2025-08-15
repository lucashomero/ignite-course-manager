package br.com.lucashomero.ignite_course_manager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@GetMapping("/")
	public ResponseEntity<String> getAllCourses(){
		
		return ResponseEntity.ok("deu ok");
	}
	
}
