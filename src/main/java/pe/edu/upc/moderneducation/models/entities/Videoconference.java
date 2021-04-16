package pe.edu.upc.moderneducation.models.entities;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Videoconference")

public class Videoconference {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="videoconference_id",columnDefinition="NUMERIC(6)")
	private Integer id;
	
	@Column(name="name",length=100,nullable=false)
	private String name;
	
	@Column(name="description",length=250)
	private String description;
	
	@Column(name="meet_link",length=100)
	private String meetLink;
	
	@Column(name="date_start")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateStart;
	
	@Column(name="date_end")
	@Temporal(TemporalType.TIMESTAMP)	
	private Date dateEnd;
	
	@ManyToOne
	@JoinColumn(name="teacher_id",nullable=false)
	private Teacher teacher;
	
	@OneToMany(mappedBy="videoconference",fetch=FetchType.LAZY)
	private List<Assistance> assistances;
}
