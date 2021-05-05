package pe.edu.upc.moderneducation.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.moderneducation.models.entities.Chapter;
import pe.edu.upc.moderneducation.service.IChapterService;

@Named
@RequestScoped
public class ChapterController {
	@Inject
	private IChapterService rService; 
	
	//variables
	private Chapter chapter;
	List<Chapter>listaChapter;
	
	//constructores
	@PostConstruct 
	public void init() {
		this.chapter=new Chapter();
		this.listaChapter=new ArrayList<Chapter>();	
		this.list();
	}
	//metodos especializados
	public String newChapter() {
		this.setChapter(new Chapter());
		return "Chapter.xhtml";
	}
	public void insert(Integer idCourse) {
		try {
			rService.insert(chapter, idCourse);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al insertar en el controller el chapter");
		}
	}
	public void list() {
		try {
			listaChapter=rService.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar en el controller de chapter");
		}
	}
	public void delet(Chapter re) {
		try {
			rService.delete(re.getId());
			this.list();
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
	
}
