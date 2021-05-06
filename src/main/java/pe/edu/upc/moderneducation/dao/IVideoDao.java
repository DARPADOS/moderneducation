package pe.edu.upc.moderneducation.dao;

import java.util.List;

import pe.edu.upc.moderneducation.models.entities.Video;

public interface IVideoDao {

	public void insert(Video vid);

	public List<Video> list();
	
	public void delete(int id);
	
	public List<Video> findByChapter(Integer idChapter);
	/*public void update(Video vid);*/
}
