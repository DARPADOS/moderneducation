package pe.edu.upc.moderneducation.dao;

import pe.edu.upc.moderneducation.models.entities.Teacher;

public interface ITeacherDao {
	
	public void insert(Teacher te);
	public Teacher findById(Integer id);
	public void update(Teacher te);
}
