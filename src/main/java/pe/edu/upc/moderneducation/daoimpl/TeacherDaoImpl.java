package pe.edu.upc.moderneducation.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.moderneducation.dao.ITeacherDao;
import pe.edu.upc.moderneducation.models.entities.Teacher;

public class TeacherDaoImpl implements ITeacherDao{

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Teacher te) {
		try {
			em.persist(te);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("Error al insertar en el dao del teacher");
		}
	}

	@Override
	public Teacher findById(Integer id) {
		Teacher te = new Teacher();
		try {
			te = em.find(Teacher.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al buscar po id en el dao del teacher");
		}
		
		return te;
	}

	@Transactional
	@Override
	public void update(Teacher te) {
		try {
			em.merge(te);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al actualizar en el dao del teacher");
		}
	}

}
