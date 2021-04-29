package pe.edu.upc.moderneducation.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Resource")

@SequenceGenerator(name="Resource_resource_id_seq",initialValue=1,allocationSize = 1)

public class Resource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Resource_resource_id_seq")
	@Column(name = "resource_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;
	
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "type", length = 10, nullable = false)
	private String type;
	
	@Column(name = "link", length = 100, nullable = false)
	private String link;

	public Resource(Integer id, Course course, String name, String type, String link) {
		super();
		this.id = id;
		this.course = course;
		this.name = name;
		this.type = type;
		this.link = link;
	}

	public Resource() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
}
