package br.com.lucashomero.ignite_course_manager.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "course")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CourseEntity {

	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@NotBlank(message = "o campo [name] deve conter um valor")
	private String name;

	@NotBlank(message = "o campo [categoria] deve conter um valor")
	private String categoria;

	private Boolean active;
	
	@CreationTimestamp
	private LocalDateTime created_at;

	@CreationTimestamp
	private LocalDateTime updated_at;
	
	
	
	
	
}
