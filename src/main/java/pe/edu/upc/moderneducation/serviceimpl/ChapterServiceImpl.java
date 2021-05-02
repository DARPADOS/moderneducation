package pe.edu.upc.moderneducation.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.moderneducation.dao.IChapterDao;
import pe.edu.upc.moderneducation.models.entities.Chapter;
import pe.edu.upc.moderneducation.service.IChapterService;

@Named 
@RequestScoped 
public class ChapterServiceImpl implements IChapterService{
	@Inject
	private IChapterDao rDao;
	@Override
	public void insert(Chapter chap) {
		// TODO Auto-generated method stub
		rDao.insert(chap);
	}
	@Override
	public List<Chapter> list() {
		// TODO Auto-generated method stub
		return rDao.list();
	}
	@Override
	public void delete(int chapter_id) {
		// TODO Auto-generated method stub
		rDao.delete(chapter_id);
	}

}
