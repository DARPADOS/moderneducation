package pe.edu.upc.moderneducation.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.moderneducation.dao.IResourceDao;
import pe.edu.upc.moderneducation.models.entities.Resource;

public class ResourceDaoImpl implements IResourceDao{

	@PersistenceContext(unitName = "moderneducationPU")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Resource res) {
		try {
			em.persist(res);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al insertar Recurso en el dao");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> list() {
		List<Resource> lista = new ArrayList<Resource>();
		try {
			Query q = em.createQuery("from Resource e");
			lista = (List<Resource>)q.getResultList();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al listar en el dao");
		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int resource_id) {
		Resource re = new Resource();
		try {
			re=em.getReference(Resource.class, resource_id);
			em.remove(re);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
