package pe.edu.upc.moderneducation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.moderneducation.models.entities.Course;
import pe.edu.upc.moderneducation.models.entities.Resource;
import pe.edu.upc.moderneducation.service.IResourceService;

@Named
@RequestScoped
public class ResourceController {
	@Inject
	private IResourceService rService;
	
	//variables
	private Resource resource;
	
	//Constructores
	List<Resource>listaResource;
	
	@PostConstruct
	public void init() {
		this.resource=new Resource();
		this.listaResource=new ArrayList<Resource>();
		this.list();
	}
	
	//métodos especializados
	
	public String newResource() {
		this.setResource(new Resource());
		return "resources.xhtml";
	}
	
	public void insert() {
		try {
			
			Course co = (Course) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("updateCourse");
			
			resource.setCourse(co);
			
			rService.insert(resource);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al insertar en el controller de resource");
		}
	}
	
	public void list() {
		try {
			listaResource =rService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de resource");
		}
	}
	
	public void delete(Resource re) {
		try {
			rService.delete(re.getId());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de resource");
		}
	}
	
	//get y set
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource=resource;
	}
	public List<Resource> getListaResource(){
		return listaResource;
	}
	public void setListaResources(List<Resource> listaResource){
		this.listaResource=listaResource;
	}
}
