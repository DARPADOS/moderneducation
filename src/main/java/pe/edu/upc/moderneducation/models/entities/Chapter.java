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
@Table(name = "Chapter")
public class Chapter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chapter_id", columnDefinition = "NUMERIC(6)")
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
}
