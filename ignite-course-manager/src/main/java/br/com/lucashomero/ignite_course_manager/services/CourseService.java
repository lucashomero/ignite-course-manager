package br.com.lucashomero.ignite_course_manager.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.lucashomero.ignite_course_manager.entity.CourseEntity;
import br.com.lucashomero.ignite_course_manager.exceptions.CourseFoundException;
import br.com.lucashomero.ignite_course_manager.repository.CourseRepository;


@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public CourseEntity createCourse(CourseEntity courseEntity) {
		this.courseRepository.findByName(courseEntity.getName()).ifPresent(course -> {
			throw new CourseFoundException();
		});
		
		return this.courseRepository.save(courseEntity);
	}

	public CourseEntity editCourse(UUID id, CourseEntity courseEntity) {
		
		Optional<CourseEntity> course = courseRepository.findById(id);
		
		if (course.isPresent()) {
			courseEntity.setId(id);
			courseEntity.updateTime(course.get());
			courseRepository.save(courseEntity);	
		}
		
		return courseEntity;
	}	
}
