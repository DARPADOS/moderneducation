package pe.edu.upc.moderneducation.models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Assistance {
	
	@Id
	@ManyToOne
	@JoinColumn(name="videconference_id",nullable=false)
	private Videoconference videoconference;
	
	@ManyToOne
	@JoinColumn(name="student_id",nullable=false)
	private Student student;
}
