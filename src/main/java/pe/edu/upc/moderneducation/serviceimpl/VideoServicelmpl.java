package pe.edu.upc.moderneducation.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.moderneducation.dao.IVideoDao;
import pe.edu.upc.moderneducation.models.entities.Video;
import pe.edu.upc.moderneducation.service.IVideoService;


@Named
@RequestScoped
public class VideoServicelmpl implements IVideoService {
	@Inject
	private IVideoDao vDao;

	@Override
	public void insert(Video vid) {
		vDao.insert(vid);
	}

	@Override
	public List<Video> list() {
		return vDao.list();
	}

	@Override
	public void delete(int id) {
		vDao.delete(id);
	}

}
