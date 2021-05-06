package pe.edu.upc.moderneducation.daoimpl;

import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.edu.upc.moderneducation.dao.IUserDao;
import pe.edu.upc.moderneducation.models.entities.User;

@Named
public class UserDaoImpl implements IUserDao {
	@PersistenceContext(unitName = "moderneducationPU")
	private EntityManager em;
	
	@Transactional
	@Override
	public Integer insert(User user) throws Exception {
		// TODO Auto-generated method stub
		em.persist(user);
		return user.getId();
	}

	@Override
	public Optional<User> findById(User u) throws Exception {
		// TODO Auto-generated method stub
		User user;
		TypedQuery<User> q=em.createQuery("SELECT u FROM User u WHERE u.user_id=?1", User.class);
		q.setParameter(1, u.getId());
		user=q.getSingleResult();
		return Optional.of(user);
	}

	@Override
	public String getPassworHashedByUserName(String username) throws Exception {
		// TODO Auto-generated method stub
		User user=new User();
		try {
			Query q=em.createQuery("FROM User u WHERE u.userName= ?1");
			q.setParameter(1, username);
			@SuppressWarnings("unchecked")
			List<User> lista=q.getResultList();
			if (!lista.isEmpty()) {
				user=lista.get(0);
			}
		}
		catch(Exception e) {
			throw e;
		}
		return user!=null? user.getPassword():"";
	}

	@Override
	public Optional<User> findUserByUsername(User user) throws Exception {
		// TODO Auto-generated method stub
		User userFound;
		TypedQuery<User> q=em.createQuery("FROM User u WHERE u.userName = ?1 and u.password =?2", User.class);
		q.setParameter(1, user.getUserName());
		q.setParameter(2, user.getPassword());
		
		userFound=q.getSingleResult();
		return Optional.of(userFound);
	}
 	
}
