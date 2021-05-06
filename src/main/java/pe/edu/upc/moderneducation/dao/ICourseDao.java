package pe.edu.upc.moderneducation.dao;

import java.util.List;

import pe.edu.upc.moderneducation.models.entities.Course;
import pe.edu.upc.moderneducation.models.entities.Teacher;

public interface ICourseDao {
	public void insert(Course reg, Integer idTeacher);
	public List<Course>list();
	public void delete(int idCourse);
	public Integer update(Course reg);
	public List<Course> findByTeacher(Teacher teacher);
	public Course findCourseById(Integer idCourse);
}