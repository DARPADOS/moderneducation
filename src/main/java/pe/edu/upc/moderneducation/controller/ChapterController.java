package pe.edu.upc.moderneducation.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.moderneducation.models.entities.Chapter;
import pe.edu.upc.moderneducation.models.entities.Course;
import pe.edu.upc.moderneducation.service.IChapterService;
import pe.edu.upc.moderneducation.service.ICourseService;

@Named
@RequestScoped
public class ChapterController {
	@Inject
	private IChapterService rService; 
	@Inject
	private ICourseService cService;
	//variables
	private Chapter chapter;
	List<Chapter>listaChapter;
	List<Course>listaCourse;
	
	//constructores
	@PostConstruct 
	public void init() {
		this.chapter=new Chapter();
		this.listaChapter=new ArrayList<Chapter>();	
		this.listaCourse=new ArrayList<Course>();
		this.listChapter();
		this.listCourse();
	}
	//metodos especializados
	public String newChapter() {
		this.setChapter(new Chapter());
		return "Chapter.xhtml";
	}
	public void insert() {
		try {
			rService.insert(chapter);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al insertar en el controller el chapter");
		}
	}
	public void listChapter() {
		try {
			listaChapter=rService.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar en el controller de chapter");
		}
	}
	public void listCourse(){
		try {
			listaCourse=cService.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar en el controller de chapter");
		}
	}
	public void delet(Chapter re) {
		try {
			rService.delete(re.getId());
			this.listChapter();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al eliminar en el controller de chapter");
		}
	}
	
	//get y set
	public Chapter getChapter() {
		return chapter;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	public List<Chapter> getListaChapter() {
		return listaChapter;
	}
	public void setListaChapter(List<Chapter> listaChapter) {
		this.listaChapter = listaChapter;
	}
	public List<Course> getListaCourse() {
		return listaCourse;
	}
	public void setListaCourse(List<Course> listaCourse) {
		this.listaCourse = listaCourse;
	}
	
}
