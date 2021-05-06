package pe.edu.upc.moderneducation.serviceimpl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.moderneducation.dao.ITeacherDao;
import pe.edu.upc.moderneducation.models.entities.Teacher;
import pe.edu.upc.moderneducation.service.ITeacherService;

@Named
@RequestScoped
public class TeacherServiceImpl implements ITeacherService {

	@Inject
	private ITeacherDao tDao;
	
	@Override
	public void insert(Teacher te) {
		tDao.insert(te);
	}

	@Override
	public void update(Teacher te) {
		tDao.update(te);
	}

	@Override
	public Teacher findById(Integer id) {
		return tDao.findById(id);
	}

}
