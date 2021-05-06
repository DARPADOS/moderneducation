package pe.edu.upc.moderneducation.service;

import java.util.Optional;

import pe.edu.upc.moderneducation.models.entities.User;

public interface IUserService {
	Integer insert(User user) throws Exception;

	Optional<User> authentication(User user) throws Exception;

	Optional<User> getOne(User t) throws Exception;
}
