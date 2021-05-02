package pe.edu.upc.moderneducation.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.moderneducation.dao.IChapterDao;
import pe.edu.upc.moderneducation.models.entities.Chapter;

public class ChapterDaoImpl implements IChapterDao {

	//dandole acceso a todos los metodos de esta clase para que accedan a la conexion 
	@PersistenceContext(unitName = "moderneducationPU")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Chapter chap) {
		// TODO Auto-generated method stub
		try {
			em.persist(chap);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Error al insertar Region en el dao");
		}
	}

	@Override
	public List<Chapter> list() {
		// TODO Auto-generated method stub
		List<Chapter> lista=new ArrayList<Chapter>();
		try {
			Query q=em.createQuery("from Chapter C");
			lista=(List<Chapter>)q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Error al listar Region en el dao");
		}
		return null;
	}

	@Transactional
	@Override
	public void delete(int chapter_id) {
		// TODO Auto-generated method stub
		Chapter chapt=new Chapter();
		try {
			chapt=em.getReference(Chapter.class, chapter_id);
			em.remove(chapt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Error al insertar Region en el dao");
		}
	}

}
