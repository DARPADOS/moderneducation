package pe.edu.upc.moderneducation.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.moderneducation.dao.ICourseDao;
import pe.edu.upc.moderneducation.models.entities.Course;
import pe.edu.upc.moderneducation.models.entities.Teacher;
import pe.edu.upc.moderneducation.service.ICourseService;

@Named
@RequestScoped
public class CourseServiceImpl implements ICourseService{
	@Inject
	private ICourseDao cDao;

	@Override
	public void insert(Course co, Integer idTeacher) {
		// TODO Auto-generated method stub
		cDao.insert(co, idTeacher);
	}

	@Override
	public List<Course> list() {
		// TODO Auto-generated method stub
		return cDao.list();
	}

	@Override
	public void delete(int idCourse) {
		// TODO Auto-generated method stub
		cDao.delete(idCourse);
		
	}

	@Override
	public Integer update(Course co) {
		// TODO Auto-generated method stub
		return cDao.update(co);
	}
	
	@Override
	public List<Course> findByTeacher(Teacher teacher){
		return cDao.findByTeacher(teacher);
	}
	
	@Override
	public Course findCourseById(Integer idCourse) {
		return cDao.findCourseById(idCourse);
	}
}
