package pe.edu.upc.moderneducation.service;

import java.util.List;

import pe.edu.upc.moderneducation.models.entities.Video;

public interface IVideoService {
	public void insert(Video vid);

	List<Video> list();

	public void delete(int id);
}
