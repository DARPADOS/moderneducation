package pe.edu.upc.moderneducation.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.moderneducation.dao.IVideoDao;
import pe.edu.upc.moderneducation.models.entities.Video;

public class VideoDaolmpl implements IVideoDao{
	@PersistenceContext(unitName ="moderneducationPU")
	private EntityManager em;
	@Transactional
	@Override
	public void insert(Video vid) {
		try {
			em.persist(vid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al insertar Video en el DAO");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> list() {
		List<Video> lista=new ArrayList<Video>();
		
		try {
			Query q= em.createQuery("from Video r");
			lista=(List<Video>)q.getResultList();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void delete(int id) {
		Video vi=new Video();
		try {
			vi=em.getReference(Video.class, id);
			em.remove(vi);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
