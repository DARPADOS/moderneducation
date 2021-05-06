package pe.edu.upc.moderneducation.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import pe.edu.upc.moderneducation.models.entities.Student;
import pe.edu.upc.moderneducation.models.entities.Teacher;
import pe.edu.upc.moderneducation.models.entities.User;
import pe.edu.upc.moderneducation.service.IUserService;

@Named
@RequestScoped
public class RegisterController {
	@Inject 
	private IUserService uService;
	//private IStudentService sService;
	//private ITeacherService sService;

	private Student student;
	private Teacher teacher;
	private User user;
	
	@PostConstruct
	public void init() {
		this.user=new User();
	}
	
	public String registerUser() {
		String redirect = null;
		try {
			String password=this.user.getPassword();
			String passwordHash=BCrypt.hashpw(password, BCrypt.gensalt());
			this.user.setPassword(passwordHash);
			this.teacher.setUser(user);
			this.student.setUser(user);
			//AGREGAR
			redirect = "index?faces-redirect=true";

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrer controller we");
		}
		return redirect;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
