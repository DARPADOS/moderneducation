package pe.edu.upc.moderneducation.dao;

import java.util.List;

import pe.edu.upc.moderneducation.models.entities.Resource;

public interface IResourceDao {
	
	public void insert(Resource res);

	public List<Resource> list();
	
	public void delete(int resource_id);
}
