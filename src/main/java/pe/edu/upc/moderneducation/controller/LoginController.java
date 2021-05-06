package pe.edu.upc.moderneducation.controller;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.moderneducation.models.entities.User;
import pe.edu.upc.moderneducation.serviceimpl.UserServiceImpl;

@Named
@RequestScoped
public class LoginController  {
	@Inject
	private UserServiceImpl uService;
	
	private User user;
	
	@PostConstruct
	public void init() {
		this.user=new User();
	}
	
	public String authentication() {
		String redirect=null;
		try {
			Optional<User> userFound=this.uService.authentication(user);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userFound.get());
			redirect="/panel?faces-redirect=true";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return redirect;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
