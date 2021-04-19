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
@Table(name="Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id",columnDefinition = "NUMERIC(6)")
	private Integer id;
	
	@Column(name="premium")
	private Boolean premium;
	
	@OneToOne(mappedBy="student")
	private User user;
	
	@OneToMany(mappedBy="student", fetch=FetchType.LAZY)
	private List<Assistance> assistances;
	
	//@OneToMany(mappepBy="student")
	//private List<DetailCourseStudent> detailcourseStudents;
	
}
