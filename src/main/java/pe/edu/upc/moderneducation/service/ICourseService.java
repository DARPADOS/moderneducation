package pe.edu.upc.moderneducation.service;

import java.util.List;

import pe.edu.upc.moderneducation.models.entities.Course;
import pe.edu.upc.moderneducation.models.entities.Teacher;

public interface ICourseService {
	public void insert(Course co, Integer idTeacher);
	List<Course> list();
	public void delete(int idCourse);
	public Integer update(Course co);
	public List<Course> findByTeacher(Teacher teacher);
	public Course findCourseById(Integer idCourse);
}
