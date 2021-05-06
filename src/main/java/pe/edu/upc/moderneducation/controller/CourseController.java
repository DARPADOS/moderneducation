package pe.edu.upc.moderneducation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.moderneducation.models.entities.Course;
import pe.edu.upc.moderneducation.models.entities.Teacher;

import pe.edu.upc.moderneducation.service.ICourseService;

@Named
@RequestScoped
public class CourseController {
	@Inject
	private ICourseService cService;
	private Course course;
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
	
	public String updateCourse(Integer idCourse) {
		//System.out.println("pre co" + co.getTeacher());
		//this.setCourse(co);
		//System.out.println("post co" + course.getTeacher());
		Course co = cService.findCourseById(idCourse);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("updateCourse", co);
				
		return "testUpdate.xhtml";
	}
	
	public Course getUpdateCourseFacesContext() {
		Course co = (Course) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("updateCourse");
		return co;
	}
	
	public void insert(Integer idTeacher) {
		try {
			//course.setId(idCourse);
			course.setMineture_image("450_1000.jpg");
			cService.insert(course,idTeacher);
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
	// Cambiar a teacher cuando se implemente
	public List<Course> findByTeacher(Integer idTeacher){
		try {
			Teacher te = new Teacher();
			te.setId(idTeacher);
			this.listCourse = cService.findByTeacher(te);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return this.listCourse;
	}

	public void delete(Course co) {
		try {
			cService.delete(co.getId());
			this.list();
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("idCourse");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al eliminar en el controller de curso");
		}
	}
	
	public void update() {
		try {
			cService.update(this.getUpdateCourseFacesContext());
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
