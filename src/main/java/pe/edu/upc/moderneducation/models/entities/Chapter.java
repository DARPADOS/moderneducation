package pe.edu.upc.moderneducation.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Chapter")
@SequenceGenerator(name="Chapter_chapter_id_seq",initialValue=1, allocationSize=1)
public class Chapter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Chapter_chapter_id_seq")
	@Column(name = "chapter_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;
	
	@Column(name = "name", length = 25, nullable = false)
	private String name;

	@Column(name = "description", length = 25, nullable = false)
	private String description;
	
	@OneToMany(mappedBy = "chapter", fetch =  FetchType.LAZY)
	private List<Video> videos;
	
	public Chapter() {
		super();
		videos=new ArrayList<Video>();
		// TODO Auto-generated constructor stub
	}

	public Chapter(Integer id, Course course, String name, String description, List<Video> videos) {
		super();
		this.id = id;
		this.course = course;
		this.name = name;
		this.description = description;
		this.videos = videos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
}
