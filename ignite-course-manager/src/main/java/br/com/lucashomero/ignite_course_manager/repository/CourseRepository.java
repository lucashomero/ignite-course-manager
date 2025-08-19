package br.com.lucashomero.ignite_course_manager.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucashomero.ignite_course_manager.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

}
