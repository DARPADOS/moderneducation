package pe.edu.upc.moderneducation.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Resource")
public class Resource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resource_id", columnDefinition = "NUMERIC(6)")
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
}
