package pe.edu.upc.moderneducation.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.moderneducation.dao.ICourseDao;
import pe.edu.upc.moderneducation.models.entities.Course;
import pe.edu.upc.moderneducation.models.entities.Teacher;

public class CourseDaoImpl implements ICourseDao {

	@PersistenceContext(unitName="moderneducationPU")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Course co, Integer idTeacher) {
		// TODO Auto-generated method stub
		try {
			Teacher te=em.getReference(Teacher.class, idTeacher);
			co.setTeacher(te);
			em.persist(co);
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("Error al insertar un curso");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> list() {
		// TODO Auto-generated method stub
		List<Course> list=new ArrayList<Course>();
		try {
			Query q=em.createQuery("from Course c ORDER BY c.id ASC");
			list=(List<Course>)q.getResultList();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al listar cursos");
		}
		return list;
	}

	@Transactional	
	@Override
	public void delete(int idCourse) {
		// TODO Auto-generated method stub
		Course co=new Course();
		try {
			co=em.getReference(Course.class, idCourse);
			em.remove(co);
		}
		catch(Exception e) {
			System.out.println("Error al eliminar un curso");
		}
	}
	
	@Transactional
	@Override
	public Integer update(Course co) {
		// TODO Auto-generated method stub
		try {
			co.setTeacher(em.getReference(Teacher.class, co.getTeacher().getId()));
			em.merge(co);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al actualizar el curso");
		}
		return co.getId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findByTeacher(Teacher teacher){
		List<Course> list = new ArrayList<Course>();
		try {
			Teacher te = em.getReference(Teacher.class, teacher.getId());
			Query q = em.createQuery("select c from Course c where c.teacher = ?1 ORDER BY c.id ASC");
			q.setParameter(1, te);
			list = (List<Course>) q.getResultList();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}

	@Override
	public Course findCourseById(Integer idCourse) {
		Course co = new Course();
		try {
			co = em.find(Course.class, idCourse);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return co;
	}
}

	
