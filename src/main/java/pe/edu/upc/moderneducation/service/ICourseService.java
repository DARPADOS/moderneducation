package pe.edu.upc.moderneducation.service;

import java.util.List;

import pe.edu.upc.moderneducation.models.entities.Course;

public interface ICourseService {
	public void insert(Course co, Integer idTeacher);
	List<Course> list();
	public void delete(int idCourse);
	public Integer update(Course co);
}
