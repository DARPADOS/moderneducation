package pe.edu.upc.moderneducation.models.entities;

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
import javax.persistence.Table;

@Entity
@Table(name = "Course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id", columnDefinition = "NUMERIC(6)")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id", nullable = false)
	private Teacher teacher;
	
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "lenguage", length = 20, nullable = false)
	private String language;
	
	@Column(name = "description", length = 250, nullable = false)
	private String description;
	
	@Column(name = "mineture_image", length = 500, nullable = false)
	private String mineture_image;

	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
	private List<Chapter> chapter;
	
	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
	private List<Resource> resource;
}
