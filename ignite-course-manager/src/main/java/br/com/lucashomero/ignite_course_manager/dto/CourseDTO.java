package br.com.lucashomero.ignite_course_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

	private String name;
	private String categoria;
	private String returnMessage;
	
}
