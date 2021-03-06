package pe.edu.upc.moderneducation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.moderneducation.models.entities.Chapter;
import pe.edu.upc.moderneducation.models.entities.Video;
import pe.edu.upc.moderneducation.service.IVideoService;

@Named
@RequestScoped
public class VideoController {
	@Inject
	private IVideoService vService;
	
	private Video video;
	
	List<Video>listaVideos;
/*constructores*/
	
	@PostConstruct
	public void init() {
		this.video=new Video();
		this.listaVideos=new ArrayList<Video>();
		this.listVideoByChapter();
	}
	
	
	
/*m?todos especializados*/
	
	public String newVideo() {
		this.setVideo(new Video());
		return "video.xhtml";
	}
	
	public void listVideoByChapter() {
		listaVideos = vService.findByChapter(getActualChapter().getId());
	}
	
	public Chapter getActualChapter() {
		return (Chapter) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("actualChapter");
	}
	
	public void insert() {
		try {
			Chapter chap = this.getActualChapter();
			video.setChapter(chap);
			vService.insert(video);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de video");
		}
	}

	public void list() {
		try {
			listaVideos=vService.list();
		} catch (Exception e) {
			System.out.println("Error al listar los videos");
		}
	}
	
	public void delet(Video vi) {
		try {
			vService.delete(vi.getId());
		} catch (Exception e) {
			System.out.println("Error al eliminar el video");
		}
	}
	
/*getter y setter*/	
	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public List<Video> getListaVideos() {
		return listaVideos;
	}

	public void setListaVideos(List<Video> listaVideos) {
		this.listaVideos = listaVideos;
	}
	
}
