package pe.edu.upc.moderneducation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import pe.edu.upc.moderneducation.models.entities.Course;
import pe.edu.upc.moderneducation.models.entities.Teacher;

import pe.edu.upc.moderneducation.service.ICourseService;

@Named
@RequestScoped
public class CourseController {
	@Inject
	private ICourseService cService;
	private Course course;
	private Teacher teacher;
	List<Course> listCourse;
	
	@PostConstruct
	public void init() {
		this.course=new Course();
		this.listCourse=new ArrayList<Course>();
		this.list();
	}
	
	public String newCourse() {
		this.setCourse(new Course());
		return "course.xhtml";
	}
	
	public void insert(Integer idCourse) {
		try {
			//course.setId(idCourse);
			cService.insert(course,idCourse);
		}
		catch(Exception e){
			System.out.println("Error al insertar en el controller de curso");
		}
	}
	
	public void list() {
		try {
			listCourse= cService.list();
		}
		catch(Exception e) {
			System.out.println("Error al listar en el controller de curso");
		}
	}

	public void delete(Course co) {
		try {
			cService.delete(co.getId());
			this.list();
		}
		catch(Exception e) {
			System.out.println("Error al eliminar en el controller de curso");
		}
	}
	
	public void update(Course co) {
		try {
			cService.update(co);
		}
		catch(Exception e) {
			System.out.println("Error al actualizar en el controller de curso");
		}
	}
	
	public ICourseService getcService() {
		return cService;
	}

	public void setcService(ICourseService cService) {
		this.cService = cService;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Course> getListCourse() {
		return listCourse;
	}

	public void setListCourse(List<Course> listCourse) {
		this.listCourse = listCourse;
	}
	
	
	
}
