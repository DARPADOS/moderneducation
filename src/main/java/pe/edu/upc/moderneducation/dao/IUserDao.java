package pe.edu.upc.moderneducation.dao;

import java.util.Optional;

import pe.edu.upc.moderneducation.models.entities.User;

public interface IUserDao {
	Integer insert(User user) throws Exception;

	Optional<User> findById(User user) throws Exception;

	String getPassworHashedByUserName(String username) throws Exception;

	Optional<User> findUserByUsername(User user) throws Exception;

}
