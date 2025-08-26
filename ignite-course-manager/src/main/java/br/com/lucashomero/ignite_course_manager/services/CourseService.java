package br.com.lucashomero.ignite_course_manager.services;

import java.util.List;
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
	
	
	public List<CourseEntity> getAllCourses() {
		return this.courseRepository.findAll(); 
	}
	
	public CourseEntity createCourse(CourseEntity courseEntity) {
		this.courseRepository.findByName(courseEntity.getName()).ifPresent(course -> {
			throw new CourseFoundException();
		});
		
		courseEntity.activateCourse();
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
	
	public CourseEntity deleteCourse(UUID id, CourseEntity courseEntity) {
		
		Optional<CourseEntity> course = courseRepository.findById(id);
		
		if(course.isPresent()) {
			courseEntity.setId(id);
			courseRepository.deleteById(id);
		}
		
		return courseEntity;
	}
	
	public CourseEntity patchCourse(UUID id) {
		
		Optional<CourseEntity> course = courseRepository.findById(id);
		CourseEntity data = course.get();		
		
		if (data.getActive() == true) {
				data.deactivateCourse();
				data.updateTime(data);
				courseRepository.save(data);
				return data;
			}
		
		if(data.getActive() == false) {
			data.activateCourse();
			data.updateTime(data);
			courseRepository.save(data);
			return data;
		}
		
		return data;
		
	}
	
	
	
}
