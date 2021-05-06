package pe.edu.upc.moderneducation.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.moderneducation.dao.IResourceDao;
import pe.edu.upc.moderneducation.models.entities.Resource;
import pe.edu.upc.moderneducation.service.IResourceService;

@Named
@RequestScoped
public class ResourceServiceImpl implements IResourceService{

	@Inject
	private IResourceDao rDao;
	
	@Override
	public void insert(Resource res) {
		rDao.insert(res);
	}

	@Override
	public List<Resource> list() {
		return rDao.list();
	}

	@Override
	public void delete(int resource_id) {
		rDao.delete(resource_id);
	}

}
