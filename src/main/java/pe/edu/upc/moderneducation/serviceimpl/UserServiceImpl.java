package pe.edu.upc.moderneducation.serviceimpl;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import org.mindrot.jbcrypt.BCrypt;

import pe.edu.upc.moderneducation.dao.IUserDao;
import pe.edu.upc.moderneducation.models.entities.User;
import pe.edu.upc.moderneducation.service.IUserService;

@Named
public class UserServiceImpl implements IUserService {

	@Inject
	private IUserDao uDao;
	
	@Transactional
	@Override
	public Integer insert(User user) throws Exception {
		// TODO Auto-generated method stub
		return uDao.insert(user);
	}

	@Override
	public Optional<User> getOne(User t) throws Exception {
		return uDao.findById(t);
	}
	
	public Optional<User> authentication(User user) throws Exception{
		String password=user.getPassword();
		String passwordHash=uDao.getPassworHashedByUserName(user.getUserName());
		
		if (BCrypt.checkpw(password,passwordHash)) {
			user.setPassword(passwordHash);
			return uDao.findUserByUsername(user);
		}
		return Optional.of(new User());
	}

}
