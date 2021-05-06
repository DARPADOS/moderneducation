package pe.edu.upc.moderneducation.service;

import java.util.List;

import pe.edu.upc.moderneducation.models.entities.Resource;

public interface IResourceService {
	public void insert(Resource res);
	
	List<Resource> list();
	
	public void delete(int resource_id);
}
