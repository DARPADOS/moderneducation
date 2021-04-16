package pe.edu.upc.moderneducation.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Teacher")

public class Teacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teacher_id",columnDefinition="NUMERIC(6)")
	private Integer id;
	
	@Column(name="occupation",length=100, nullable=false)
	private String occupation;
	
	@Column(name="career", length=100, nullable=false)
	private String career;
	
	@Column(name="description",length=200,nullable=false)
	private String description;

	@OneToOne(mappedBy="teacher")
	private User user;
	
	//@OneToMany(mappedBy="teacher",fetch=FetchType.LAZY)
	//private List<Course> courses;
	
	//@OneToMany(mappedBy="teacher",fetch=FetchType.LAZY)
	//private List<Videoconferce> videoconferences;
	
}
