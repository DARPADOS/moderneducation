package pe.edu.upc.moderneducation.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="user_id",columnDefinition="NUMERIC(6)")
	private Integer id;
	
	@Column(name="user_name",length=20,nullable=false)
	private String userName;
	
	@Column(name="password", length=16,nullable=false)
	private String password;
	
	@Column(name="first_name", length=100,nullable=false)	
	private String firstName;
	
	@Column(name="last_name", length=100,nullable=false)	
	private String lastName;
	
	@Column(name="email", length=50, nullable=false)
	private String email;
	
	@Column(name="profile_image", length=500, nullable=false)
	private String profileImage;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="id")
	private Teacher teacher;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="id")
	private Student student;
	
	//@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	//private List<Comment> comments;
	
}
