package pe.edu.upc.moderneducation.models.entities;

import java.io.Serializable;
import java.util.Objects;

public class DetailCourseStudentId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer course;
	private Integer student;
	
	// Constructor
	public DetailCourseStudentId(Integer course, Integer student) {
		super();
		this.course = course;
		this.student = student;
	}

	public DetailCourseStudentId() {
		super();
	}

	// Getters and Setters
	public Integer getCourse() {
		return course;
	}

	public void setCourse(Integer course) {
		this.course = course;
	}

	public Integer getstudent() {
		return student;
	}

	public void setstudent(Integer student) {
		this.student = student;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(course, student);
	}
	
	
	// if (a == b) -> comparar objetos
	@Override
	public boolean equals(Object obj) {
		// Si es el mismo
		if(this == obj)
			return true;
		// Si el obj es null
		if(obj == null || getClass() != obj.getClass())
			return false;
		// verificar los atributos iguales
		//Cast
		DetailCourseStudentId detailCourseStudentId = (DetailCourseStudentId)obj;
		
		if(this.student != detailCourseStudentId.student)
			return false;
		
		if(this.course != detailCourseStudentId.course)
			return false;
		return true;
	}	
	
	
	
	
}
